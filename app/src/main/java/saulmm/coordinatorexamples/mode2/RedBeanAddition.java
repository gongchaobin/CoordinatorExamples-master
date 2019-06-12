package saulmm.coordinatorexamples.mode2;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/6/12 9:45 AM
 * @desc : 定义具体装饰角色
 */
public class RedBeanAddition extends MilkAddition{


    public RedBeanAddition(IMilk milk) {
        super(milk);
    }

    /**
     * 描述
     *
     * @return
     */
    @Override
    public String getDescription() {
        return mIMilk.getDescription() + " + 红豆";
    }

    /**
     * 价格
     *
     * @return
     */
    @Override
    public double cost() {
        return mIMilk.cost() + 3;
    }
}

