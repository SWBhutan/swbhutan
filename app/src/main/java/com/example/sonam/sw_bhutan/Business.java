package com.example.sonam.sw_bhutan;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Business extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner occspinner;
    Spinner locspinner;
    ArrayList<String> data=new ArrayList<String>();
    ArrayList<String> data2=new ArrayList<String >();
    ArrayAdapter <String> adapter;
    ArrayAdapter <String> adapter2;
    TextView textView;
    TextView textView2;
    Button canbtn;
    Button regbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);
        textView = findViewById(R.id.edit3);
        textView2=findViewById(R.id.edit4);
        textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        textView2.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        occspinner=findViewById(R.id.occSpinner);
        locspinner=findViewById(R.id.locSpinner);
        data.add("Student");
        data.add("Employed");
        data.add("Looking for job");
        data2.add("Gaeddu College");
        data2.add("CST-Phuentsholing");
        data2.add("JNEC-Deothang");
        data2.add("Sherubtse College");
        data2.add("CLCS-Trongsa");
        data2.add("CNR-Punakha");

        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, data);
        adapter2=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, data2);
        occspinner.setAdapter(adapter);
        locspinner.setAdapter(adapter2);

        canbtn=findViewById(R.id.cancelbt);
        regbtn=findViewById(R.id.registerbt);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
