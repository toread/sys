package com.toread.sys.common.mvc;

/**
 * @author 黎志兵
 */
public class RestResult<T> {
    private T data;
    private OperateResult operateResult;
    private ErrorType errorType;
    private Object msg;

    public ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public OperateResult getOperateResult() {
        return operateResult;
    }

    public void setOperateResult(OperateResult operateResult) {
        this.operateResult = operateResult;
    }

    public  static RestResult getSuccessInstance(){
        RestResult result  = new RestResult();
        result.setOperateResult(OperateResult.SUCCESS);
        result.setMsg("操作成功");
        return result;
    }

    /**
     * 字段校验错误
     */
    public static class FiledError{
        private String objectName;
        private String filedName;
        private String errorMsg;

        public String getObjectName() {
            return objectName;
        }

        public void setObjectName(String objectName) {
            this.objectName = objectName;
        }

        public String getFiledName() {
            return filedName;
        }

        public void setFiledName(String filedName) {
            this.filedName = filedName;
        }

        public String getErrorMsg() {
            return errorMsg;
        }

        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        @Override
        public String toString() {
            return "FiledError{" +
                    "objectName='" + objectName + '\'' +
                    ", filedName='" + filedName + '\'' +
                    ", errorMsg='" + errorMsg + '\'' +
                    '}';
        }
    }

    /**
     * 错误类型
     */
    public static enum ErrorType{

        /** 系统异常*/
        SYS_ERROR,
        /**验证异常*/
        VALIDATION_ERROR,
        /***业务异常*/
        BUSINESS_ERROR,
    }

    /**
     *
     */
    public static enum OperateResult{
        /**成功*/SUCCESS,
        /**失败*/FAIL,
        /**未知*/UNKNOWN
    }

}
