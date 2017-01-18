package com.toread.sys.common.exception;

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
}
