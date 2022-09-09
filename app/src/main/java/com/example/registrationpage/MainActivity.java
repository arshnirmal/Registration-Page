package com.example.registrationpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button submit;
    EditText name,email,day,month,year;
    RegisterationInput registerationInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.Submit);
        name = findViewById(R.id.FullName);
        email = findViewById(R.id.emailID);
        day = findViewById(R.id.Day);
        month = findViewById(R.id.Month);
        year = findViewById(R.id.Year);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    registerationInput = new RegisterationInput(name.getText().toString(),email.getText().toString(),
                            Integer.parseInt(day.getText().toString()),Integer.parseInt(month.getText().toString()),
                            Integer.parseInt(year.getText().toString()));
                    Toast.makeText(MainActivity.this,"Submitted",Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
                    registerationInput = new RegisterationInput("error","error",-1,-1,-1);
                }
                MyDataBase myDataBase = new MyDataBase(MainActivity.this);
                boolean success = myDataBase.addOne(registerationInput);
                Toast.makeText(MainActivity.this,"Success = "+success,Toast.LENGTH_SHORT).show();
            }
        });
    }
}