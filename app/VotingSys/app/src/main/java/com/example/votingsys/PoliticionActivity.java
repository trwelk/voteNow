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
import android.widget.TextView;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PoliticionActivity extends AppCompatActivity {

    EditText username, password, token2;
    String usernametxt,username_shred,password_shred;
    String passwordtxt;
    String TAG = "MyApp";
    String logs, token,mobile;
    SharedPreferences sharedPref;
    String URL = "http://192.168.8.101:9090/voteapp/vote/api/v1/authentication/mobile";
    TextView login_polition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FirebaseApp.initializeApp(this);


        sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        login_polition=findViewById(R.id.login_page);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        username_shred  = sharedPref.getString("username",  String.valueOf( "" ));
        password_shred = sharedPref.getString("password", String.valueOf( "" ));

        if(username_shred.equalsIgnoreCase( "" )){
            // Toast.makeText(getApplicationContext(), "Callingggggg function", Toast.LENGTH_SHORT).show();
            login_user();
        }else {
            String citizen_id  = sharedPref.getString("citizen_id", String.valueOf(""));
            check_user_accout_status(citizen_id);

        }

        login_polition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(PoliticionActivity.this, LoginActivity.class);
                PoliticionActivity.this.startActivity(myIntent);
                finish();
            }
        });

    }


    // Post Request For JSONObject
    public void login_user() {

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JSONObject object = new JSONObject();
        try {
            //input your API parameters
            object.put("username",username.getText().toString());
            object.put("password",password.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // Enter the correct url for your api service site

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, object,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject obj) {
                        try {
                            if(obj.equals("{}")){
                                Toast.makeText(getApplicationContext(), "You are not authorized person for Mobile app", Toast.LENGTH_SHORT).show();
                            }else{

                                System.out.println(obj.toString());
                                String distric_name = obj.getString("distric_name");
                                String password = obj.getString("password");
                                int citizen_id = obj.getInt("citizen_id");
                                int role = obj.getInt("role");
                                String reffno = obj.getString("reffno");
                                String citizen_code = obj.getString("citizen_code");
                                int id = obj.getInt("id");
                                int distric_id = obj.getInt("distric_id");
                                int status_server = obj.getInt("status");
                                String username = obj.getString("username");
                                int person_id = obj.getInt("person_id");
                                int c_status = obj.getInt("c_status");
                                if(status_server == 1 && c_status ==1){
                                    SharedPreferences.Editor editor = sharedPref.edit();

                                    editor.putString("distric_name",distric_name);
                                    editor.putString("password",password);
                                    editor.putString("citizen_id", String.valueOf(citizen_id));
                                    editor.putString("role", String.valueOf(role));
                                    editor.putString("reffno",reffno);
                                    editor.putString("citizen_code",citizen_code);
                                    editor.putString("id", String.valueOf(id));
                                    editor.putString("distric_id", String.valueOf(distric_id));
                                    editor.putString("status_server", String.valueOf(status_server));
                                    editor.putString("username",username);
                                    editor.putString("person_id", String.valueOf(person_id));
//
                                    editor.commit();
                                    Toast.makeText(getApplicationContext(), "Success Login Dear."+username, Toast.LENGTH_SHORT).show();
                                    Intent myIntent = new Intent(PoliticionActivity.this, OtpActivity.class);
                                    PoliticionActivity.this.startActivity(myIntent);
                                    finish();
                                }else if(status_server == 1 && c_status ==2){
                                    Intent myIntent = new Intent(PoliticionActivity.this, LoginActivity.class);
                                    PoliticionActivity.this.startActivity(myIntent);
                                    finish();
                                    Toast.makeText(getApplicationContext(), "Login Sucess but Voting Not Yet Started...", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Intent myIntent = new Intent(PoliticionActivity.this, PoliticionActivity.class);
                                    PoliticionActivity.this.startActivity(myIntent);
                                    finish();
                                    Toast.makeText(getApplicationContext(), "You are not authorized person..", Toast.LENGTH_SHORT).show();
                                }
                            }

//
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Response=----->> "+error);
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    public void login(View view) {

        boolean connected = false;

        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService( Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;


            usernametxt = username.getText().toString();
            passwordtxt = password.getText().toString();

            if (usernametxt.equalsIgnoreCase("") || passwordtxt.equalsIgnoreCase("")) {

                Toast.makeText(getApplicationContext(), "Username password empty", Toast.LENGTH_SHORT).show();

            } else {

                login_user();
            }

        }
        else{
            connected = false;
            Toast.makeText(getApplicationContext(), "No Internrt Connection check it Now", Toast.LENGTH_SHORT).show();

        }


    }


    public void check_user_accout_status(String citizen_id){
        String url = "http://192.168.8.101:9090/voteapp/vote_time_check"; //spring boot link

        StringRequest stringRequest=new StringRequest( Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "response_data" + response);

                try {
                    if (response != null) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            String status= jsonObject.getString("status");
                            String message= jsonObject.getString("message");
                            if(status.equals("1")){
                                Toast.makeText(getApplicationContext(),"Welcome To Voting app Dear "+ username_shred, Toast.LENGTH_SHORT).show();
                                Intent myIntent = new Intent(PoliticionActivity.this, OtpActivity.class);
                                PoliticionActivity.this.startActivity(myIntent);
                                finish();
                            }else if(status.equals("2")){
                                Toast.makeText(getApplicationContext(),"Voting Time is Deactivated.... by Government "+ username_shred, Toast.LENGTH_SHORT).show();
                            }
                            Toast.makeText( getApplicationContext(), message, Toast.LENGTH_SHORT ).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    } else {
                        Toast.makeText( getApplicationContext(), "Error", Toast.LENGTH_SHORT ).show();
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
                    error.wait(1000,1);
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

                String distric_id  = sharedPref.getString("distric_id", (String.valueOf( "" )));

                parms.put("c_id", String.valueOf(distric_id));
                return parms;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(PoliticionActivity.this);
        requestQueue.add(stringRequest);
    }

}
