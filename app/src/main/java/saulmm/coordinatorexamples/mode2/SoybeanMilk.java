package saulmm.coordinatorexamples.mode2;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/6/12 9:43 AM
 * @desc : 具体构件角色
 */
public class SoybeanMilk implements IMilk{

    /**
     * 描述
     *
     * @return
     */
    @Override
    public String getDescription() {
        return "原味";
    }

    /**
     * 价格
     *
     * @return
     */
    @Override
    public double cost() {
        return 2;
    }
}
