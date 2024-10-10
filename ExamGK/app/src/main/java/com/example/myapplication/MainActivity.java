package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listCourse;
    ArrayList<Data> dataArrayList;
    DataAdapter dataAdapter;
    Button btnADD, btnEDIT, btnDELETE, btnViewCourse;
    EditText viewName, viewHP, viewHocPhi;
    public int counterEDIT = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnADD = findViewById(R.id.badd);
        btnEDIT = findViewById(R.id.bedit);
        btnDELETE = findViewById(R.id.bdelete);
        btnViewCourse = findViewById(R.id.viewcourse);
        listCourse = findViewById(R.id.listView);
        viewName = findViewById(R.id.edithovaten);
        viewHP = findViewById(R.id.editnamehp);
        viewHocPhi = findViewById(R.id.edithocphi);
        dataArrayList = new ArrayList<Data>();
        btnViewCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dataArrayList.size() == 0){
                    AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();
                    dialog.setTitle("WARNING");
                    dialog.setIcon(R.drawable.ic_launcher_background);
                    dialog.setMessage("Ban chưa nhap chua co du lieu nao, hay nhap du lieu?");
                    dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    dialog.show();
                }
                dataAdapter = new DataAdapter(getApplicationContext(), dataArrayList);
                listCourse.setAdapter(dataAdapter);
                registerForContextMenu(listCourse);
            }
        });
        btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewName.getText().toString().equals("") || viewHP.getText().toString().equals("") || viewHocPhi.getText().toString().equals("")){
                    AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();
                    dialog.setTitle("WARNING");
                    dialog.setIcon(R.drawable.ic_launcher_background);
                    dialog.setMessage("Ban chưa nhap chua nhap day du thong tin");
                    dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    dialog.show();
                }else{
                    dataArrayList.add(new Data(viewName.getText().toString(), viewHP.getText().toString(), viewHocPhi.getText().toString()));
                    AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();
                    dialog.setTitle("SUCCESS");
                    dialog.setIcon(R.drawable.ic_launcher_background);
                    dialog.setMessage("Da nhap du lieu thanh cong (^-^)");
                    dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    dialog.show();
                }
            }
        });
        btnEDIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String checkname = viewName.getText().toString();
                if (checkname.equals("")){
                    AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();
                    dialog.setTitle("WARNING");
                    dialog.setIcon(R.drawable.ic_launcher_background);
                    dialog.setMessage("Hay nhap ten truoc khi edit");
                    dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    dialog.show();
                }else{
                    for(int i = 0; i < dataArrayList.size(); i++){
                        if(dataArrayList.get(i).getName().equals(checkname)){
                            counterEDIT++;
                            if(counterEDIT == 2){
                                dataArrayList.get(i).setName(checkname);
                                dataArrayList.get(i).setNameHP(viewHP.getText().toString());
                                dataArrayList.get(i).setHocphi(viewHocPhi.getText().toString());
                                counterEDIT = 0;
                            }else{
                                viewName.setText(dataArrayList.get(i).getName());
                                viewHP.setText(dataArrayList.get(i).getNameHP());
                                viewHocPhi.setText(dataArrayList.get(i).getHocphi());
                            }
                            break;
                        }
                    }
                }
                dataAdapter.notifyDataSetChanged();
            }
        });
        btnDELETE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String checkname = viewName.getText().toString();
                if (checkname.equals("")){
                    AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();
                    dialog.setTitle("WARNING");
                    dialog.setIcon(R.drawable.ic_launcher_background);
                    dialog.setMessage("Hay nhap ten truoc khi remove");
                    dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    dialog.show();
                }else{
                    for(int i = 0; i < dataArrayList.size(); i++){
                        if(dataArrayList.get(i).getName().equals(checkname)){
                            dataArrayList.remove(i);
                            break;
                        }
                    }
                }
                dataAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int mind = item.getItemId();
        if(mind == R.id.itemDELETE){
            /*logic*/
            Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
        }else if(mind == R.id.itemEDIT){
            /*logic*/
            Toast.makeText(this, "Edit", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}