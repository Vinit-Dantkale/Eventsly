package com.example.project82;

import android.database.Cursor;
import java.util.ArrayList;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.util.Log;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {
    public static String[] arr1= { "Cook", "Decorator","Dancers",
            "Caterers", "Music Bands","Singers"};
    public static String[] cities = { "Tiruchirapalli", "Vadodara","Thiruvananthapuram",
            "Mumbai","Chennai","Kochi","Kolkata","Puducherry","Kanpur","Belagavi","Indore"
            ,"Panaji","Pune","Shimla","Visakhapatnam","Bengaluru"
    };
    public static String[][] arr={{"Birthday Party","2019-02-02","M G Hall, Mumbai","Mr Salman Khan","Hiran ZINDA Hai"},
            {"Wedding","2018-10-11","Sachin Hall, Bandra","Mr Tendlya","Aila..!!!"},
            {"Reception","2019-10-10","Virat Hall, Anushka","Mr Bh#$%^d","Insta Likes.... *Facepalm*"},
            {"Aniverasy","2018-11-12","MS Dawni, Delhi","Mr Ziva","Idhar dekh le B...ke"},
            {"Other","2019-06-06","Nowhere, Assam","Mr SRK","KKK... Kiran"},
            {"Get_together","2019-11-11","Noname, NoShame","Mr India","Jhakas..."}
    };
    public static String[][] names={
            {"Evan Strotton","179-260-5133","estrotton0@photobucket.com"},
            {"Aldo Gilliam","431-448-4982","agilliam1@arstechnica.com"},
            {"Damian Billitteri","799-116-7486","dbillitteri2@acquirethisname.com"},
            {"Robena Northedge","655-722-8724","rnorthedge3@businessweek.com"},
            {"Elihu Aylott","422-937-5055","eaylott4@symantec.com"},
            {"Pearce Spino","771-666-6804","pspino5@tripod.com"},
            {"Wayne Ojeda","513-172-5416","wojeda6@google.pl"},
            {"Radcliffe Larcombe","169-989-6648","rlarcombe7@opensource.org"},
            {"Saudra Bonifazio","876-402-9939","sbonifazio8@bandcamp.com"},
            {"Jinny Macia","415-552-2751","jmacia9@parallels.com"},
            {"Vittoria Vahl","877-160-6317","vvahla@webeden.co.uk"},
            {"Fidole Steaning","914-471-5331","fsteaningb@addtoany.com"},
            {"Gunter Rivilis","814-342-8681","grivilisc@hatena.ne.jp"},
            {"Wilhelm Camoletto","560-776-6937","wcamolettod@webnode.com"},
            {"Dallis Filippi","552-417-1720","dfilippie@acquirethisname.com"},
            {"Thorsten Suffe","566-257-2072","tsuffef@sbwire.com"},
            {"Ellary Combe","365-522-2416","ecombeg@marriott.com"},
            {"Carlin Piperley","182-657-7129","cpiperleyh@state.tx.us"},
            {"Gilberta Axleby","921-479-0801","gaxlebyi@disqus.com"},
            {"Illa Braid","770-837-8052","ibraidj@scientificamerican.com"}
    };



    public DBHelper(Context context) {
        super(context,"eventmanagement", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table if not exists attendants (id integer primary key, name text,phone text,email text,attendantstype text,location text)");
        for(int i=0;i<20;i++) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id",i+1);
            contentValues.put("name", names[i][0]);
            contentValues.put("phone", names[i][1]);
            contentValues.put("email", names[i][2]);
            contentValues.put("attendantstype", arr1[i%6]);
            contentValues.put("location", cities[i%16]);
            db.insert("attendants", null, contentValues);
        }

/*
        Log.v("","111111111111111111111111111111111111111111111");
        db.execSQL("create table if not exists invitations (id integer primary key, event text,eventdate text,venue text,host text,details text)");
        Log.v("","222222222222222222222222222222222222222222222");
        for(int i=0;i<5;i++) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id",i+1);
            contentValues.put("event", arr[i][0]);
            contentValues.put("eventdate", arr[i][1]);
            contentValues.put("venue", arr[i][2]);
            contentValues.put("host", arr[i][3]);
            contentValues.put("details", arr[i][4]);
            db.insert("invitations", null, contentValues);
        }
*/
    }

    public ArrayList<String[]> getAllCotacts(String attype,String loc) {
        ArrayList<String[]> array_list = new ArrayList<String[]>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from attendants where attendantstype='"+attype+"' and location='"+loc+"'", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            String temp[]=new String[6];
            temp[0] =res.getString(res.getColumnIndex("id"));
            temp[1] =res.getString(res.getColumnIndex("name"));
            temp[2] =res.getString(res.getColumnIndex("phone"));
            temp[3] =res.getString(res.getColumnIndex("email"));
            temp[4] =res.getString(res.getColumnIndex("location"));
            temp[5] =res.getString(res.getColumnIndex("attendantstype"));
            array_list.add(temp);
            res.moveToNext();
        }
        return array_list;
    }

    public ArrayList<String[]> getAllInvitations() {
        ArrayList<String[]> array_list = new ArrayList<String[]>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from invitations", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            String temp[]=new String[6];
            temp[0] =res.getString(res.getColumnIndex("id"));
            temp[1] =res.getString(res.getColumnIndex("event"));
            temp[2] =res.getString(res.getColumnIndex("eventdate"));
            temp[3] =res.getString(res.getColumnIndex("venue"));
            temp[4] =res.getString(res.getColumnIndex("host"));
            temp[5] =res.getString(res.getColumnIndex("details"));
            array_list.add(temp);
            res.moveToNext();
        }
        return array_list;
    }

    public void delinvitation(String s){
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("delete from invitations where id='"+s+"'");
        db.close();
    }

    public void insinvitations(String[] temp){
        SQLiteDatabase db=getWritableDatabase();
        //db.execSQL("delete from invitations where id>5");
    /*
        db.execSQL("create table if not exists invitations (id integer primary key autoincrement, event text,eventdate text,venue text,host text,details text)");

        for(int i=0;i<5;i++) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id",i+1);
            contentValues.put("event", arr[i][0]);
            contentValues.put("eventdate", arr[i][1]);
            contentValues.put("venue", arr[i][2]);
            contentValues.put("host", arr[i][3]);
            contentValues.put("details", arr[i][4]);
            Log.d("-------------","------------------------------------------");
            Log.w("-------------","------------------------------------------");
            Log.i("-------------","------------------------------------------");
            db.insert("invitations", null, contentValues);
        }
*/

        ContentValues contentValues = new ContentValues();
        contentValues.put("event", temp[0]);
        contentValues.put("eventdate", temp[1]);
        contentValues.put("venue", temp[2]);
        contentValues.put("host", temp[3]);
        contentValues.put("details", temp[4]);
        db.insert("invitations", null, contentValues);


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
