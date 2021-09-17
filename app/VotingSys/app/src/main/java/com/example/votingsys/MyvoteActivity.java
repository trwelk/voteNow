package com.example.votingsys;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyvoteActivity extends AppCompatActivity {

    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> names2 = new ArrayList<>();
    ArrayList<String> names3 = new ArrayList<>();
    Map<String, Integer> mapIndex;
    ListView fruitList;
    String TAG = "test";
    JSONArray jsonArray;
    JSONObject obj;
    SharedPreferences sharedPref;
   TextView number_result;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.my_vote_poli_activity);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        number_result=findViewById(R.id.number_result);
        team_list_load();
    }

    public void team_list_load(){
        String url = "http://192.168.8.101:9090/voteapp/vote/api/v1/politicionshaselection/my_vote_poli"; //spring boot link

        StringRequest stringRequest=new StringRequest( Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
//                Log.d(TAG, "response_data" + response);
//                System.out.println(response);
                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                try {
                    JSONObject ss=new JSONObject(response);
                    number_result.setText("# "+ss.getString("count"));


                }catch (Exception e){
                    e.printStackTrace();
                }

//                listVew_data();
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

                String poli_id  = sharedPref.getString("poli_id", (String.valueOf( "" )));
                System.out.println(poli_id);
                parms.put("poli_id", String.valueOf(poli_id));
                return parms;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(MyvoteActivity.this);
        requestQueue.add(stringRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.menu_main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent;
        int id = item.getItemId();
        switch (id) {
            case R.id.action_logout:
//                SharedPreferences sharedPref;
                myIntent = new Intent( MyvoteActivity.this, SplashActivity.class );
                MyvoteActivity.this.startActivity( myIntent );
                SharedPreferences.Editor editor1 = sharedPref.edit();
                editor1.clear();
                editor1.commit();
                break;

//            case R.id.action_dashboard:
//                myIntent = new Intent( MyvoteActivity.this, MainActivity.class );
//                MyvoteActivity.this.startActivity( myIntent );
//                break;

        }
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(MyvoteActivity.this, MyvoteActivity.class);
        MyvoteActivity.this.startActivity(myIntent);
//        finish();
        super.onBackPressed();
    }
}
