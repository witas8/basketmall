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

public class AisleDryBaking extends AppCompatActivity implements View.OnClickListener{

    ImageView bread, rice, cake, pasta, croissant, flour, cookie, roll, baguette;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_aisle_dry_baking );

        bread = (ImageView) findViewById( R.id.bread );
        rice = (ImageView) findViewById( R.id.rice );
        cake = (ImageView) findViewById( R.id.cake );
        pasta = (ImageView) findViewById( R.id.pasta );
        croissant = (ImageView) findViewById( R.id.croissant );
        flour = (ImageView) findViewById( R.id.flour );
        cookie = (ImageView) findViewById( R.id.cookie );
        roll = (ImageView) findViewById( R.id.roll );
        baguette = (ImageView) findViewById( R.id.baguette );

        bread.setOnClickListener( this );
        rice.setOnClickListener( this );
        cake.setOnClickListener( this );
        pasta.setOnClickListener( this );
        croissant.setOnClickListener( this );
        flour.setOnClickListener( this );
        cookie.setOnClickListener( this );
        roll.setOnClickListener( this );
        baguette.setOnClickListener( this );

    }

    public void onClick(View v) {
        final DatabaseHelper myDataBaseHandler = new DatabaseHelper( this );
        switch (v.getId()) {
            case R.id.bread:
                myDataBaseHandler.addProduct( "Bread" );
                Toast.makeText( getApplicationContext(), "Bread is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.rice:
                myDataBaseHandler.addProduct( "Rice" );
                Toast.makeText( getApplicationContext(), "Rice is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.cake:
                myDataBaseHandler.addProduct( "Cake" );
                Toast.makeText( getApplicationContext(), "Cake is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.pasta:
                myDataBaseHandler.addProduct( "Pasta" );
                Toast.makeText( getApplicationContext(), "Pasta is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.croissant:
                myDataBaseHandler.addProduct( "Croissant" );
                Toast.makeText( getApplicationContext(), "Croissant is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.flour:
                myDataBaseHandler.addProduct( "Flour" );
                Toast.makeText( getApplicationContext(), "Flour is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.cookie:
                myDataBaseHandler.addProduct( "Cookie" );
                Toast.makeText( getApplicationContext(), "Cookie is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.roll:
                myDataBaseHandler.addProduct( "Roll" );
                Toast.makeText( getApplicationContext(), "Roll is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.baguette:
                myDataBaseHandler.addProduct( "Baguette" );
                Toast.makeText( getApplicationContext(), "Baguette is added", Toast.LENGTH_SHORT ).show();
                break;
        }
    }
}
