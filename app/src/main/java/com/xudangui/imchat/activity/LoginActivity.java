package com.xudangui.imchat.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.xudangui.imchat.Entity.MessageListEntity;
import com.xudangui.imchat.Entity.UserEntity;
import com.xudangui.imchat.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.Date;
import java.util.List;

import cn.bmob.newim.bean.BmobIMUserInfo;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * 登陆页面
 * Created by xudangui on 2018/4/10.
 */

@ContentView(R.layout.activity_login)
public class LoginActivity extends BaseActivity{

    @ViewInject(R.id.mAccount)
    private EditText mAccount;//账号

    @ViewInject(R.id.mPassword)
    private EditText mPassword;//密码

    @ViewInject(R.id.mLogin)
    private Button mLogin;//登陆按钮

    @ViewInject(R.id.mRememberPWD)
    private CheckBox mRememberPWD;//记住密码

    @ViewInject(R.id.mForgetPWD)
    private TextView mForgerPWD;

    @ViewInject(R.id.mRegister)
    private  TextView mRegister;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }

    @Event(value = {R.id.mLogin,R.id.mRegister,R.id.mForgetPWD},type = View.OnClickListener.class)
    private void getEvent(View view){
        switch (view.getId()){
            case R.id.mLogin:
                if("".equals(mAccount.getText().toString().trim())
                        || "".equals(mPassword.getText().toString().trim())){
                    Toast.makeText(LoginActivity.this,"账号跟密码不能为空",Toast.LENGTH_SHORT).show();
                    break;
                }
                BmobQuery<UserEntity> query = new BmobQuery<>();
                query.addWhereEqualTo("username",mAccount.getText().toString().trim());
                query.findObjects(new FindListener<UserEntity>() {
                    @Override
                    public void done(List<UserEntity> list, BmobException e) {
                        if(null!=list && list.size()>0){
                            UserEntity entity = list.get(0);
                            if(entity.getPassword().equals(mPassword.getText().toString())) {
                                SharedPreferences preferences = getSharedPreferences("userInfo",MODE_PRIVATE);
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putString("username",mAccount.getText().toString());
                                editor.commit();
                                /*MessageListEntity messageListEntity = new MessageListEntity();
                                messageListEntity.setUsername("xudangui");
                                messageListEntity.setMessage("Hello world");
                                messageListEntity.setTo("xdg");
                                messageListEntity.setIsRead("1");
                                messageListEntity.setLatestTime(new Date());
                                messageListEntity.save(new SaveListener<String>() {
                                    @Override
                                    public void done(String s, BmobException e) {

                                    }
                                });*/
                                Intent startMainIntent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(startMainIntent);
                            }else {
                                Toast.makeText(LoginActivity.this,"密码错误",Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(LoginActivity.this,"账号不存在",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                break;
            case R.id.mRegister:
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.mForgetPWD:break;
            default:break;
        }
    }
}
