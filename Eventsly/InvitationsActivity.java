package com.example.project82;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class InvitationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invitations);

        DBHelper dbh=new DBHelper(this);
        ArrayList<String[]> ar = dbh.getAllInvitations();
        TextView tv1=(TextView)findViewById(R.id.tempid);
        for(int i=0;i<ar.size();i++) {
            String temp[]=ar.get(i);
            tv1.setText(temp[0]+" "+temp[1]+" "+temp[2]+" "+temp[3]+" "+temp[4]+" ");
        }

    }
}
