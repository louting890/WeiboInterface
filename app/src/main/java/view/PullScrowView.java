package view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

import com.example.administrator.weibointerface.R;

import static com.example.administrator.weibointerface.R.attr.header;

/**
 * Created by Administrator on 2016/12/16.
 */

public class PullScrowView extends ScrollView {

    private int headerHeight;//头部View的高度
    private int headerVisibleHeight;//头部view显示高度
    private View contentView;//ScrollView的content view
    private View headerView;
    private float downY;
    private int originalTop,originalBottom;
    private final float fraction=0.5f;

    /*private enum State{
        UP,//顶部
        DOWN,//底部
        NORMAL//正常
    }*/
    //private State mSate=State.NORMAL;

    //三种构造方法
    public PullScrowView(Context context){
        super(context);
        //init(context,null);
    }
    public PullScrowView(Context context, AttributeSet attrs){
        super(context,attrs);
        //init(context,attrs);
    }
    public PullScrowView(Context context,AttributeSet attrs,int defStyle){
        super(context,attrs,defStyle);
        //init(context,attrs);
    }

    /*private void init(Context context,AttributeSet attrs){
        setOverScrollMode(OVER_SCROLL_NEVER);//设置不能滑动过界
        if(attrs!=null){
            TypedArray array=context.obtainStyledAttributes(attrs,R.styleable.scrow);
            headerHeight=(int)array.getDimension(R.styleable.scrow_headerHeight,0);
            headerVisibleHeight=(int)array.getDimension(R.styleable.scrow_headerVisibleHeight,0);
            array.recycle();
        }
    }*/

    public void setHeaderView(View view){
        headerView=view;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if(getChildCount()>0)
            contentView=getChildAt(0);
    }

    private int movement;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                downY=event.getY();
                Log.e("downY",downY+"");
                originalTop=headerView.getTop();
                originalBottom=headerView.getBottom();
                break;
            case MotionEvent.ACTION_MOVE:
                float curY=event.getY();
                Log.e("curY",curY+"");
                movement=(int)((curY-downY)*fraction);
                if((curY-downY)>getScrollY()){
                    movement-=getScrollY();
                    if(movement>100)
                        movement=100;
                    if(movement>0)
                        headerView.layout(contentView.getLeft(),originalTop+movement,contentView.getRight(),originalBottom+movement);
                }
                break;
            case MotionEvent.ACTION_UP:
                headerView.layout(headerView.getLeft(),originalTop,headerView.getRight(),originalBottom);
                break;
        }
        return super.onTouchEvent(event);
    }
}
