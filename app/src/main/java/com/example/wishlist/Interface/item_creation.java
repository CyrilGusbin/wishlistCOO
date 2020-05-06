package com.example.wishlist.Interface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wishlist.DAO.UserDAO;
import com.example.wishlist.R;

import java.util.UUID;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class item_creation extends AppCompatActivity {
    public static final String EXTRA_MESSAGE4 ="" ;
    private static final String EXTRA_MESSAGE5 ="" ;
    private final AppCompatActivity activity = item_creation.this;
    UserDAO userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        userDao = new UserDAO(activity);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_creation);
        Intent intent4=getIntent();
        String erreur=intent4.getStringExtra(EXTRA_MESSAGE5);
        TextView erreur_text= findViewById(R.id.error_item);
        erreur_text.setText(erreur);
    }
    public void item_creation(View view){
        String uniqueID = UUID.randomUUID().toString();
        EditText item= findViewById(R.id.Nitem);
        EditText prix= findViewById(R.id.Pitem);
        EditText desc= findViewById(R.id.desc);
        String item_bis= item.getText().toString();
        String prix_bis= prix.getText().toString();
        String desc_bis= desc.getText().toString();
        Intent intent= getIntent();
        String idwl=intent.getStringExtra(EXTRA_MESSAGE);
        boolean ret= userDao.create_item(uniqueID, item_bis, desc_bis, prix_bis, idwl);
        if(ret){
            Intent intent2= new Intent(this, wishes_intermediate.class);
            intent2.putExtra(EXTRA_MESSAGE4, "Item créé");
            intent2.putExtra(EXTRA_MESSAGE, idwl);
            startActivity(intent2);
        }
        else{
            Intent intent3 = new Intent(this, item_creation.class);
            intent3.putExtra(EXTRA_MESSAGE5, "Données érronées");
            startActivity(intent3);
        }

    }
}
