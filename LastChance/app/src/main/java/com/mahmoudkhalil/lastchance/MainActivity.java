package com.mahmoudkhalil.lastchance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.monkeylearn.MonkeyLearn;
import com.monkeylearn.MonkeyLearnException;
import com.monkeylearn.MonkeyLearnResponse;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = findViewById(R.id.text);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MonkeyLearn ml = new MonkeyLearn("153f5d945c1a889ceaa2a3c114bdb412e0e1c404");
                String modelId = "cl_9EdWizUg";
                String[] data = {"Great Sushi! Fresh and delicious. I have been looking for a good sushi restaurant since I moved to Milwaukee. Thursday Sushi madness is a great value. I would definitely go again."};
                MonkeyLearnResponse res = null;
                try {
                    res = ml.classifiers.classify(modelId, data, true);
                } catch (MonkeyLearnException e) {
                    e.printStackTrace();
                }
                assert res != null;
                Log.i("MainActivity", res.arrayResult.toString());
            }
        });
    }
}