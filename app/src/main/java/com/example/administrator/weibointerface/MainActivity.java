package com.example.administrator.weibointerface;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import view.PullScrowView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    private TableLayout listlayout;
    private ImageView header;
    private PullScrowView scrowView;
    private ImageView icon;
    private int [] icons={R.mipmap.p1calendar,R.mipmap.p2camera,R.mipmap.p3clock,R.mipmap.p4collection,
    R.mipmap.p5costcontrol,R.mipmap.p6dialer,R.mipmap.p7email,R.mipmap.p8finddevice,
    R.mipmap.p9fm,R.mipmap.p10gallery,R.mipmap.p11keyboard,R.mipmap.p12music,R.mipmap.p13ringtones,
    R.mipmap.p14settings,R.mipmap.p15sms,R.mipmap.p16vertical,R.mipmap.p17video,
    R.mipmap.p18wallpaper};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        listlayout=(TableLayout)findViewById(R.id.list);
        header=(ImageView)findViewById(R.id.image);
        scrowView=(PullScrowView)findViewById(R.id.scrollview);
        icon=(ImageView)findViewById(R.id.icon);
        scrowView.setHeaderView(header);
        initData();
    }

    private void initData(){
        TableRow.LayoutParams params1=new TableRow.LayoutParams(200,200);
        params1.setMargins(8,8,8,8);
        params1.gravity=Gravity.LEFT;
        for(int i=0;i<18;i++){
            TableRow row=new TableRow(this);
            ImageView imageView=new ImageView(this);
            imageView.setImageResource(icons[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            row.addView(imageView,params1);
            TableRow.LayoutParams params2=new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params2.weight=1;
            TextView textView=new TextView(this);
            textView.setText("This is the item "+i+", click to check out more.");
            params2.gravity=Gravity.CENTER_VERTICAL;
            textView.setTextSize(16);
            row.addView(textView,params2);
            listlayout.addView(row);
        }
        header.setImageResource(R.drawable.cat);
        icon.setImageResource(R.mipmap.icon);
    }
}
