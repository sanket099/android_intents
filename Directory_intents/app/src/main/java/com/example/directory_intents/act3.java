package com.example.directory_intents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class act3 extends AppCompatActivity {

    Button call;
    Button find;
    String num;
    String geo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);

        call = findViewById(R.id.call);
        find = findViewById(R.id.find);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                num = getIntent().getStringExtra("number");

                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+ num));
                startActivity(intent);





            }
        });
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                geo = getIntent().getStringExtra("address");
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q=" + geo));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        {
            if (requestCode == 3) {
                if (resultCode == RESULT_OK) {
                    call.setVisibility(View.VISIBLE);

                    num = getIntent().getStringExtra("number");
                    geo = getIntent().getStringExtra("address");




                }
            }

        }
    }
}
