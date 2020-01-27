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

public class AisleDairy extends AppCompatActivity implements View.OnClickListener{

    ImageView egg, cheese, milk, yogurt, butter, cottage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_aisle_dairy );

        egg = (ImageView) findViewById( R.id.egg );
        cheese = (ImageView) findViewById( R.id.cheese );
        milk = (ImageView) findViewById( R.id.milk );
        yogurt = (ImageView) findViewById( R.id.yogurt );
        butter = (ImageView) findViewById( R.id.butter );
        cottage = (ImageView) findViewById( R.id.cottage );

        egg.setOnClickListener( this );
        cheese.setOnClickListener( this );
        milk.setOnClickListener( this );
        yogurt.setOnClickListener( this );
        butter.setOnClickListener( this );
        cottage.setOnClickListener( this );

    }

    public void onClick(View v) {
        final DatabaseHelper myDataBaseHandler = new DatabaseHelper( this );
        switch (v.getId()) {
            case R.id.egg:
                myDataBaseHandler.addProduct( "Egg" );
                Toast.makeText( getApplicationContext(), "Egg is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.cheese:
                myDataBaseHandler.addProduct( "Cheese" );
                Toast.makeText( getApplicationContext(), "Cheese is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.milk:
                myDataBaseHandler.addProduct( "Milk" );
                Toast.makeText( getApplicationContext(), "Milk is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.yogurt:
                myDataBaseHandler.addProduct( "Yogurt" );
                Toast.makeText( getApplicationContext(), "Yogurt is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.butter:
                myDataBaseHandler.addProduct( "Butter" );
                Toast.makeText( getApplicationContext(), "Butter is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.cottage:
                myDataBaseHandler.addProduct( "Cottage Cheese" );
                Toast.makeText( getApplicationContext(), "Cottage Cheese is added", Toast.LENGTH_SHORT ).show();
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
