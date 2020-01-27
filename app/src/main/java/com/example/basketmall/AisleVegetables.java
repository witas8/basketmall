package com.example.basketmall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class AisleVegetables extends AppCompatActivity implements View.OnClickListener{

    ImageView pepper, carrot, onion, cauliflower, tomato, eggplant, broccoli, garlic, cucumber,
            potato, beetroot, lettuce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_aisle_vegetables );

        pepper = (ImageView) findViewById( R.id.pepper );
        carrot = (ImageView) findViewById( R.id.carrot );
        onion = (ImageView) findViewById( R.id.onion );
        cauliflower = (ImageView) findViewById( R.id.cauliflower );
        tomato = (ImageView) findViewById( R.id.tomato );
        eggplant = (ImageView) findViewById( R.id.eggplant );
        broccoli = (ImageView) findViewById( R.id.broccoli );
        garlic = (ImageView) findViewById( R.id.garlic );
        cucumber = (ImageView) findViewById( R.id.cucumber );
        potato = (ImageView) findViewById( R.id.potato);
        beetroot = (ImageView) findViewById( R.id.beetroot );
        lettuce = (ImageView) findViewById( R.id.lettuce );

        pepper.setOnClickListener( this );
        carrot.setOnClickListener( this );
        onion.setOnClickListener( this );
        cauliflower.setOnClickListener( this );
        tomato.setOnClickListener( this );
        eggplant.setOnClickListener( this );
        broccoli.setOnClickListener( this );
        garlic.setOnClickListener( this );
        cucumber.setOnClickListener( this );
        potato.setOnClickListener( this );
        beetroot.setOnClickListener( this );
        lettuce.setOnClickListener( this );

    }

    public void onClick(View v) {
        final DatabaseHelper myDataBaseHandler = new DatabaseHelper( this );

        switch (v.getId()) {
            case R.id.pepper:
                myDataBaseHandler.addProduct( "Pepper" );
                Toast.makeText( getApplicationContext(), "Pepper is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.carrot:
                myDataBaseHandler.addProduct( "Carrot" );
                Toast.makeText( getApplicationContext(), "Carrot is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.onion:
                myDataBaseHandler.addProduct( "Onion" );
                Toast.makeText( getApplicationContext(), "Onion is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.cauliflower:
                myDataBaseHandler.addProduct( "Cauliflower" );
                Toast.makeText( getApplicationContext(), "Cauliflower is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.tomato:
                myDataBaseHandler.addProduct( "Tomato" );
                Toast.makeText( getApplicationContext(), "Tomato is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.eggplant:
                myDataBaseHandler.addProduct( "Eggplant" );
                Toast.makeText( getApplicationContext(), "Eggplant is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.broccoli:
                myDataBaseHandler.addProduct( "Broccoli" );
                Toast.makeText( getApplicationContext(), "Broccoli is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.garlic:
                myDataBaseHandler.addProduct( "Garlic" );
                Toast.makeText( getApplicationContext(), "Garlic is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.cucumber:
                myDataBaseHandler.addProduct( "Cucumber" );
                Toast.makeText( getApplicationContext(), "Cucumber is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.potato:
                myDataBaseHandler.addProduct( "Potato" );
                Toast.makeText( getApplicationContext(), "Potato is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.beetroot:
                myDataBaseHandler.addProduct( "Beetroot" );
                Toast.makeText( getApplicationContext(), "Beetroot is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.lettuce:
                myDataBaseHandler.addProduct( "Lettuce" );
                Toast.makeText( getApplicationContext(), "Lettuce is added", Toast.LENGTH_SHORT ).show();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate( R.menu.upper_bar, menu  );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.show_basket:
                Intent intent = new Intent(this, BasketHandler.class);
                startActivity( intent );
                break;
            case R.id.shopping_time:
                Intent intent2 = new Intent(this, DateTimePicker.class);
                startActivity( intent2 );
                break;
            case R.id.back_menu:
                Intent intent3 = new Intent(this, MainActivity.class);
                startActivity( intent3 );
                return true;
        }
        return true;
    }
}
