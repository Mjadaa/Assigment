package com.example.assigment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class momentumQuestoin extends AppCompatActivity {
    private RadioGroup radioGroupM;
    private Button AnswerM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_momentum_questoin);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setUpViews();
        AnswerM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer();
            }
        });
    }

    private void setUpViews() {
        AnswerM = findViewById(R.id.AnswerM);
        radioGroupM=findViewById(R.id.radioGroupM);
    }
    private void CheckAnswer() {
        if (radioGroupM.getCheckedRadioButtonId()==R.id.MomentumD){
            Toast.makeText(this, "Corect Answer", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show();
    }


}