package com.xudangui.imchat.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.xudangui.imchat.Entity.MessageListEntity;
import com.xudangui.imchat.R;
import com.xudangui.imchat.adapter.MessageListAdapter;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by xudangui on 2018/4/12.
 */

@ContentView(R.layout.message_fragment)
public class MessageFragment extends Fragment {

    private ListView mMessageListView;

    private MessageListAdapter messageListAdapter;

    private Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.message_fragment,container,false);
        context = view.getContext();
        x.view().inject(view);
        SharedPreferences preferences = view.getContext().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String username = preferences.getString("username",null);
        BmobQuery<MessageListEntity> query = new BmobQuery<>();
        query.addWhereEqualTo("to",username);
        query.findObjects(new FindListener<MessageListEntity>() {
            @Override
            public void done(List<MessageListEntity> list, BmobException e) {
                if(null!=list && list.size()>0){
                    mMessageListView = view.findViewById(R.id.message_list);
                    messageListAdapter = new MessageListAdapter(context,R.layout.message_info_listview,list);
                    mMessageListView.setAdapter(messageListAdapter);
                }else {
                    Log.e("xudangui",e.getMessage());
                }
            }
        });

        return view;
    }
}