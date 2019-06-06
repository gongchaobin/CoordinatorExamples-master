package saulmm.coordinatorexamples.behavvior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/6/5 2:23 PM
 * @desc :
 */
public class SampleHeaderBehavior extends CoordinatorLayout.Behavior<View>{

    private boolean upReach;
    private boolean downReach;
    private int lastPostion = -1;

    private static final String TAG = SampleHeaderBehavior.class.getSimpleName();

    public SampleHeaderBehavior() {

    }

    public SampleHeaderBehavior(Context context, AttributeSet attrs) {
        super(context,attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, View child, MotionEvent ev) {
        Log.i(TAG,"onInterceptTouchEvent");
        switch (ev.getAction()) {
            case MotionEvent.ACTION_MOVE:
                Log.i(TAG,"ACTION_MOVE");
                upReach = false;
                downReach = false;
                break;
        }
        return super.onInterceptTouchEvent(parent,child,ev);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        if(target instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) target;
            int pos = ((LinearLayoutManager)recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();

            Log.i(TAG,"pos: " + pos + " lastPostion: " + lastPostion);
            if(pos == 0 && pos < lastPostion) {
                downReach = true;
            }

            if(canScroll(child,dy) && pos == 0) {
                float finalY = child.getTranslationY() - dy;
                if(finalY < -child.getHeight()) {
                    finalY = -child.getHeight();
                    upReach = true;

                } else if(finalY > 0) {
                    finalY = 0;
                }

                child.setTranslationY(finalY);
                // 让CoordinatorLayout消费事件
                consumed[1] = dy;
            }

            lastPostion = pos;
        }
    }

    private boolean canScroll(View child,float scrollY) {
        Log.i(TAG,"scrollY: " + scrollY + " childY: " + child.getTranslationY() + " height: " + child.getHeight());
        if(scrollY > 0 && child.getTranslationY() == - child.getHeight() && !upReach) {
            return false;
        }

        if(downReach) {
            return false;
        }

        return true;
    }


}
