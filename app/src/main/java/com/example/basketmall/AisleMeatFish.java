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

public class AisleMeatFish extends AppCompatActivity implements View.OnClickListener{

    ImageView chicken, fish, ham, salmon, bacon, turkey, pork, beef, shrimp, sausage, tuna, salami;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_aisle_meat_fish );

        chicken = (ImageView) findViewById( R.id.chicken );
        fish = (ImageView) findViewById( R.id.fish);
        ham = (ImageView) findViewById( R.id.ham );
        salmon = (ImageView) findViewById( R.id.salmon );
        bacon = (ImageView) findViewById( R.id.bacon );
        turkey = (ImageView) findViewById( R.id.turkey );
        pork = (ImageView) findViewById( R.id.pork );
        beef = (ImageView) findViewById( R.id.beef );
        shrimp = (ImageView) findViewById( R.id.shrimp );
        sausage = (ImageView) findViewById( R.id.sausage);
        tuna = (ImageView) findViewById( R.id.tuna );
        salami = (ImageView) findViewById( R.id.salami );

        chicken.setOnClickListener( this );
        fish.setOnClickListener( this );
        ham.setOnClickListener( this );
        salmon.setOnClickListener( this );
        bacon.setOnClickListener( this );
        turkey.setOnClickListener( this );
        pork.setOnClickListener( this );
        beef.setOnClickListener( this );
        shrimp.setOnClickListener( this );
        sausage.setOnClickListener( this );
        tuna.setOnClickListener( this );
        salami.setOnClickListener( this );

    }

    public void onClick(View v) {
        final DatabaseHelper myDataBaseHandler = new DatabaseHelper( this );
        switch (v.getId()) {
            case R.id.chicken:
                myDataBaseHandler.addProduct( "Chicken" );
                Toast.makeText( getApplicationContext(), "Chicken is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.fish:
                myDataBaseHandler.addProduct( "Fish" );
                Toast.makeText( getApplicationContext(), "Fish is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.ham:
                myDataBaseHandler.addProduct( "Ham" );
                Toast.makeText( getApplicationContext(), "Ham is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.salmon:
                myDataBaseHandler.addProduct( "Salmon" );
                Toast.makeText( getApplicationContext(), "Salmon is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.bacon:
                myDataBaseHandler.addProduct( "Bacon" );
                Toast.makeText( getApplicationContext(), "Bacon is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.turkey:
                myDataBaseHandler.addProduct( "Turkey" );
                Toast.makeText( getApplicationContext(), "Turkey is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.pork:
                myDataBaseHandler.addProduct( "Pork" );
                Toast.makeText( getApplicationContext(), "Pork is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.beef:
                myDataBaseHandler.addProduct( "Beef" );
                Toast.makeText( getApplicationContext(), "Beef is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.shrimp:
                myDataBaseHandler.addProduct( "Shrimp" );
                Toast.makeText( getApplicationContext(), "Shrimp is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.sausage:
                myDataBaseHandler.addProduct( "Sausage" );
                Toast.makeText( getApplicationContext(), "Sausage is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.tuna:
                myDataBaseHandler.addProduct( "Tuna" );
                Toast.makeText( getApplicationContext(), "Tuna is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.salami:
                myDataBaseHandler.addProduct( "Salami" );
                Toast.makeText( getApplicationContext(), "Salami is added", Toast.LENGTH_SHORT ).show();
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
