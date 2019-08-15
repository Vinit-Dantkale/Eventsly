package com.example.project82;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class EventDetailsActivity extends AppCompatActivity {
    public static String[] arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details);
        Bundle b=this.getIntent().getExtras();
        arr=b.getStringArray("arrvals");
        int i=0;
        if(arr.length==6){
            LinearLayout mainlay=(LinearLayout)findViewById(R.id.mainlay);
            Button accept=new Button(this);
            accept.setText("Accept");
            Button reject=new Button(this);
            reject.setText("Reject");
            mainlay.addView(accept);
            mainlay.addView(reject);
            reject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Invitation Rejected", Toast.LENGTH_SHORT).show();
                    DBHelper db=new DBHelper(getApplicationContext());
                    db.delinvitation(EventDetailsActivity.arr[0]);
                }
            });
            i=1;
        }
        TextView tv=(TextView) findViewById(R.id.evnval);
        tv.setText(arr[i]);
        TextView dt=(TextView) findViewById(R.id.datval);
        dt.setText(arr[i+1]);
        TextView ve=(TextView) findViewById(R.id.venval);
        ve.setText(arr[i+2]);
        TextView hv=(TextView) findViewById(R.id.hostval);
        hv.setText(arr[i+3]);
        TextView dv=(TextView) findViewById(R.id.detval);
        dv.setText(arr[i+4]);

    }
}
