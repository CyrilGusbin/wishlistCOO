package com.example.wishlist.Interface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wishlist.DAO.UserDAO;
import com.example.wishlist.R;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class friends_intermediate extends AppCompatActivity {
    private static final String EXTRA_MESSAGE2 ="" ;
    UserDAO userdao;
    private final AppCompatActivity activity = friends_intermediate.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_intermediate);
        Intent intent=getIntent();
        String feedback=intent.getStringExtra(EXTRA_MESSAGE2);
        TextView feed= findViewById(R.id.back);
        feed.setText(feedback);
    }
    public void go_to_friends_liste(View view){
        Intent intent=getIntent();
        String pseudo=intent.getStringExtra(EXTRA_MESSAGE);
        Intent intent2= new Intent(this, Friends.class);
        intent2.putExtra(EXTRA_MESSAGE, pseudo);
        startActivity(intent2);

    }
    public void add_friend(View view){
        userdao= new UserDAO(activity);
        Intent intent=getIntent();
        String pseudo=intent.getStringExtra(EXTRA_MESSAGE);
        EditText friend = findViewById(R.id.search_friend);
        String friend_bis= friend.getText().toString();
        boolean ret = userdao.friend_request(pseudo, friend_bis);
        if (ret){
            Intent intent2= new Intent(this, friends_intermediate.class);
            intent2.putExtra(EXTRA_MESSAGE, pseudo);
            intent2.putExtra(EXTRA_MESSAGE2, "demande envoyée");
            startActivity(intent2);
        }
        else{
            Intent intent2= new Intent(this, friends_intermediate.class);
            intent2.putExtra(EXTRA_MESSAGE, pseudo);
            intent2.putExtra(EXTRA_MESSAGE2, "utilisateur inexistant ou déjà dans votre liste d'ami");
            startActivity(intent2);
        }
    }
    public void go_to_demands(View view){
            Intent intent= getIntent();
            String pseudo= intent.getStringExtra(EXTRA_MESSAGE);
            Intent intent2= new Intent(this, Demands.class);
            intent2.putExtra(EXTRA_MESSAGE, pseudo);
            startActivity(intent2);
    }
}
