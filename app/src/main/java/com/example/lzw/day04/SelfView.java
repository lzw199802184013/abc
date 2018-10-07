package com.example.lzw.day04;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SelfView extends RelativeLayout {
    private LinearLayout linear_layout;

    public SelfView(Context context) {
        super(context);
        init(context);
    }

    public SelfView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SelfView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private Context context;
    private void init(Context context) {
        this.context=context;
        View view = View.inflate(context,R.layout.layout_self,null);
        linear_layout=(LinearLayout)view.findViewById(R.id.linear_layout);
        addView(view);
    }

    private void setList(List<String> arrayList) {
      linear_layout.removeAllViews();
        LinearLayout view = (LinearLayout) View.inflate(context,R.layout.layout_self2,null);
        linear_layout.addView(view);
        int len=0;
      view.removeAllViews();
        for (int a=0;a<arrayList.size();a++){
            String msg=arrayList.get(a);
            len+=msg.length();
            if (len>22){
                view = (LinearLayout) View.inflate(context,R.layout.layout_self2,null);
                linear_layout.addView(view);
                len=0;
            }
            View viewText = View.inflate(context,R.layout.layout_self3,null);
            final TextView tv_txt=(TextView)viewText.findViewById(R.id.tv_txt);
            tv_txt.setText(msg);
            view.addView(viewText);
            LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) viewText.getLayoutParams();
            params.weight=1;
            params.leftMargin=10;
            params.rightMargin=10;
            params.topMargin=10;
           viewText.setLayoutParams(params);
           tv_txt.setOnClickListener(new OnClickListener() {
               @Override
               public void onClick(View view) {
                   Toast.makeText(context,tv_txt.getText().toString(),Toast.LENGTH_SHORT).show();
               }
           });
        }

    }

    public void setListData(List<String> listData) {
        if (!listData.isEmpty()){
            setList(listData);
        }

    }
}
