package com.toread.sys.common.mvc;

import org.apache.log4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

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
        restResult.setSuccess(false);
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
        if(!(body instanceof RestResult)){
            RestResult result = RestResult.getSuccessInstance();
            result.setResult(body);
        }
        return body;
    }
}
