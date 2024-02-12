package com.example.siestadeneme2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

import com.example.siestadeneme2.databinding.ActivityMenuPageBinding;

public class MenuPage extends AppCompatActivity {

    private ActivityMenuPageBinding binding;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMenuPageBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_menu_page);


         auth = FirebaseAuth.getInstance();
    }



    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.profile){
            Intent intentToProfilePage = new Intent(MenuPage.this,ProfilePage.class);
            startActivity(intentToProfilePage);
        }
        else if(item.getItemId()==R.id.signout){
            //Sign out
            auth.signOut();

            Intent intentToMain = new Intent(MenuPage.this,MainActivity.class);
            startActivity(intentToMain);
            finish();

        }


        return super.onOptionsItemSelected(item);
    }

}