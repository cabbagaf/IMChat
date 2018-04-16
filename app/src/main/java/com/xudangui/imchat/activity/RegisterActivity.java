package com.xudangui.imchat.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xudangui.imchat.Entity.UserEntity;
import com.xudangui.imchat.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;


import cn.bmob.newim.BmobIM;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by xudangui on 2018/4/11.
 */

@ContentView(R.layout.activity_register)
public class RegisterActivity extends BaseActivity {

    @ViewInject(R.id.mAccountRegister)
    private EditText mAccountRegister;

    @ViewInject(R.id.mPasswordRegister)
    private EditText mPasswordRegister;

    @ViewInject(R.id.mPasswordConfirm)
    private EditText mPasswordConfirm;

    @ViewInject(R.id.mRegisterBtn)
    private Button mRegisterBtn;

    @ViewInject(R.id.cardView)
    private CardView cardView;

    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        context = this;
    }

    @Event(value = {R.id.mRegisterBtn})
    private void getEvent(View view){
        switch (view.getId()){
            case R.id.mRegisterBtn:
                if("".equals(mAccountRegister.getText().toString().trim())
                        || "".equals(mPasswordRegister.getText().toString().trim())
                        || "".equals(mPasswordConfirm.getText().toString().trim())){
                    Toast.makeText(RegisterActivity.this,"账号跟密码不能为空",LENGTH_SHORT).show();
                    break;
                }
                if(mPasswordRegister.getText().toString()
                        .equals(mPasswordConfirm.getText().toString())){
                    UserEntity userEntity = new UserEntity();
                    userEntity.setUsername(mAccountRegister.getText().toString());
                    userEntity.setPassword(mPasswordRegister.getText().toString());
                    userEntity.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                            if(e==null){
                                Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                                startActivity(intent);
                            }else {
                                String errorMessage = e.getMessage();
                                if(errorMessage.contains("duplicate")){
                                    Toast.makeText(RegisterActivity.this,"用户已存在",Toast.LENGTH_LONG).show();
                                }
                                Toast.makeText(RegisterActivity.this,"注册失败",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(RegisterActivity.this,"密码输入不正确",LENGTH_SHORT).show();
                }
                break;
            default:break;
        }
    }
}
