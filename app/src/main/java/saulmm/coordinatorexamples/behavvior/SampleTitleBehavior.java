package saulmm.coordinatorexamples.behavvior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/6/5 11:40 AM
 * @desc :
 */
public class SampleTitleBehavior extends CoordinatorLayout.Behavior<View>{

    /**
     * 列表顶部和title底部重合时,列表的滑动距离
     */
    private float deltaY;

    private static final String TAG = SampleTitleBehavior.class.getSimpleName();

    public SampleTitleBehavior() {

    }

    public SampleTitleBehavior(Context context, AttributeSet attrs) {
        super(context,attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof RecyclerView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        Log.i(TAG,"onDependentViewChanged deltaY: " + deltaY);

        if(deltaY == 0) {
            deltaY = dependency.getY() - child.getHeight();
        }
        float dy = dependency.getY() - child.getHeight();


        Log.i(TAG,"onDependentViewChanged deltaY: " + deltaY + " dy: " + dy);

        dy = dy < 0 ? 0 : dy;
        float y = - (dy / deltaY) * child.getHeight();
        child.setTranslationY(y);

        float alpha = 1 - (dy / deltaY);
        child.setAlpha(alpha);

        return true;
    }

}
