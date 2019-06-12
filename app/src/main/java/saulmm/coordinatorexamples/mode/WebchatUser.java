package saulmm.coordinatorexamples.mode;

import android.util.Log;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/6/11 6:02 PM
 * @desc :
 */
public class WebchatUser implements IWechatUser {

    private String name;

    private static final String TAG = WebchatUser.class.getSimpleName();

    public WebchatUser(String name,IOfficialAccount officialAccount) {
        this.name = name;
        officialAccount.addSubscriber(this);
    }

    /**
     * 接受消息
     *
     * @param message
     */
    @Override
    public void onReceived(String message) {
        Log.i(TAG,"msg: " + this.name + " " + message);
    }

    /**
     * 只接收自己想要的消息
     *
     * @param iOfficialAccount
     */
    @Override
    public void onReceivedCustom(IOfficialAccount iOfficialAccount) {
        
    }
}
