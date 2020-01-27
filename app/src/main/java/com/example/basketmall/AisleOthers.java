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

public class AisleOthers extends AppCompatActivity implements View.OnClickListener {

    ImageView oil, meds, dumplings, chocolate, flakes, iceCream, pizza, fries, chips, frozen, nuts, clothes;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater( this );
        menuInflater.inflate( R.menu.upper_bar, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.show_basket:
                Intent intent = new Intent( this, BasketHandler.class );
                startActivity( intent );
                break;
            case R.id.shopping_time:
                Intent intent2 = new Intent( this, DateTimePicker.class );
                startActivity( intent2 );
                break;
            case R.id.back_menu:
                Intent intent3 = new Intent( this, MainActivity.class );
                startActivity( intent3 );
                return true;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_aisle_others );


        oil = (ImageView) findViewById( R.id.oil );
        meds = (ImageView) findViewById( R.id.meds );
        dumplings = (ImageView) findViewById( R.id.dumplings );
        chocolate = (ImageView) findViewById( R.id.chocolate );
        flakes = (ImageView) findViewById( R.id.flakes );
        iceCream = (ImageView) findViewById( R.id.iceCream );
        pizza = (ImageView) findViewById( R.id.pizza );
        fries = (ImageView) findViewById( R.id.fries );
        chips = (ImageView) findViewById( R.id.chips );
        frozen = (ImageView) findViewById( R.id.frozen );
        nuts = (ImageView) findViewById( R.id.nuts );
        clothes = (ImageView) findViewById( R.id.clothes );

        oil.setOnClickListener( this );
        meds.setOnClickListener( this );
        dumplings.setOnClickListener( this );
        chocolate.setOnClickListener( this );
        flakes.setOnClickListener( this );
        iceCream.setOnClickListener( this );
        pizza.setOnClickListener( this );
        fries.setOnClickListener( this );
        chips.setOnClickListener( this );
        frozen.setOnClickListener( this );
        nuts.setOnClickListener( this );
        clothes.setOnClickListener( this );

    }


    public void onClick(View v) {
        final DatabaseHelper myDataBaseHandler = new DatabaseHelper( this );
        switch (v.getId()) {
            case R.id.oil:
                myDataBaseHandler.addProduct( "Olive Oil" );
                Toast.makeText( getApplicationContext(), "Olive Oil is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.meds:
                myDataBaseHandler.addProduct( "Medicines" );
                Toast.makeText( getApplicationContext(), "Medicines are added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.dumplings:
                myDataBaseHandler.addProduct( "Dumplings" );
                Toast.makeText( getApplicationContext(), "Dumplings are added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.chocolate:
                myDataBaseHandler.addProduct( "Chocolate" );
                Toast.makeText( getApplicationContext(), "Chocolate is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.flakes:
                myDataBaseHandler.addProduct( "Flakes" );
                Toast.makeText( getApplicationContext(), "Flakes are added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.iceCream:
                myDataBaseHandler.addProduct( "Ice Cream" );
                Toast.makeText( getApplicationContext(), "Ice Cream is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.pizza:
                myDataBaseHandler.addProduct( "Pizza" );
                Toast.makeText( getApplicationContext(), "Pizza is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.fries:
                myDataBaseHandler.addProduct( "Fries" );
                Toast.makeText( getApplicationContext(), "Fries are added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.chips:
                myDataBaseHandler.addProduct( "Chips" );
                Toast.makeText( getApplicationContext(), "Chips are added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.frozen:
                myDataBaseHandler.addProduct( "Frozen Food" );
                Toast.makeText( getApplicationContext(), "Frozen Food is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.nuts:
                myDataBaseHandler.addProduct( "Nuts" );
                Toast.makeText( getApplicationContext(), "Nuts are added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.clothes:
                myDataBaseHandler.addProduct( "Clothes" );
                Toast.makeText( getApplicationContext(), "Clothes are added", Toast.LENGTH_SHORT ).show();
                break;

        }
    }
}