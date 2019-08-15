package com.example.project82;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ContentMain extends AppCompatActivity implements View.OnClickListener{

LinearLayout ll=(LinearLayout)findViewById(R.id.mainlayout);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        //Button but1=(Button)findViewById(R.id.but1);

        /*but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.event_details);
            }
        });
    */
        //TableLayout table=(TableLayout)findViewById(R.id.table1);
        for(int i=0;i<15;i++) {
            //TableRow tr=new TableRow(this);
            //TableRow.LayoutParams lp=new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            //tr.setLayoutParams(lp);
            TextView eventtitle=new TextView(this);
            eventtitle.setText("Event : ");
            //tr.addView(eventtitle);
            //table.addView(tr,i);
            ll.addView(eventtitle);
        }
        //setContentView(table);

    }

    @Override
    public void onClick(View v) {

    }
}
