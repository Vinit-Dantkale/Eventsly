package com.example.project82;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewEventFormActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String seldate="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_event_form);

        Spinner ses=(Spinner)findViewById(R.id.selecteventspinner);
        ses.setOnItemSelectedListener(this);

        List<String> li=new ArrayList<>();
        li.add("Wedding");
        li.add("Aniversary");
        li.add("Birthday Party");
        li.add("Get-Together");
        li.add("Reception");
        li.add("Other");

        ArrayAdapter choices=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,li);
        choices.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ses.setAdapter(choices);

        CalendarView calender = (CalendarView)findViewById(R.id.calen);
        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // TODO Auto-generated method stub
                seldate=""+year+"-";
                if(month<10){
                    seldate+="0"+(month+1);
                }
                else{
                    seldate+=""+(month+1);
                }

                if(dayOfMonth<10){
                    seldate+="-0"+(dayOfMonth);
                }
                else{
                    seldate+="-"+(dayOfMonth);
                }
                Toast.makeText(NewEventFormActivity.this,seldate,Toast.LENGTH_LONG).show();
            }
        });


    }

    public void geteventdetails(View v){
        String[] temp=new String[6];
        Spinner spr=(Spinner)findViewById(R.id.selecteventspinner);
        temp[0]=spr.getSelectedItem().toString();
        temp[1]=seldate;
        EditText et=(EditText)findViewById(R.id.vendet);
        temp[2]=et.getText().toString();
        et=findViewById(R.id.hostdet);
        temp[3]=et.getText().toString();
        et=findViewById(R.id.evndet);
        temp[4]=et.getText().toString();
        if(temp[0]==""||temp[1]==""||temp[2]==""||temp[3]==""||temp[4]=="")
        {Toast.makeText(this,"Fill all fields",Toast.LENGTH_LONG).show();}
        else{
            Toast.makeText(this,"Invitation done",Toast.LENGTH_LONG).show();
            DBHelper dbh=new DBHelper(this);
            dbh.insinvitations(temp);
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String event=parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
