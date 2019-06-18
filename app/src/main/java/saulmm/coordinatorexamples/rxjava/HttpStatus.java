package saulmm.coordinatorexamples.rxjava;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/6/17 3:34 PM
 * @desc :
 */
public class HttpStatus {

    public int code;

    public String message;

    private static final int SUCCESS = 0;


    public boolean isCodeInvalid() {
        return code != 0;
    }

}
