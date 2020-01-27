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

public class AisleDrinks extends AppCompatActivity implements View.OnClickListener{

    ImageView water, beer, coffee, wine, soda, juice, energy, tea, vodka, iceTea, lemonade, whisky;


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
        setContentView( R.layout.activity_aisle_drinks );

        water = (ImageView) findViewById( R.id.water );
        beer = (ImageView) findViewById( R.id.beer );
        coffee = (ImageView) findViewById( R.id.coffee );
        wine = (ImageView) findViewById( R.id.wine );
        soda = (ImageView) findViewById( R.id.soda );
        juice = (ImageView) findViewById( R.id.juice );
        energy = (ImageView) findViewById( R.id.energyDrink );
        tea = (ImageView) findViewById( R.id.tea );
        vodka = (ImageView) findViewById( R.id.vodka );
        iceTea = (ImageView) findViewById( R.id.iceTea);
        lemonade = (ImageView) findViewById( R.id.lemonade );
        whisky = (ImageView) findViewById( R.id.whisky );

        water.setOnClickListener( this );
        beer.setOnClickListener( this );
        coffee.setOnClickListener( this );
        wine.setOnClickListener( this );
        soda.setOnClickListener( this );
        juice.setOnClickListener( this );
        energy.setOnClickListener( this );
        tea.setOnClickListener( this );
        vodka.setOnClickListener( this );
        iceTea.setOnClickListener( this );
        lemonade.setOnClickListener( this );
        whisky.setOnClickListener( this );

    }

    public void onClick(View v) {
        final DatabaseHelper myDataBaseHandler = new DatabaseHelper( this );
        switch (v.getId()) {
            case R.id.water:
                myDataBaseHandler.addProduct( "Water" );
                Toast.makeText( getApplicationContext(), "Water is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.beer:
                myDataBaseHandler.addProduct( "Beer" );
                Toast.makeText( getApplicationContext(), "Beer is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.coffee:
                myDataBaseHandler.addProduct( "Coffee" );
                Toast.makeText( getApplicationContext(), "Coffee is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.wine:
                myDataBaseHandler.addProduct( "Wine" );
                Toast.makeText( getApplicationContext(), "Wine is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.soda:
                myDataBaseHandler.addProduct( "Soda Drink" );
                Toast.makeText( getApplicationContext(), "Soda Drink is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.juice:
                myDataBaseHandler.addProduct( "Juice" );
                Toast.makeText( getApplicationContext(), "Juice is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.energyDrink:
                myDataBaseHandler.addProduct( "Energy Drink" );
                Toast.makeText( getApplicationContext(), "Energy Drink is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.tea:
                myDataBaseHandler.addProduct( "Tea" );
                Toast.makeText( getApplicationContext(), "Tea is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.vodka:
                myDataBaseHandler.addProduct( "Vodka" );
                Toast.makeText( getApplicationContext(), "Vodka is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.iceTea:
                myDataBaseHandler.addProduct( "Ice Tea" );
                Toast.makeText( getApplicationContext(), "Ice Tea is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.lemonade:
                myDataBaseHandler.addProduct( "Lemonade" );
                Toast.makeText( getApplicationContext(), "Lemonade is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.whisky:
                myDataBaseHandler.addProduct( "Whisky" );
                Toast.makeText( getApplicationContext(), "Whisky is added", Toast.LENGTH_SHORT ).show();
                break;

        }
    }
}
