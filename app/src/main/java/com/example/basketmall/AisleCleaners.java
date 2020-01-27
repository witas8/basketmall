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

public class AisleCleaners extends AppCompatActivity implements View.OnClickListener{

    ImageView cleaningLiquid, washingLiquid, dishwasherCubes, trashBag, cleaningSponge, dishwashingLiquid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_aisle_cleaners );

        cleaningLiquid = (ImageView) findViewById( R.id.cleanLiquid);
        washingLiquid = (ImageView) findViewById( R.id.washingLiquid );
        dishwasherCubes = (ImageView) findViewById( R.id.dishwasherCubes );
        trashBag = (ImageView) findViewById( R.id.trashBag );
        cleaningSponge = (ImageView) findViewById( R.id.cleaningSponge );
        dishwashingLiquid = (ImageView) findViewById( R.id.dishLiquid );

        cleaningLiquid.setOnClickListener( this );
        washingLiquid.setOnClickListener( this );
        dishwasherCubes.setOnClickListener( this );
        trashBag.setOnClickListener( this );
        cleaningSponge.setOnClickListener( this );
        dishwashingLiquid.setOnClickListener( this );

    }

    public void onClick(View v) {
        final DatabaseHelper myDataBaseHandler = new DatabaseHelper( this );
        switch (v.getId()) {
            case R.id.cleanLiquid:
                myDataBaseHandler.addProduct( "Cleaning Liquid" );
                Toast.makeText( getApplicationContext(), "Cleaning Liquid is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.washingLiquid:
                myDataBaseHandler.addProduct( "Washing Liquid" );
                Toast.makeText( getApplicationContext(), "Washing Liquid is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.trashBag:
                myDataBaseHandler.addProduct( "Trash Bag" );
                Toast.makeText( getApplicationContext(), "Trash Bag is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.cleaningSponge:
                myDataBaseHandler.addProduct( "Cleaning Sponge" );
                Toast.makeText( getApplicationContext(), "Cleaning Sponge is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.dishwasherCubes:
                myDataBaseHandler.addProduct( "Dishwasher Cubes" );
                Toast.makeText( getApplicationContext(), "Dishwasher Cubes are added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.dishLiquid:
                myDataBaseHandler.addProduct( "Dishwashing Liquid" );
                Toast.makeText( getApplicationContext(), "Dishwashing Liquid is added", Toast.LENGTH_SHORT ).show();
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
