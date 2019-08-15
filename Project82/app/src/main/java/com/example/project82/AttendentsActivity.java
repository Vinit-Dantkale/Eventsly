package com.example.project82;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AttendentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attendents);

        String[] arr = { "Cook", "Decorator","Dancers",
                "Caterers", "Music Bands","Singers"};
        String[] cities = { "Tiruchirapalli", "Vadodara","Thiruvananthapuram",
        "Mumbai","Chennai","Kochi","Kolkata","Puducherry","Kanpur","Belagavi","Indore"
                ,"Panaji","Pune","Shimla","Visakhapatnam","Bengaluru"
        };

        AutoCompleteTextView autocomplete = (AutoCompleteTextView)
                findViewById(R.id.attendtype);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, arr);

        autocomplete.setAdapter(adapter);

        AutoCompleteTextView autocomplete1 = (AutoCompleteTextView)
                findViewById(R.id.locname);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, cities);

        autocomplete1.setAdapter(adapter1);
    }

    public void showsearch(View v){
        AutoCompleteTextView autocomplete = (AutoCompleteTextView)
                findViewById(R.id.attendtype);
        String attype=autocomplete.getText().toString();
        autocomplete = (AutoCompleteTextView)findViewById(R.id.locname);
        String loc=autocomplete.getText().toString();

        if(attype.length()==0||loc.length()==0){
            Toast.makeText(this,"Fields Are Empty",Toast.LENGTH_SHORT).show();
        }
        else {
            DBHelper dbh = new DBHelper(this);
            ArrayList<String[]> ar = dbh.getAllCotacts(attype,loc);
            LinearLayout myRoot = (LinearLayout) findViewById(R.id.attendantsmain);
            if(ar.size()==0){
                Toast.makeText(this,"No Attendants Found",Toast.LENGTH_LONG).show();
                myRoot.removeAllViews();
            }
            else{
            for (int i = 0; i < ar.size(); i++) {
                myRoot.removeAllViews();
                LinearLayout a = new LinearLayout(this);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.setMargins(15, 15, 15, 15);
                a.setLayoutParams(params);
                a.setOrientation(LinearLayout.VERTICAL);
                a.setPadding(15, 15, 15, 15);
                a.setBackgroundColor(getResources().getColor(R.color.tigerorange));
                String temp[] = ar.get(i);

                TextView t1 = new TextView(this);
                t1.setBackgroundColor(getResources().getColor(R.color.tigerorange));
                t1.setText(temp[1]);
                t1.setTextSize(25);
                t1.setTextColor(Color.WHITE);
                a.addView(t1);

                TextView t2 = new TextView(this);
                t2.setBackgroundColor(Color.WHITE);
                t2.setText(temp[2]);
                t2.setTextSize(20);
                a.addView(t2);

                TextView t3 = new TextView(this);
                t3.setBackgroundColor(Color.WHITE);
                t3.setText(temp[3]);
                t3.setTextSize(20);
                a.addView(t3);

                TextView t4 = new TextView(this);
                t4.setBackgroundColor(Color.WHITE);
                t4.setText(temp[4] + " , " + temp[5]);
                t4.setTextSize(20);
                a.addView(t4);

                myRoot.addView(a);
            }
        }   }
    }

}
