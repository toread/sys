package com.toread.sys.common.enums;

/**
 * Created by toread on 16-10-20.
 */
public enum State {
    ENABLED("1","有效"),DISABLED("0","无效");
    private String code;
    private String describe;
    State(String code, String describe) {
        this.code = code;
        this.describe = describe;
    }

    public String getCode() {
        return code;
    }

    public String getDescribe() {
        return describe;
    }
}
