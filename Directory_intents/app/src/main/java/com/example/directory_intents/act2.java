package com.example.directory_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class act2 extends AppCompatActivity {

    EditText name;
    EditText number;
    EditText address;
    Button bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        name = findViewById(R.id.name);
        number = findViewById(R.id.number);
        address = findViewById(R.id.address);
        bt2 = findViewById(R.id.bt2);





            bt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (name.getText().toString().isEmpty() || number.getText().toString().isEmpty() || address.getText().toString().isEmpty()) {
                        Toast.makeText(act2.this, "all fields are compulsory", Toast.LENGTH_SHORT).show();
                    } else {
                        String n = name.getText().toString().trim();
                        String nu = number.getText().toString().trim();
                        String add = address.getText().toString().trim();


                        Intent intent = new Intent(act2.this, com.example.directory_intents.act3.class);
                        intent.putExtra("name", n);
                        intent.putExtra("number", nu);
                        intent.putExtra("address", add);

                        startActivityForResult(intent,3);




                    }
                }
            });



        }
    }

