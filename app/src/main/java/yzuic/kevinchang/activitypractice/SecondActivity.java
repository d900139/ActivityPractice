package yzuic.kevinchang.activitypractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private LinearLayout ll;
    private Button btnBack;
    private TextView textView;
    String[] arrEngNum = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // init LinearLayout ll btnBack and textView
        ll = (LinearLayout) findViewById(R.id.secondLayout);
        btnBack = new Button(this);
        textView = new TextView(this);

        // get value from MainActivity
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        final int npValue = bundle.getInt("npValue");
        textView.setText(arrEngNum[npValue]); // set text to textView
        textView.setGravity(View.TEXT_ALIGNMENT_CENTER);
        textView.setTextSize(20);

        // add btnBack and textView to ll
        ll.addView(textView);
        ll.addView(btnBack);

        btnBack.setText("Back to MainActivity");
        btnBack.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                // return value to MainActivity
                Intent it = new Intent(SecondActivity.this, MainActivity.class);
                Bundle bd = new Bundle();
                bd.putInt("returnValue",npValue);
                it.putExtras(bd);
                setResult(0, it);
                finish();
            }
        });
    }
}

// GitHub URL : https://github.com/d900139/ActivityPractice