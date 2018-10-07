package com.example.lzw.day04;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class WaterView extends View {

    private Paint mPaintTop;
    private Paint mPaintBottom;
    private Path mPathTop;
    private Path mPathBottom;
    private float a;

    public WaterView(Context context) {
        super(context);
        init(context);
    }

    public WaterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public WaterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
         mPaintTop = new Paint();
         mPaintTop.setColor(Color.WHITE);
         mPaintTop.setAntiAlias(true);
         mPaintBottom = new Paint();
         mPaintBottom.setColor(Color.WHITE);
        mPaintBottom.setAntiAlias(true);
        mPaintBottom.setAlpha(60);
        mPathTop = new Path();
       mPathBottom = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPathTop.reset();
        mPathBottom.reset();
        //路径起始坐标位置
        mPathTop.moveTo(getLeft(),getBottom());
        mPathBottom.moveTo(getLeft(),getBottom());
        //获取每个宽度值所占的度数
        double mY=Math.PI*2/getWidth();
        a-=0.1f;
        //路径移动的坐标
        for (float x=0;x<=getWidth();x+=20){
            float y=(float) (10*Math.cos(mY*x+a)+10);
                mPathTop.lineTo(x, y);
                mPathBottom.lineTo(x, (float) (10*Math.sin(mY*x+a)));
                listener.animation(y);
        }
        //路径终止位置
        mPathTop.moveTo(getRight(),getBottom());
        mPathBottom.moveTo(getRight(),getBottom());
        canvas.drawPath(mPathTop,mPaintTop);
        canvas.drawPath(mPathBottom,mPaintBottom);
        postInvalidateDelayed(20);//刷新
    }
    //通过接口把当前浮动的一个y值，回调给调用的页面
    private AnimationListener listener;
    public  void animation(AnimationListener listener){

        this.listener = listener;
    }
    public  interface AnimationListener{

        void animation(float y);
    }
}
