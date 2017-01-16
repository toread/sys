package com.toread.sys.common.validate;

import com.toread.sys.common.mvc.RestResult;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 * @author 黎志兵
 */
public class ArgumentNotValidException  extends RuntimeException{
    protected Collection<RestResult.FiledError> filedError;

    public ArgumentNotValidException(Throwable cause, Collection<RestResult.FiledError> filedError) {
        super(cause);
        this.filedError = filedError;
    }

    public ArgumentNotValidException(Collection<RestResult.FiledError> filedError) {
        this.filedError = filedError;
    }

    public Collection<RestResult.FiledError> getFiledError() {
        return filedError;
    }

    @Override
    public String toString() {
        String s = getClass().getName();
        String message ="";
        if(!CollectionUtils.isEmpty(filedError)){
            message= getLocalizedMessage()+"Valid Error:"+filedError;
        }else{
            message = getLocalizedMessage();
        }
        return (message != null) ? (s + ": " + message) : s;
    }
}
