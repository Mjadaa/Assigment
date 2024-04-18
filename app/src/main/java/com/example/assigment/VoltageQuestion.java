package com.example.assigment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VoltageQuestion extends AppCompatActivity {
    private RadioGroup radioGroupV;
    private Button AnswerV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_voltage_question);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setUpViews();
        AnswerV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer();
            }
        });
    }
    private void setUpViews() {
        AnswerV = findViewById(R.id.AnswerM);
        radioGroupV=findViewById(R.id.radioGroupM);
    }
    private void CheckAnswer() {
        if (radioGroupV.getCheckedRadioButtonId()==R.id.voltageA){
            Toast.makeText(this, "Corect Answer", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show();
    }

}