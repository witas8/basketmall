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

public class AisleFruit extends AppCompatActivity implements View.OnClickListener{

    ImageView orange, banana, apple, lemon, watermelon, grapes, strawberry, peach, plum, kiwi, pineapple, pear;


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
        setContentView( R.layout.activity_aisle_fruit );

        orange = (ImageView) findViewById( R.id.orange );
        banana = (ImageView) findViewById( R.id.banana );
        apple = (ImageView) findViewById( R.id.apple );
        lemon = (ImageView) findViewById( R.id.lemon );
        watermelon = (ImageView) findViewById( R.id.watermelon );
        grapes = (ImageView) findViewById( R.id.grapes );
        strawberry = (ImageView) findViewById( R.id.strawberry );
        peach = (ImageView) findViewById( R.id.peach );
        plum = (ImageView) findViewById( R.id.plum );
        kiwi = (ImageView) findViewById( R.id.kiwi);
        pineapple = (ImageView) findViewById( R.id.pineapple );
        pear = (ImageView) findViewById( R.id.pear );

        orange.setOnClickListener( this );
        banana.setOnClickListener( this );
        apple.setOnClickListener( this );
        lemon.setOnClickListener( this );
        watermelon.setOnClickListener( this );
        grapes.setOnClickListener( this );
        strawberry.setOnClickListener( this );
        peach.setOnClickListener( this );
        plum.setOnClickListener( this );
        kiwi.setOnClickListener( this );
        pineapple.setOnClickListener( this );
        pear.setOnClickListener( this );

    }

    public void onClick(View v) {
        final DatabaseHelper myDataBaseHandler = new DatabaseHelper( this );
        switch (v.getId()) {
            case R.id.orange:
                myDataBaseHandler.addProduct( "Orange" );
                Toast.makeText( getApplicationContext(), "Orange is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.banana:
                myDataBaseHandler.addProduct( "Banana" );
                Toast.makeText( getApplicationContext(), "Banana is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.apple:
                myDataBaseHandler.addProduct( "Apple" );
                Toast.makeText( getApplicationContext(), "Apple is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.lemon:
                myDataBaseHandler.addProduct( "Lemon" );
                Toast.makeText( getApplicationContext(), "Lemon is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.watermelon:
                myDataBaseHandler.addProduct( "Watermelon" );
                Toast.makeText( getApplicationContext(), "Watermelon is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.grapes:
                myDataBaseHandler.addProduct( "Grapes" );
                Toast.makeText( getApplicationContext(), "Grapes are added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.strawberry:
                myDataBaseHandler.addProduct( "Strawberry" );
                Toast.makeText( getApplicationContext(), "Strawberry is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.peach:
                myDataBaseHandler.addProduct( "Peach" );
                Toast.makeText( getApplicationContext(), "Peach is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.plum:
                myDataBaseHandler.addProduct( "Plum" );
                Toast.makeText( getApplicationContext(), "Plum is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.kiwi:
                myDataBaseHandler.addProduct( "Kiwi" );
                Toast.makeText( getApplicationContext(), "Kiwi is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.pineapple:
                myDataBaseHandler.addProduct( "Pineapple" );
                Toast.makeText( getApplicationContext(), "Pineapple is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.pear:
                myDataBaseHandler.addProduct( "Pear" );
                Toast.makeText( getApplicationContext(), "Pear is added", Toast.LENGTH_SHORT ).show();
                break;

        }
    }
}
