package com.toread.sys.common.mvc;

import com.toread.sys.common.validate.ArgumentNotValidException;
import org.apache.log4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.util.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 黎志兵
 */
@ControllerAdvice(basePackages={"com.toread.sys.controller"})
public class GlobalResultHandler  implements ResponseBodyAdvice {
    protected static final Logger LOGGER = Logger.getLogger(GlobalResultHandler.class);

    /**
     * 处理系统所有异常
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler({ Exception.class })
    @ResponseBody
    protected RestResult handleInvalidRequest(HttpServletRequest request, Exception e) {
        LOGGER.error(e.getMessage(),e);
        RestResult restResult = new RestResult();
        String msg = StringUtils.hasText(e.getMessage())?e.getMessage():"操作失败";
        restResult.setMsg(msg);
        restResult.setOperateResult(RestResult.OperateResult.FAIL);
        return restResult;
    }


    @ExceptionHandler({ MethodArgumentNotValidException.class, ArgumentNotValidException.class})
    @ResponseBody
    protected RestResult handleMethodArgumentNotValidException(HttpServletRequest request, Exception e) {
        LOGGER.error(e.getMessage(),e);
        RestResult restResult = RestResult.getSuccessInstance();
        if(e instanceof  MethodArgumentNotValidException){
            MethodArgumentNotValidException notValidException = (MethodArgumentNotValidException)e;
            restResult.setMsg("验证失败");
            if(notValidException.getBindingResult().hasFieldErrors()){
                List<RestResult.FiledError> errorList = new ArrayList<>();
                List<FieldError> message = notValidException.getBindingResult().getFieldErrors();
                for (FieldError fieldError : message) {
                    RestResult.FiledError filedError = new RestResult.FiledError();
                    filedError.setErrorMsg(fieldError.getDefaultMessage());
                    filedError.setFiledName(fieldError.getField());
                    filedError.setObjectName(fieldError.getObjectName());
                    errorList.add(filedError);
                }
                restResult.setMsg(errorList);
            }
        }else if(e instanceof ArgumentNotValidException){
            restResult.setMsg(((ArgumentNotValidException) e).getFiledError());
        }
        restResult.setOperateResult(RestResult.OperateResult.FAIL);
        restResult.setErrorType(RestResult.ErrorType.VALIDATION_ERROR);
        return restResult;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        Boolean isRest = AnnotationUtils.isAnnotationDeclaredLocally(RestController.class, returnType.getContainingClass());
        RequestMapping requestMapping = AnnotationUtils.findAnnotation(returnType.getMethod(),RequestMapping.class);
        if(isRest||requestMapping!=null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if(body instanceof RestResult){return  body;}
        else{
            RestResult result = RestResult.getSuccessInstance();
            result.setData(body);
            return  result;
        }
    }
}
