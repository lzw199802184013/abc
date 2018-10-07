package com.example.lzw.day04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SelfActivity extends AppCompatActivity {

    private EditText et;
    private List<String> stringList = new ArrayList<>();
    private SelfView self_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self);
        self_view=(SelfView)findViewById(R.id.self_view);
        et=(EditText)findViewById(R.id.et);
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String message =et.getText().toString().trim();
               if (TextUtils.isEmpty(message)){
                   Toast.makeText(SelfActivity.this,"内容不能为空",Toast.LENGTH_SHORT).show();
                   return;
               }
               stringList.add(message);
               self_view.setListData(stringList);
            }
        });

    }
}
