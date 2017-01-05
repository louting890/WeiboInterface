package view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

import com.example.administrator.weibointerface.R;

/**
 * Created by Administrator on 2016/12/16.
 */

public class PullScrowView extends ScrollView {
    //private static final String LOG_TAG="PullScrowView";
    //private static final float SCROLL_RATIO=0.5f;//阻尼系数，值越小阻尼就越大
    //private static final int TURN_DISTANCE=100;//滑动至翻滚的距离
    //private View mHeader;//头部的View
    private int headerHeight;//头部View的高度
    private int headerVisibleHeight;//头部view显示高度
    //private View mContentView;//ScrollView的content view
    //private Rect mContentRect=new Rect();//ScrollView的content view矩形
    //private PointF mStartPoint=new PointF();//首次点击的Y坐标
    //private boolean isMoving=false;//是否开始移动
    //private boolean isTop=false;//是否移动到顶部位置
    //private int mInitTop,mInitBottom;//头部图片初始顶部和底部
    //private int mCurrentTop,mCurrentBottom;//头部图片拖动时顶部和底部
    //private OnTurnListener mOnTurnListener;
    /*private enum State{
        UP,//顶部
        DOWN,//底部
        NORMAL//正常
    }*/
    //private State mSate=State.NORMAL;

    //三种构造方法
    public PullScrowView(Context context){
        super(context);
        init(context,null);
    }
    public PullScrowView(Context context, AttributeSet attrs){
        super(context,attrs);
        init(context,attrs);
    }
    public PullScrowView(Context context,AttributeSet attrs,int defStyle){
        super(context,attrs,defStyle);
        init(context,attrs);
    }

    private void init(Context context,AttributeSet attrs){
        setOverScrollMode(OVER_SCROLL_NEVER);//设置不能滑动过界
        if(attrs!=null){
            TypedArray array=context.obtainStyledAttributes(attrs,R.styleable.scrow);
            headerHeight=(int)array.getDimension(R.styleable.scrow_headerHeight,0);
            headerVisibleHeight=(int)array.getDimension(R.styleable.scrow_headerVisibleHeight,0);
            array.recycle();
        }
    }
}
