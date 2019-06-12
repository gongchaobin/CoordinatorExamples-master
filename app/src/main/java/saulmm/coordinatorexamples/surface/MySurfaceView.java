package saulmm.coordinatorexamples.surface;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import saulmm.coordinatorexamples.R;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/6/12 4:39 PM
 * @desc :
 */
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback , Runnable{

    private SurfaceHolder mSurfaceHolder;
    private Paint mPaint;

    private Thread mThread;

    private volatile boolean mIsDrawing;
    private Canvas mCanvas;
    private Bitmap mBitmap;

    private static final String TAG = MySurfaceView.class.getSimpleName();

    public MySurfaceView(Context context) {
        super(context);
        init(context);
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mSurfaceHolder = getHolder();
        mSurfaceHolder.addCallback(this);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
    }


    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.i(TAG,"surfaceCreated");
        mThread = new Thread(this,"Render");
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        Log.i(TAG,"surfaceChanged");
        try {
            mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_github_circle_white_24dp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mIsDrawing = true;
        mThread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Log.i(TAG,"surfaceDestroyed");
        mIsDrawing = false;
        mThread.interrupt();
        mSurfaceHolder.removeCallback(this);

    }

    @Override
    public void run() {
        while (mIsDrawing) {
            mCanvas = mSurfaceHolder.lockCanvas();

            if(mCanvas != null) {
                try {
                    draw();

                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    mSurfaceHolder.unlockCanvasAndPost(mCanvas);
                }
            }
        }
    }

    private void draw() {
        mCanvas.drawBitmap(mBitmap, 0, 0, mPaint);
    }

}
