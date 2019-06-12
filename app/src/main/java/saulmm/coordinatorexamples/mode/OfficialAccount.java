package saulmm.coordinatorexamples.mode;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/6/11 6:02 PM
 * @desc :
 */
public class OfficialAccount implements IOfficialAccount {

    private String name;
    private List<IWechatUser> mIWechatUsers;

    public OfficialAccount(String name) {
        this.name = name;
        mIWechatUsers = new ArrayList<>();
    }

    /**
     * 订阅
     *
     * @param iWechatUser
     */
    @Override
    public void addSubscriber(IWechatUser iWechatUser) {
        if(!mIWechatUsers.contains(iWechatUser)) {
            mIWechatUsers.add(iWechatUser);
        }
    }

    /**
     * 取消订阅
     *
     * @param iWechatUser
     */
    @Override
    public void removeSubscriber(IWechatUser iWechatUser) {
        mIWechatUsers.remove(iWechatUser);
    }

    /**
     * 群发消息
     *
     * @param message
     */
    @Override
    public void notifySubscriber(String message) {
        for(IWechatUser wechatUser : mIWechatUsers) {
            wechatUser.onReceived(name + "-" + message);
        }
    }
}
