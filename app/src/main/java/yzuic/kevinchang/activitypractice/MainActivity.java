package yzuic.kevinchang.activitypractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private LinearLayout ll;
    private Button btnGo;
    private NumberPicker numberPicker;
    String[] arrChiNum = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init LinearLayout ll
        ll = (LinearLayout) findViewById(R.id.mainLayout);
        ll.setWeightSum(1);

        // init numberPicker
        numberPicker = new NumberPicker(this);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(arrChiNum.length - 1);
        //numberPicker.setGravity(View.TEXT_ALIGNMENT_CENTER);

        // init btnGo
        btnGo = new Button(this);
        btnGo.setText("Go to SecondActivity");

        // add btnGo and numberPicker to ll
        ll.addView(numberPicker);
        ll.addView(btnGo);

        // btnGo onClick
        btnGo.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                // use bundle to save something you want bring to SecondActivity
                Bundle bundle = new Bundle();
                bundle.putInt("npValue", numberPicker.getValue()); // put something(int/string/char...) into bundle (key , value)

                // use intent to bring something to SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtras(bundle); // put something(bundle/int/string/char...) into intent
                startActivityForResult(intent, 0); // call SecondActivity and request return value
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bundle bd = data.getExtras(); // get return value from SecondActivity
        // show return value from SecondActivity
        Toast.makeText(getApplicationContext(), arrChiNum[bd.getInt("returnValue")], Toast.LENGTH_SHORT).show();
    }
}

// GitHub URL : https://github.com/d900139/ActivityPractice
