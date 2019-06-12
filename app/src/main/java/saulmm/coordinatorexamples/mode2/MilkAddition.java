package saulmm.coordinatorexamples.mode2;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/6/12 9:44 AM
 * @desc : 定义装饰角色
 */
public abstract class MilkAddition implements IMilk{

    protected IMilk mIMilk;

    public MilkAddition(IMilk milk) {
        mIMilk = milk;
    }

}
