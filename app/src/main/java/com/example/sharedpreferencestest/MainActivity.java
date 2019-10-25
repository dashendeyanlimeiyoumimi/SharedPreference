package com.example.sharedpreferencestest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        editText = findViewById(R.id.sp_et);
        button = findViewById(R.id.cun_btn);
        textView = findViewById(R.id.tv);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cun_btn:
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                String s = editText.getText().toString();
                editor.putString("name",s);
                editor.apply();
                SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
                String data = sharedPreferences.getString("name","");
                textView.setText(data);
                break;
        }
    }
}
