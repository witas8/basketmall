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

public class AisleCannedJarred extends AppCompatActivity implements View.OnClickListener{

    ImageView corn, olives, tomatoSauce, peas, coconut, bean, jam, jalapeno, fish, honey, gherkin, sauceBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_aisle_canned_jarred );

        corn = (ImageView) findViewById( R.id.corn );
        olives = (ImageView) findViewById( R.id.olives );
        tomatoSauce = (ImageView) findViewById( R.id.tomatoSauce );
        peas = (ImageView) findViewById( R.id.peas );
        coconut = (ImageView) findViewById( R.id.coconut );
        bean = (ImageView) findViewById( R.id.beam );
        jam = (ImageView) findViewById( R.id.jam );
        jalapeno = (ImageView) findViewById( R.id.jalapeno );
        fish = (ImageView) findViewById( R.id.fish );
        honey = (ImageView) findViewById( R.id.honey);
        gherkin = (ImageView) findViewById( R.id.gherkin );
        sauceBean = (ImageView) findViewById( R.id.whiteBeam );

        corn.setOnClickListener( this );
        olives.setOnClickListener( this );
        tomatoSauce.setOnClickListener( this );
        peas.setOnClickListener( this );
        coconut.setOnClickListener( this );
        bean.setOnClickListener( this );
        jam.setOnClickListener( this );
        jalapeno.setOnClickListener( this );
        fish.setOnClickListener( this );
        honey.setOnClickListener( this );
        gherkin.setOnClickListener( this );
        sauceBean.setOnClickListener( this );

    }

    public void onClick(View v) {
        final DatabaseHelper myDataBaseHandler = new DatabaseHelper( this );

        switch (v.getId()) {
            case R.id.corn:
                myDataBaseHandler.addProduct( "Corn" );
                Toast.makeText( getApplicationContext(), "Corn is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.olives:
                myDataBaseHandler.addProduct( "Olives" );
                Toast.makeText( getApplicationContext(), "Olives are added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.tomatoSauce:
                myDataBaseHandler.addProduct( "Tomato Sauce" );
                Toast.makeText( getApplicationContext(), "Tomato Sauce is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.peas:
                myDataBaseHandler.addProduct( "Peas" );
                Toast.makeText( getApplicationContext(), "Peas is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.coconut:
                myDataBaseHandler.addProduct( "Coconut Milk" );
                Toast.makeText( getApplicationContext(), "Coconut Milk is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.beam:
                myDataBaseHandler.addProduct( "Beans" );
                Toast.makeText( getApplicationContext(), "Beans are added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.jam:
                myDataBaseHandler.addProduct( "Jam" );
                Toast.makeText( getApplicationContext(), "Jam is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.jalapeno:
                myDataBaseHandler.addProduct( "Jalapeno" );
                Toast.makeText( getApplicationContext(), "Jalapeno is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.fish:
                myDataBaseHandler.addProduct( "Sprat" );
                Toast.makeText( getApplicationContext(), "Sprat is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.honey:
                myDataBaseHandler.addProduct( "Honey" );
                Toast.makeText( getApplicationContext(), "Honey is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.gherkin:
                myDataBaseHandler.addProduct( "Gherkin" );
                Toast.makeText( getApplicationContext(), "Gherkin is added", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.whiteBeam:
                myDataBaseHandler.addProduct( "Bean in Sauce" );
                Toast.makeText( getApplicationContext(), "Bean in Sauce is added", Toast.LENGTH_SHORT ).show();
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
