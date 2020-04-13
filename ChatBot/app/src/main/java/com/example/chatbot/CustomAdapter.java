package com.example.chatbot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    public List<ChatModel> list_chat_models;
    public Context context;
    public LayoutInflater layoutInflater;
    @Override
    public int getCount() {
        return list_chat_models.size();
    }

    public CustomAdapter(List<ChatModel> list_chat_models, Context context) {
        this.list_chat_models = list_chat_models;
        this.context = context;
        this.layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Object getItem(int position) {
        return list_chat_models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=convertView;
        if(v==null)
        {
            if (list_chat_models.get(position).isSend)
                v = LayoutInflater.from(context).inflate(R.layout.msg_right, null);
            else
                v = LayoutInflater.from(context).inflate(R.layout.msg_left, null);
            TextView tv = v.findViewById(R.id.txtMsg);
            tv.setText(list_chat_models.get(position).getMsg());
        }
        return v;
    }
}