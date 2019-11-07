package com.rimi.ruiFeng.common;

/**
 * @author shangzf
 * @date 2019/10/31 19:03
 */
public abstract class AbstractResultData extends AbstractResult implements ResultData {

    private Object secretKey;

    public AbstractResultData(){
        super(ResultCode.FAIL.getCode(),ResultCode.FAIL.getMessage());
    }

    public  AbstractResultData(String zt){
         super(200,ResultCode.SUCCESSC.getMessage());
    }

    public  AbstractResultData(int i1 ,String i2){
        super(i1,i2);
    }

    public AbstractResultData(Object secretKey){
        super(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage());
        this.secretKey = secretKey;
    }

    @Override
    public Object getData() {
        return secretKey;
    }

    public void setData(Object secretKey) {
        this.secretKey = secretKey;
    }
}
