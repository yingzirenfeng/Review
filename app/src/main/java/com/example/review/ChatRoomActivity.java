package com.example.review;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ChatRoomActivity extends AppCompatActivity {

    ArrayList<Message> objects = new ArrayList<>( );

    BaseAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);

        //You only need 2 lines in onCreate to actually display data:
        ListView theList = findViewById(R.id.theList);
        myAdapter = new MyListAdapter();
        theList.setAdapter(myAdapter);
        theList.setOnItemClickListener( ( parent,  view,  position,  id) ->{
            Log.d("CLicked", "You clicked item:" + position);

        });

        Button sendButton = findViewById(R.id.send_button);
        sendButton.setOnClickListener( clik -> {
            EditText editText=findViewById(R.id.editText);
            String message = editText.getText().toString();
            Message m = new Message(message,MessageType.SEND);
            objects.add(m);
            myAdapter.notifyDataSetChanged(); //update yourself
            editText.setText("");
        } );
        Button recieveButton = findViewById(R.id.recieve_button);
        recieveButton.setOnClickListener( clik -> {
            EditText editText=findViewById(R.id.editText);
            String message = editText.getText().toString();
            Message m = new Message(message,MessageType.RECEIVE);
            objects.add(m);
            myAdapter.notifyDataSetChanged(); //update yourself
            editText.setText("");
        } );
    }



    //Need to add 4 functions here:
    private class MyListAdapter extends BaseAdapter {

        public int getCount() {  return objects.size();  } //This function tells how many objects to show

        public Message getItem(int position) { return objects.get(position);  }  //This returns the string at position p

        public long getItemId(int p) { return p; } //This returns the database id of the item at position p

        public View getView(int p, View recycled, ViewGroup parent)
        {

            LayoutInflater inflater = getLayoutInflater();
            View thisRow = null;


                if(getItem(p).getType()==MessageType.SEND){
                    thisRow = inflater.inflate(R.layout.row_send, null);
                }else{
                    thisRow = inflater.inflate(R.layout.row_receiver, null);
                }



            TextView itemField = thisRow.findViewById(R.id.txt_msg);
            boolean b=itemField==null;
            Log.d("CHAT","message="+getItem(p).getMessage());

            itemField.setText(getItem(p).getMessage());


            return thisRow;
        }
    }
}
