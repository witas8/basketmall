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

public class AislePersonalCare extends AppCompatActivity implements View.OnClickListener{

    ImageView cream, makeup, perfume, shampoo, soap, sponge, toiletPaper, toothPaste, wipes;


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
        setContentView( R.layout.activity_aisle_personal_care );

        cream = (ImageView) findViewById( R.id.cream );
        makeup = (ImageView) findViewById( R.id.makeup );
        perfume = (ImageView) findViewById( R.id.perfume );
        shampoo = (ImageView) findViewById( R.id.shampoo );
        soap = (ImageView) findViewById( R.id.soap );
        sponge = (ImageView) findViewById( R.id.sponge );
        toiletPaper = (ImageView) findViewById( R.id.toiletPaper );
        toothPaste = (ImageView) findViewById( R.id.toothPaste );
        wipes = (ImageView) findViewById( R.id.wipes );

        cream.setOnClickListener( this );
        makeup.setOnClickListener( this );
        perfume.setOnClickListener( this );
        shampoo.setOnClickListener( this );
        soap.setOnClickListener( this );
        sponge.setOnClickListener( this );
        toiletPaper.setOnClickListener( this );
        toothPaste.setOnClickListener( this );
        wipes.setOnClickListener( this );

    }

    public void onClick(View v) {
        final DatabaseHelper myDataBaseHandler = new DatabaseHelper( this );
        switch (v.getId()) {
            case R.id.cream:
                myDataBaseHandler.addProduct( "Cream" );
                Toast.makeText( getApplicationContext(), "Cream is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.makeup:
                myDataBaseHandler.addProduct( "Makeup" );
                Toast.makeText( getApplicationContext(), "Makeup is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.perfume:
                myDataBaseHandler.addProduct( "Perfume" );
                Toast.makeText( getApplicationContext(), "Perfume is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.shampoo:
                myDataBaseHandler.addProduct( "Shampoo" );
                Toast.makeText( getApplicationContext(), "Shampoo is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.soap:
                myDataBaseHandler.addProduct( "Soap" );
                Toast.makeText( getApplicationContext(), "Soap is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.sponge:
                myDataBaseHandler.addProduct( "Sponge" );
                Toast.makeText( getApplicationContext(), "Sponge is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.toiletPaper:
                myDataBaseHandler.addProduct( "Toilet Paper" );
                Toast.makeText( getApplicationContext(), "Toilet Paper is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.toothPaste:
                myDataBaseHandler.addProduct( "Toothpaste" );
                Toast.makeText( getApplicationContext(), "Toothpaste is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.wipes:
                myDataBaseHandler.addProduct( "Tissue" );
                Toast.makeText( getApplicationContext(), "Tissue is added", Toast.LENGTH_SHORT ).show();
                break;
        }
    }
}
