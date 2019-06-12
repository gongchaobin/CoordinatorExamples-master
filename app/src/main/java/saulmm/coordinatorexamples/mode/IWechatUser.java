package saulmm.coordinatorexamples.mode;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/6/11 5:57 PM
 * @desc : 观察者
 */
public interface IWechatUser {

    /**
     * 接受消息
     * @param message
     */
    void onReceived(String message);

    /**
     * 只接收自己想要的消息
     * @param iOfficialAccount
     */
    void onReceivedCustom(IOfficialAccount iOfficialAccount);

}
