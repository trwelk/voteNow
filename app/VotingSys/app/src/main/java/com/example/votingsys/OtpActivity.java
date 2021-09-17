package com.example.votingsys;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.FirebaseApp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class OtpActivity extends AppCompatActivity {
    EditText otpcode;
    String otpcodetxt,username_shred,password_shred;
    String passwordtxt;
    String TAG = "info_track_MyApp";
    String logs, token,mobile;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otp_layout);
        FirebaseApp.initializeApp(this);

        sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        otpcode = (EditText) findViewById(R.id.otpcode);
    }

    public void check_otp_code(String otpcodetxt){
        String url = "http://192.168.8.101:9090/voteapp/vote/api/v1/authentication/validOtp"; //spring boot link

        StringRequest stringRequest=new StringRequest( Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "response_data" + response);
//                System.out.println(response);
//                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                if(jsonObject.getString("result").equals("1")){
                    Toast.makeText(getApplicationContext(), "Successfully Done ", Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(OtpActivity.this, MainActivity.class);
                    OtpActivity.this.startActivity(myIntent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Code is failed try again..", Toast.LENGTH_SHORT).show();
//                    Intent myIntent = new Intent(OtpActivity.this, OtpActivity.class);
//                    OtpActivity.this.startActivity(myIntent);
//                    finish();
                }


                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error", error);
                String errormsg = error.getMessage();
                try {
                    error.wait(5000,1);
                }catch (Exception e){
                    e.printStackTrace();
                }
//                      Toast.makeText(info_track_LoginActivity.this, error.toString(), Toast.LENGTH_LONG).show();
//                      Toast.makeText(getApplicationContext(), errormsg, Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parms = new HashMap<>();

                String citizen_id  = sharedPref.getString("citizen_id", (String.valueOf( "" )));

                parms.put("c_id", String.valueOf(citizen_id));
                parms.put("code", String.valueOf(otpcode.getText()));
                return parms;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(OtpActivity.this);
        requestQueue.add(stringRequest);
    }

    public void otpcode(View view) {

        boolean connected = false;

        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService( Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;


            otpcodetxt = otpcode.getText().toString();


            if (otpcodetxt.equalsIgnoreCase("")) {

                Toast.makeText(getApplicationContext(), "Otp code is empty", Toast.LENGTH_SHORT).show();

            } else {

                check_otp_code(otpcodetxt);
            }

        }
        else{
            connected = false;
            Toast.makeText(getApplicationContext(), "No Internrt Connection check it Now", Toast.LENGTH_SHORT).show();

        }


    }

}
