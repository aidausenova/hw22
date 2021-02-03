package com.example.hw2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    Button button1,button2;
    String text;
    Uri image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.iv_main);
        textView = findViewById(R.id.tv_main);
        button1 = findViewById(R.id.btn_open);
        button2 = findViewById(R.id.open_gmail);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SacondActivity2.class);
                startActivityForResult(intent,1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL,"email@email.com");
                intent.putExtra(Intent.EXTRA_SUBJECT,"");
                intent.putExtra(Intent.EXTRA_TEXT,text);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null){
            text = data.getStringExtra("text");
            if (data.getStringExtra("image") != null){
                image = Uri.parse(data.getStringExtra("image"));
                imageView.setImageURI(image);
            }

            Log.d("TAG", "onActivityResult: ");
        }

    }


}