package saulmm.coordinatorexamples.mode;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/6/11 6:00 PM
 * @desc : 被观察者
 */
public interface IOfficialAccount {

    /**
     * 订阅
     * @param iWechatUser
     */
    void addSubscriber(IWechatUser iWechatUser);

    /**
     * 取消订阅
     * @param iWechatUser
     */
    void removeSubscriber(IWechatUser iWechatUser);

    /**
     * 群发消息
     * @param message
     */
    void notifySubscriber(String message);

}
