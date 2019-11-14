package com.rimi.ruiFeng.common;

/**
 * @author shangzf
 * @date 2019/10/31 19:06
 */
public class DefaultResultData extends AbstractResultData {

    public DefaultResultData() {

    }

    public DefaultResultData(Object secretKey) {
        super(secretKey);
    }

    public DefaultResultData(Object secretKey,ResultCode resultCode) {
        super(secretKey,resultCode);
    }

    public DefaultResultData(ResultCode resultCode,String description) {
        super(resultCode,description);
    }

    public DefaultResultData(Object secretKey,ResultCode resultCode,String description) {
        super(secretKey,resultCode,description);
    }


    public DefaultResultData(int i , String is) {
        super(i,is);
    }
}
