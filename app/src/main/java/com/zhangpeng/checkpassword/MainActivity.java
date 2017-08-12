package com.zhangpeng.checkpassword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView tv;
    boolean rs;
    String passWord,regex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.edit);


    }
    //可以画交集图进行判断，此正则表达式表示取交集
    public void check(View view){
        //regex = "[a-zA-Z]&&[\\d]&&[\\w&&[^a-zA-Z0-9]]";
        passWord = editText.getText().toString();
        //regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{9,20}$";//含有字母和数字
        //regex ="^[^0-9][^a-z][^A-Z][\\w^]{2,20}$";//只含有特殊字符
        //regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[\\w]{9,20}$";//包含字母，数字，特殊字符
        regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[\\S+]{9,20}$";//在非空字符串中包含字母和数字
        rs = passWord.matches(regex);
        Log.i("623331",rs+"");
        String a = String.valueOf(passWord.charAt(0));
        Log.i("6111111",a);
        if(!a.matches("[a-zA-Z]")|passWord.replaceAll("[a-zA-Z0-9]","").equals(""))
            rs = false;
        //passWord = passWord.replaceAll("[a-zA-Z0-9]","");
        //Log.i("7777",passWord);
        //if(passWord.equals(""))
            //rs = false;
        Log.i("623332",rs+"");
    }
}
