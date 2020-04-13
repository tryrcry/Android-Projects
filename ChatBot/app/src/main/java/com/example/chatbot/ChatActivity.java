package com.example.chatbot;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {
    ListView listView;
    EditText txt;
    ImageButton send;
    ArrayList<ChatModel> list_chat;
    Toolbar t;
    DatabaseReference dr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        listView=findViewById(R.id.list_of_messages);
        txt=findViewById(R.id.editText);
        send=findViewById(R.id.imageButton);
        t=findViewById(R.id.toolbar);
        setSupportActionBar(t);
        t.setTitleTextColor(Color.parseColor("#eeeeee"));
        list_chat = new ArrayList<ChatModel>();
        send.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String msg=txt.getText().toString();
                        final String copy=msg.toLowerCase();
                        ChatModel model=new ChatModel(msg,true);
                        list_chat.add(model);
                        dr = FirebaseDatabase.getInstance().getReference(copy);
                        dr.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if(dataSnapshot.exists())
                                {
                                    final String response=dataSnapshot.getValue(String.class);
                                    ChatModel mod=new ChatModel(response,false);
                                    list_chat.add(mod);
                                    CustomAdapter ca=new CustomAdapter(list_chat,getApplicationContext());
                                    txt.setText("");
                                    listView.setAdapter(ca);
                                }
                                else
                                {
                                    dr = FirebaseDatabase.getInstance().getReference("error");
                                    dr.child(copy).setValue("You have to enter response");
                                    ChatModel mod=new ChatModel("Sorry for the inconvenience, this project is under development",false);
                                    list_chat.add(mod);
                                    CustomAdapter ca=new CustomAdapter(list_chat,getApplicationContext());
                                    txt.setText("");
                                    listView.setAdapter(ca);
                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                            }
                        });
                    }
                }
        );
    }
}