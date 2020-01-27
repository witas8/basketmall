package com.example.basketmall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class BasketHandler extends AppCompatActivity {

    DatabaseHelper db;
    Button addBtn, deleteAllBtn;
    EditText itemText;

    ArrayList<String> arrayList;
    ArrayAdapter adapter;
    ListView shoppingList;
    ImageView orangeBasket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_basket_handler );
        getSupportActionBar().setTitle("This is what you thrown"); // set the top title


        addBtn = findViewById( R.id.addButton );
        deleteAllBtn = findViewById( R.id.deleteAllButton );
        itemText = findViewById( R.id.myInput );
        shoppingList = findViewById( R.id.shoppingList );
        orangeBasket = findViewById( R.id.orangeBasket );
        db = new DatabaseHelper( this );
        arrayList = new ArrayList<>();

        adapter = new ArrayAdapter<>( this, R.layout.list_set_color_2, arrayList );
        shoppingList.setAdapter( adapter );


        printData();

        addBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String product = itemText.getText().toString();
                if (itemText.length() != 0) {
                    AddData( product );
                    itemText.setText( "" );
                    if(arrayList.contains( "Throw something to your basket" )){
                        arrayList.remove( 0 );
                        orangeBasket.setImageResource(0);
                        adapter.notifyDataSetChanged();
                    }
                    adapter.notifyDataSetChanged();
                    adapter.add( product );

                } else {
                    toastMessage( "Provide a product" );
                }
            }
        } );


        shoppingList.setOnItemLongClickListener( new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                String name = parent.getItemAtPosition( position ).toString();
                Cursor data = db.getItemID( name );

                int itemID = -1;
                while (data.moveToNext()) {
                    itemID = data.getInt( 0 );
                }
                if (itemID > -1) {
                    db.deleteItem( itemID, name );
                    arrayList.remove(name);
                    adapter.notifyDataSetChanged();

                }
                else {
                    orangeBasket.setImageResource( R.drawable.orange_basket );
                    toastMessage( "Basket is empty" );
                }

                if(arrayList.isEmpty()) {
                    arrayList.add( "Throw something to your basket" );
                    adapter.notifyDataSetChanged();
                    orangeBasket.setImageResource( R.drawable.orange_basket );
                }
                else{
                    orangeBasket.setImageResource(0);
                }

                if(arrayList.contains( "Throw something to your basket" )) {
                    orangeBasket.setImageResource( R.drawable.orange_basket );
                }

                return true;
            }
        } );

        shoppingList.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                toastMessage( "Click longer to delete item" );
            }
        });


        deleteAllBtn.setOnLongClickListener( new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                db.deleteAll();
                arrayList.clear();
                adapter.notifyDataSetChanged();
                itemText.setText( "" );
                if (arrayList.isEmpty()) {
                    arrayList.add( "Throw something to your basket" );
                    adapter.notifyDataSetChanged();
                    orangeBasket.setImageResource( R.drawable.orange_basket );
                    toastMessage( "Basket is empty" );
                }
                else{
                    orangeBasket.setImageResource(0);
                }

                return true;
            }
        } );

        deleteAllBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastMessage( "Hold a button" );
            }
        } );

    }


    public void printData() {
        Cursor cursor = db.getData();

        if(cursor.getCount()>0) {
            if (cursor.getCount() == 0) {
                arrayList.add( cursor.getString( 1 ) );
            } else {
                while (cursor.moveToNext()) {
                    arrayList.add( cursor.getString( 1 ) );
                }
            }
        }
        else{
            arrayList.add( "Throw something to your basket");
            orangeBasket.setImageResource( R.drawable.orange_basket );

        }
    }

    public void AddData(String product){
        boolean insertData = db.addProduct( product );

        if(insertData){
            toastMessage( "Product is added" );
        }
        else {
            toastMessage( "Something went wrong!" );
        }
    }

    private void toastMessage(String message){
        Toast.makeText( this, message, Toast.LENGTH_SHORT ).show();
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
