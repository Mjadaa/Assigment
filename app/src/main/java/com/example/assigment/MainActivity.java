package com.example.assigment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btnLog;
    public static final String NAME = "NAME";
    public static final String PASS = "PASS";
    public static final String FLAG = "FLAG";
    private boolean flag = false;
    private EditText edtName;
    private EditText edtPassword;
    private CheckBox edtChkBox;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setupViews();
        setupSharedPrefs();
        checkPrefs();

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String password = edtPassword.getText().toString();
                if (name.equals("user")&& password.equals("user")){
                    if(edtChkBox.isChecked()){
                        if(!flag) {
                            editor.putString(NAME, name);
                            editor.putString(PASS, password);
                            editor.putBoolean(FLAG, true);
                            editor.apply();
                        }

                    }
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);}
                else {
                    Toast.makeText(MainActivity.this, "Try Again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setupViews() {
        btnLog = findViewById(R.id.btnLog);
        edtName = findViewById(R.id.edtName);
        edtPassword = findViewById(R.id.edtPassword);
        edtChkBox = findViewById(R.id.edtChkBox);
    }

    private void checkPrefs() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        flag = prefs.getBoolean(FLAG, false);

        if(flag){
            String name = prefs.getString(NAME, "");
            String password = prefs.getString(PASS, "");
            edtName.setText(name);
            edtPassword.setText(password);
            edtChkBox.setChecked(true);
        }
    }

    private void setupSharedPrefs() {
        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }
}




