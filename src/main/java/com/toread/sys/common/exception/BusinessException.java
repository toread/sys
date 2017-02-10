package com.toread.sys.common.exception;

import org.springframework.util.StringUtils;

/**
 * @author 黎志兵
 */
public  class BusinessException  extends  RuntimeException{
    protected  String hintMsg;
    public BusinessException(String hintMsg) {
        this.hintMsg = hintMsg;
    }

    public BusinessException(Throwable cause, String hintMsg) {
        super(cause);
        this.hintMsg = hintMsg;
    }

    public String getHintMsg() {
        return hintMsg;
    }

    @Override
    public String toString() {
        String s = getClass().getName();
        String message ="";
        if(StringUtils.hasText(hintMsg)){
            message= getLocalizedMessage()+"hintMsg:"+hintMsg;
        }else{
            message = getLocalizedMessage();
        }
        return (message != null) ? (s + ": " + message) : s;
    }
}
