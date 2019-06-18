package saulmm.coordinatorexamples.rxjava;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/6/17 3:41 PM
 * @desc :
 */
public class ApiException extends RuntimeException{

    private int errorCode;

    public ApiException(int errorCode,String errorMsg) {
        this.errorCode = errorCode;
    }

    /**
     * 判断是否是token失效
     *
     * @return 失效返回true, 否则返回false;
     */
    public boolean isTokenExpried() {
        return errorCode == 403;
    }
}
