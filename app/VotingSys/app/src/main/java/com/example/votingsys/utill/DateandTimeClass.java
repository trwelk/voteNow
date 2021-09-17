package com.example.votingsys.utill;

import android.content.Context;
import android.graphics.Bitmap;
import android.telephony.TelephonyManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateandTimeClass {

    Bitmap bitmap;
    TelephonyManager telephonyManager;
    boolean GpsStatus ;
    Context context;
    public String get_datetime_current(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
//        System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
        return dateFormat.format(date);

    }
}
