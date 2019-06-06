package saulmm.coordinatorexamples.behavvior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/6/5 2:52 PM
 * @desc :
 */
public class RecyclerViewBehavior extends CoordinatorLayout.Behavior<View>{

    private static final String TAG = RecyclerViewBehavior.class.getSimpleName();

    public RecyclerViewBehavior() {

    }

    public RecyclerViewBehavior(Context context, AttributeSet attrs) {
        super(context,attrs);
    }


    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof TextView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        float y = dependency.getHeight() + dependency.getTranslationY();
        Log.i(TAG,"y: " + y + " translationY: " + dependency.getTranslationY());

        if(y < 0) {
            y = 0;
        }
        child.setY(y);
        return true;
    }

}
