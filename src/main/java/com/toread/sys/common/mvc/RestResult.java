package com.toread.sys.common.mvc;

/**
 * @author 黎志兵
 */
public class RestResult {
    private Object result;
    private boolean success;
    private String msg;
    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public  static RestResult getSuccessInstance(){
        RestResult result  = new RestResult();
        result.setSuccess(true);
        result.setMsg("操作成功");
        return result;
    }
}
