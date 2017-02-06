package com.sky.sky.printtext.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sky.sky.printtext.R;
import com.sky.sky.printtext.widget.PrinterTextView;

public class DetailActivity extends AppCompatActivity {

    PrinterTextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        textView = (PrinterTextView) findViewById(R.id.text);
        String str = getIntent().getStringExtra("str");
        textView.setText(str);
        textView.startPrint();

    }
}
