package com.example.pap_fr_2_android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity implements View.OnClickListener {
    private Button login;
    private Button back;
    private Button vertify;
    private EditText phonenum;
    private EditText vertifycode;
    private EditText newPassword;
    private EditText repeatPassword;

    private void initView(){
        login = findViewById(R.id.login);
        back = findViewById(R.id.back);
        vertify = findViewById(R.id.vertify);
        phonenum = findViewById(R.id.phonenum);
        vertifycode = findViewById(R.id.vertifycode);
        newPassword = findViewById(R.id.renewpassword);
        repeatPassword = findViewById(R.id.checkpassword);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView tv = findViewById(R.id.agreement);
        final Uri uri=Uri.parse("https://baidu.com");
        initView();
        login.setOnClickListener(this);
        back.setOnClickListener(this);
        vertify.setOnClickListener(this);

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

    public void onClick(View v){
        if (v.getId() == R.id.login){
            String password1 = newPassword.getText().toString();
            String password2 = repeatPassword.getText().toString();
            String phonum = phonenum.getText().toString();
            String vercode = vertifycode.getText().toString();
            if (password1.equals("") || password2.equals("") || phonum.equals("") || vercode.equals("")){
                Toast.makeText(this,"请输入完整信息",Toast.LENGTH_SHORT).show();
            }
            else if (false){         // 验证码正确性判断

            }
            else if (false){        //手机号是否注册过

            }
            else if (!password1.equals(password2)){
                Toast.makeText(this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "注册成功！", Toast.LENGTH_SHORT).show();
                //数据库请求
                //跳转到登录页面
            }
        }
        else if (v.getId() == R.id.back){
            register.this.finish();
        }
        else if (v.getId() == R.id.vertify){

            Toast.makeText(this, "这里是验证测试", Toast.LENGTH_SHORT).show();
        }
    }
}