package com.example.wishlist.Interface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.wishlist.Backend.MyAdapter;
import com.example.wishlist.DAO.UserDAO;
import com.example.wishlist.R;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class WishLists extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private final AppCompatActivity activity = WishLists.this;
    UserDAO userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_lists);
        userDao = new UserDAO(activity);
        Intent intent = getIntent();
        final String pseudo_bis = intent.getStringExtra(EXTRA_MESSAGE);
        String[] myDataset = userDao.get_wishlists(pseudo_bis);
        recyclerView = findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(myDataset);
        recyclerView.setAdapter(mAdapter);


    }
    public void open_items(View view){
        Intent intent2= new Intent(this, Wishes.class);
        TextView nwl=findViewById(R.id.token_recycler);
        String nomWL= nwl.getText().toString();
        Intent intent = getIntent();
        final String pseudo_bis = intent.getStringExtra(EXTRA_MESSAGE);
        String id= userDao.obtain_idwl(pseudo_bis, nomWL);
        intent2.putExtra(EXTRA_MESSAGE, id);
        startActivity(intent2);
    }
}


