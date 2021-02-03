package com.example.hw2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SacondActivity2 extends AppCompatActivity {

    ImageView imageView2;
    EditText editText;
    Button  buttonSecond;
    Uri uri;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sacond2);

        imageView2 = findViewById(R.id.iv_main2);
        editText = findViewById(R.id.et_2);
        buttonSecond = findViewById(R.id.btn_2);

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, 1);
            }
        });
        buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if (uri != null){
                    intent.putExtra("image",uri.toString());
                }
                intent.putExtra("text",editText.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            Log.e("TAG", "onActivityResult: ");
            uri = data.getData();
            imageView2.setImageURI(uri);

        }
    }
}