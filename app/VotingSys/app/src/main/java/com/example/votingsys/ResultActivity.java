package com.example.votingsys;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
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
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultActivity extends AppCompatActivity {

    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> names2 = new ArrayList<>();
    ArrayList<String> names3 = new ArrayList<>();
    Map<String, Integer> mapIndex;
    ListView fruitList;
    String TAG = "test";
    JSONArray jsonArray;
    JSONObject obj;
    SharedPreferences sharedPref;
    ListView listView3;
    String id,team_name;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.result_activity);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//        int distric_id  = sharedPref.getInt("distric_id", Integer.parseInt(String.valueOf( "" )));
//        System.err.println("sssssssssssssssssssssssssssss"+distric_id);
//        connection_jason();
        team_list_load();
    }


    public void team_list_load(){
        String url = "http://192.168.8.101:9090/voteapp/vote/api/v1/vote/my_vote"; //spring boot link

        StringRequest stringRequest=new StringRequest( Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "response_data" + response);
//                System.out.println(response);
//                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                try {

                    jsonArray = new JSONArray(response);

                    if (jsonArray.length() > 0) {
                        for (int a = 0; a < jsonArray.length(); a++) {
                            try {

                                obj = jsonArray.getJSONObject(a);
                                id = obj.getString("id");
                                String person_name = obj.getString("person_fname").toString();
                                String poli_number = obj.getString("poli_number").toString();
                                //Toast.makeText(getApplicationContext(), person_name, Toast.LENGTH_SHORT).show();
                                names.add( poli_number );
                                names2.add( person_name );
                                //names3.add( poli_number );
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                    }else {
                        //api not working
                        Toast.makeText(getApplicationContext(), "errormsg", Toast.LENGTH_SHORT).show();
                        //System.out.println("sssssssssssssss");
                    }


                }catch (Exception e){
                    e.printStackTrace();
                }

                listVew_data();
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
                return parms;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(ResultActivity.this);
        requestQueue.add(stringRequest);
    }

    public void listVew_data() {
        Log.d( "ArraySize", String.valueOf( names.size() ) );

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
//        int[] green = new int[]{R.drawable.common_google_signin_btn_icon_dark};
        for (int i = 0; i < names.size(); i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("team_id", "" + names.get(i));
            hm.put("team_name", "" + names2.get(i));
            //hm.put("team_number", "" + names3.get(i));
//            System.out.println(names2.get(i));

//            hm.put("flag", Integer.toString(green[0]));
            aList.add(hm);
        }

        String[] from = {"team_name", "team_id"};
        int[] to = {R.id.team_name, R.id.team_id};
        final SimpleAdapter adapter1 = new SimpleAdapter(getBaseContext(), aList, R.layout.list_layout_result, from, to);
        listView3= (ListView) findViewById(R.id.listview_dept);
        listView3.setAdapter(adapter1);


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
                myIntent = new Intent( ResultActivity.this, SplashActivity.class );
                ResultActivity.this.startActivity( myIntent );
                SharedPreferences.Editor editor1 = sharedPref.edit();
                editor1.clear();
                editor1.commit();
                break;

            case R.id.action_dashboard:
                myIntent = new Intent( ResultActivity.this, MainActivity.class );
                ResultActivity.this.startActivity( myIntent );
                break;

        }
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(ResultActivity.this, MainActivity.class);
        ResultActivity.this.startActivity(myIntent);
//        finish();
        super.onBackPressed();
    }

}
