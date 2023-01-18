package com.example.lab4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RelativeLayout My_Layout;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_1,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        TextView Text = (TextView)findViewById(R.id.Result_TextView);
        EditText Num_1= (EditText)findViewById(R.id.First_Number_Edit_Text);
        EditText Num_2= (EditText)findViewById(R.id.Second_Number_Edit_Text);
        float Result;

        switch (item.getItemId()){
            case R.id.Plus:
                Result = Float.valueOf(Num_1.getText().toString()) + Float.valueOf(Num_2.getText().toString());
                Text.setText(Float.toString(Result));
                return true;
            case R.id.Minus:
                Result = Float.valueOf(Num_1.getText().toString()) - Float.valueOf(Num_2.getText().toString());
                Text.setText(Float.toString(Result));
                return true;
            case R.id.Absolute_Minus:
                Result = Math.abs(Float.valueOf(Num_1.getText().toString()) - Float.valueOf(Num_2.getText().toString()));
                Text.setText(Float.toString(Result));
                return true;
            case R.id.Multiply:
                Result = Float.valueOf(Num_1.getText().toString()) * Float.valueOf(Num_2.getText().toString());
                Text.setText(Float.toString(Result));
                return true;
            case R.id.Divide:
                Result = Float.valueOf(Num_1.getText().toString()) / Float.valueOf(Num_2.getText().toString());
                Text.setText(Float.toString(Result));
                return true;
            case R.id.Modulus:
                Result = Float.valueOf(Num_1.getText().toString()) % Float.valueOf(Num_2.getText().toString());
                Text.setText(Float.toString(Result));
                return true;
            case R.id.Power:
                Result = (float) Math.pow(Float.valueOf(Num_1.getText().toString()) ,Float.valueOf(Num_2.getText().toString()));
                Text.setText(Float.toString(Result));
                return true;
            case R.id.Negative_Power:
                Result = (float) Math.pow(Float.valueOf(Num_1.getText().toString()) ,-Float.valueOf(Num_2.getText().toString()));
                Text.setText(Float.toString(Result));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Link those objects with their respective id's
        // that we have given in .XML file
        TextView Result = (TextView) findViewById(R.id.Assignment_4);
         My_Layout = (RelativeLayout)findViewById(R.id.Relative_Layout);
        // here you have to register a view for context menu
        // you can register any view like listview, image view,
        // textview, button etc
        registerForContextMenu(Result);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // you can set menu header with title icon etc
        menu.setHeaderTitle("Pick a color");
        // add menu items
        menu.add(0, v.getId(), 0, "Red");
        menu.add(0, v.getId(), 0, "Green");
        menu.add(0, v.getId(), 0, "Cyan");
        menu.add(0, v.getId(), 0, "Yellow");
        menu.add(0, v.getId(), 0, "Gray");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if (item.getTitle() == "Yellow") {
            My_Layout.setBackgroundColor(Color.YELLOW);
        } else if (item.getTitle() == "Gray") {
            My_Layout.setBackgroundColor(Color.GRAY);
        } else if (item.getTitle() == "Cyan") {
            My_Layout.setBackgroundColor(Color.CYAN);
        } else if (item.getTitle() == "Red") {
            My_Layout.setBackgroundColor(Color.RED);
        } else if (item.getTitle() == "Green") {
            My_Layout.setBackgroundColor(Color.GREEN);
        }
        return true;
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder My_Alert_Dialog = new AlertDialog.Builder(MainActivity.this);
        My_Alert_Dialog.setMessage("Are You Sure You Want To Exit The Application ?");
        My_Alert_Dialog.setTitle("Alert !");
        My_Alert_Dialog.setCancelable(true);

        My_Alert_Dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        My_Alert_Dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog AD = My_Alert_Dialog.create();
        AD.show();
    }
}