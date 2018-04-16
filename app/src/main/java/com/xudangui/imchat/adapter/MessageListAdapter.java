package com.xudangui.imchat.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.xudangui.imchat.Entity.MessageListEntity;
import com.xudangui.imchat.R;
import com.xudangui.imchat.util.DateUtil;

import java.util.Date;
import java.util.List;

/**
 * 获取信息列表的信息
 * Created by xudangui on 2018/4/12.
 */

public class MessageListAdapter extends ArrayAdapter<MessageListEntity> {

    private List<MessageListEntity> messageListEntityList;

    private int resourceId;

    public MessageListAdapter(@NonNull Context context, int resource, @NonNull List<MessageListEntity> objects) {
        super(context, resource, objects);
        messageListEntityList = objects;
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MessageListEntity message = messageListEntityList.get(position);
        View view;
        ViewHolder viewHolder;
        if(null==convertView){
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder = new ViewHolder();
            viewHolder.mMessageUserView = view.findViewById(R.id.message_user);
            viewHolder.mMessageView = view.findViewById(R.id.message_line);
            viewHolder.mLatestTimeView = view.findViewById(R.id.message_time);
            viewHolder.isReadView = view.findViewById(R.id.message_isread);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.mMessageUserView.setText(message.getUsername());
        viewHolder.mMessageView.setText(message.getMessage());
        Date date = DateUtil.parseStringToDate(message.getLatestTime());
        String dateStr = DateUtil.parseDateToString(date,DateUtil.HHmm);
        viewHolder.mLatestTimeView.setText(dateStr);
        viewHolder.isReadView.setText(message.getIsRead());
        return view;
    }

    class ViewHolder{
        TextView mMessageUserView;
        TextView mMessageView;
        TextView mLatestTimeView;
        TextView isReadView;
    }
}
