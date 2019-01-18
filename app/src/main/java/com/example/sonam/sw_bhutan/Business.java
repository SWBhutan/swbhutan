package com.example.sonam.sw_bhutan;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Business extends AppCompatActivity {

    Button subbtn;
    EditText name;
    EditText cid;
    EditText phone;
    EditText email;
    RadioGroup occupation;
    RadioButton radOccupation;
    RadioGroup location;
    String str_occupation;
    String str_location;
    int checked;
    int checked2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);

        name=findViewById(R.id.name);
        cid=findViewById(R.id.cid);
        phone=findViewById(R.id.phone);
        email=findViewById(R.id.email);
        subbtn=findViewById(R.id.submitbt);
        occupation=findViewById(R.id.occupation);
        location=findViewById(R.id.location);



    }
    private void Onsubmit(View view){
        String str_name= name.getText().toString();
        String  str_cid=cid.getText().toString();
        String str_phone=phone.getText().toString();
        String str_emal=email.getText().toString();
        occupation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                checked = occupation.indexOfChild(findViewById(checkedId));
                switch (checked){
                    case 0:
                        str_occupation="student";
                        break;
                    case 1:
                        str_occupation="employeed";
                        break;
                    case 2:
                        str_occupation="Looking for job";
                        break;
                    default:
                        str_occupation="None of above";
                        break;
                }
            }
        });
        location.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                checked2=location.indexOfChild(findViewById(checkedId));
                switch (checked2){
                    case 0:
                        str_location="Gaeddu College";
                        break;
                    case 1:
                        str_location="CST-Phuentsholing";
                        break;
                    case 2:
                        str_location="JNEC-Deothang";
                        break;
                    case 3:
                        str_location="Sherubtse College";
                        break;

                    case 4:
                        str_location="CLCS-Trongsa";
                        break;
                    case 5:
                        str_location="CNR-Punakha";
                        break;
                    default:
                        str_occupation="None of above";
                        break;
                }
            }
        });

        String type="submit";

        BackgroundWorker backgroundWorker=new BackgroundWorker(this);
        backgroundWorker.execute(type, str_name, str_cid, str_phone, str_emal,str_occupation, str_location);

    }

}
