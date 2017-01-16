package com.toread.sys.common.enums;

/**
 * Created by toread on 16-10-20.
 */
public enum State  implements IntEnum<State>{
    ENABLED(1,"有效"),DISABLED(0,"无效");
    private Integer code;
    private String describe;

    State(Integer code, String describe) {
        this.code = code;
        this.describe = describe;
    }

    @Override
    public Integer code() {
        return this.code;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public  static   State getState(Integer values){
        State[] states =  State.values();
        for (State state : states) {
            if(state.code.equals(values)){
             return  state;
            }
        }
        return null;
    }
}
