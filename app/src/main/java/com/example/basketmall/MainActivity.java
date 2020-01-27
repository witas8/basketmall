package com.example.basketmall;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> myList = new ArrayList<>( Arrays.asList( "Fruit", "Vegetables", "Dairy",
            "Meat and Fish", "Canned and Jarred", "Dry and Baking", "Drinks", "Personal Care",
            "Cleaners", "Others" ) );

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
        setContentView( R.layout.activity_main );

        getSupportActionBar().setTitle("Throw stuff to your basket"); // set the top title

        final ListView categoryList = findViewById( R.id.categoryList);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>( this, R.layout.list_set_color, myList);
        categoryList.setAdapter( myAdapter );

        categoryList.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Intent intent = new Intent(MainActivity.this, AisleFruit.class);
                    startActivity( intent );
                }
                else if (position == 1){
                    Intent intent = new Intent(MainActivity.this, AisleVegetables.class);
                    startActivity( intent );
                }
                else if (position == 2){
                    Intent intent = new Intent(MainActivity.this, AisleDairy.class);
                    startActivity( intent );
                }
                else if (position == 3){
                    Intent intent = new Intent(MainActivity.this, AisleMeatFish.class);
                    startActivity( intent );
                }
                else if (position == 4){
                    Intent intent = new Intent(MainActivity.this, AisleCannedJarred.class);
                    startActivity( intent );
                }
                else if (position == 5){
                    Intent intent = new Intent(MainActivity.this, AisleDryBaking.class);
                    startActivity( intent );
                }
                else if (position == 6){
                    Intent intent = new Intent(MainActivity.this, AisleDrinks.class);
                    startActivity( intent );
                }
                else if (position == 7){
                    Intent intent = new Intent(MainActivity.this, AislePersonalCare.class);
                    startActivity( intent );
                }
                else if (position == 8){
                    Intent intent = new Intent(MainActivity.this, AisleCleaners.class);
                    startActivity( intent );
                }
                else if (position == 9){
                    Intent intent = new Intent(MainActivity.this, AisleOthers.class);
                    startActivity( intent );
                }
            }
        } );
    }
}
