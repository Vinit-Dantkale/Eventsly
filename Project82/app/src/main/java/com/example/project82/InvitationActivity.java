package com.example.project82;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class InvitationActivity extends AppCompatActivity {
    public static ArrayList<String[]> ar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invitation);


        DBHelper dbh=new DBHelper(this);

        ar = dbh.getAllInvitations();
        /*
        TextView tv1=(TextView)findViewById(R.id.tempid);
        tv1.setText(ar.size()+"--------");
        for(int i=0;i<ar.size();i++) {
            String temp[]=ar.get(i);
            tv1.setText(tv1.getText().toString()+temp[0]+" "+temp[1]+" "+temp[2]+" "+temp[3]+" "+temp[4]+" ");
        }
        */

        LinearLayout myRoot = (LinearLayout) findViewById(R.id.maininvitations);

        for (int i = 0; i < ar.size(); i++) {
            LinearLayout a = new LinearLayout(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(15, 15, 15, 15);
            a.setId(i);

            a.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(InvitationActivity.this,EventDetailsActivity.class);
                    Bundle b=new Bundle();
                    //String temp[]=InvitationActivity.ar.get(v.getId());
                    //temp=Arrays.copyOfRange(temp,1,6))
                    b.putStringArray("arrvals",InvitationActivity.ar.get(v.getId()));
                    intent.putExtras(b);
                    startActivity(intent);
                }
            });
            a.setLayoutParams(params);
            a.setOrientation(LinearLayout.VERTICAL);
            a.setPadding(15, 15, 15, 15);
            String temp[] = ar.get(i);

            TextView t1 = new TextView(this);
            t1.setText(temp[1]);
            t1.setTextSize(30);
            t1.setTextColor(Color.WHITE);
            a.addView(t1);
            Typeface typeface = ResourcesCompat.getFont(this, R.font.raleway_bold);
            t1.setTypeface(typeface);

            if(i%4==0){
                a.setBackgroundColor(getResources().getColor(R.color.blue));
                t1.setBackgroundColor(getResources().getColor(R.color.blue));
            }
            if(i%4==1){
                a.setBackgroundColor(getResources().getColor(R.color.red));
                t1.setBackgroundColor(getResources().getColor(R.color.red));
            }
            if(i%4==2){
                a.setBackgroundColor(getResources().getColor(R.color.yellow));
                t1.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            if(i%4==3){
                a.setBackgroundColor(getResources().getColor(R.color.green));
                t1.setBackgroundColor(getResources().getColor(R.color.green));
            }

            TextView t2 = new TextView(this);
            t2.setBackgroundColor(Color.WHITE);
            t2.setText(temp[2]+" , "+temp[3]);
            t2.setTextSize(25);
            typeface = ResourcesCompat.getFont(this, R.font.raleway_semibold);
            t2.setTypeface(typeface);

            a.addView(t2);

            myRoot.addView(a);
        }


    }
}
