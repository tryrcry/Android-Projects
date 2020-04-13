package com.example.chatbot;

public class ChatModel {
    public String msg;
    public boolean isSend;

    public ChatModel(String msg, boolean isSend)
    {
        this.msg = msg;
        this.isSend = isSend;
    }

    public ChatModel()
    {

    }

    public String getMsg()
    {
        return msg;
    }

    public boolean isSend()
    {
        return isSend;
    }

}

