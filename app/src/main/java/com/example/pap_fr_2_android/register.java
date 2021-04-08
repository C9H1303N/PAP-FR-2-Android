package com.example.pap_fr_2_android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView tv = findViewById(R.id.agreement);
        final Uri uri=Uri.parse("https://baidu.com");

        final SpannableStringBuilder style = new SpannableStringBuilder();

        //设置文字
        style.append("*注册代表您同意《用户注册协议》");

        //设置部分文字点击事件
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        };
        style.setSpan(clickableSpan, 8, 16, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setText(style);

        //设置部分文字颜色

        //配置给TextView
        tv.setMovementMethod(LinkMovementMethod.getInstance());
        tv.setText(style);
    }
}