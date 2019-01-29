package com.example.testintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Aaa extends AppCompatActivity implements View.OnClickListener {
    private Button btnIntent;
    public Intent mIntent;
    static final private String mString = "This is Intent ";
    private int mInt=15;
    private char mChar='!';
    private TextView mTextView;
    private static final int mrequestCode=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIntent=findViewById(R.id.btn_intent);
        mTextView=findViewById(R.id.textView);

        btnIntent.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_intent:
                mIntent=new Intent(Aaa.this, Bbb.class);

                mIntent.putExtra("STRING", mString)
                .putExtra("DDD", mChar);
                startActivityForResult(mIntent, mrequestCode );
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        switch (requestCode){
            case mrequestCode:
                if(resultCode == RESULT_OK){
                    String str =data.getStringExtra("kod");
                    mTextView.setText(str);

                }
                break;

            default:
//                super.onActivityResult(requestCode, resultCode, data);
                break;
        }

    }
}
