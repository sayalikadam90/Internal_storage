package com.example.internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    EditText edt1,edt2;
    Button btnsave,btnread;
    String Filename,Contentname;
    String inputstring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);

        btnsave=findViewById(R.id.btnsave);
        btnread=findViewById(R.id.btnread);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Filename = edt1.getText().toString().trim();
                Contentname = edt2.getText().toString().trim();

                FileOutputStream fos;

                try {
                    fos = openFileOutput(Filename, Context.MODE_PRIVATE);
                    fos.write(Contentname.getBytes());
                    fos.close();

                    Log.d("TAG", "File Saved");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            });

        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fin = openFileInput(Filename);
                    int d;
                    String temp = "";
                    while ((d = fin.read()) != -1) {

                        temp = temp + Character.toString((char) d);
                    }
                    Log.d("TAG","Read File"+"/n"+temp);
                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        });
    }
}