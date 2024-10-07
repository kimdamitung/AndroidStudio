package com.example.myapplication;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    Button btnWrite, btnRead;
    EditText edittext;
    TextView showtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRead = findViewById(R.id.read);
        btnWrite = findViewById(R.id.write);
        edittext = findViewById(R.id.editText);
        showtext = findViewById(R.id.showText);
        edittext.setText("");
        showtext.setText("");
        deleteFile("duytung.txt");
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeInternalCard();
            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readInternalCard();
            }
        });
    }
    public void readInternalCard(){
        try{
            FileInputStream inputStream = openFileInput("duytung.txt");
            int lenght = inputStream.available();
            byte[] buffer = new byte[lenght];
            inputStream.read(buffer);
            inputStream.close();
            String string = new String(buffer);
            showtext.setText(string);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void writeInternalCard(){
        try{
            String string = edittext.getText().toString();
            FileOutputStream fileOutputStream = openFileOutput("duytung.txt", Context.MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(string);
            outputStreamWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}