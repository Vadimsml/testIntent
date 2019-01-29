package com.example.testintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Bbb extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextView;
    public String mString="Were is Intent?";
    public int mInt=0;
    char mChar;
    private Button mButton;
    private String mAnswer="неполучилось";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bbb);

        Intent miIntent=getIntent();
        mString =miIntent.getStringExtra("STRING");
        mChar = miIntent.getCharExtra("DDD",'w');

        mTextView=findViewById(R.id.textViewBbb);
        mButton=findViewById(R.id.answer);




        String m_String=mString+mChar+mChar+mChar;
        mTextView.setText(m_String);
        mButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.answer:
                mAnswer="получилось У-Р-А-А-А-А !!!";
                Intent intent=new Intent();
                intent.putExtra("kod",mAnswer);
                setResult(RESULT_OK, intent);
        }
    }
}
