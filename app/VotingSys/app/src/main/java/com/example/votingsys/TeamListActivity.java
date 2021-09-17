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

public class TeamListActivity extends AppCompatActivity {

    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> names2 = new ArrayList<>();
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
        setContentView( R.layout.teamlist_layout);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//        int distric_id  = sharedPref.getInt("distric_id", Integer.parseInt(String.valueOf( "" )));
//        System.err.println("sssssssssssssssssssssssssssss"+distric_id);
//        connection_jason();
        team_list_load();
    }


    public void team_list_load(){
        String url = "http://192.168.8.101:9090/voteapp/vote/api/v1/politicionshaselection/team"; //spring boot link

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
                                id = obj.getString("team_id");
                                String team_name = obj.getString("team_name").toString();

                                names.add( id );
                                names2.add( team_name );

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

                String distric_id  = sharedPref.getString("distric_id", (String.valueOf( "" )));

                parms.put("distric_id", String.valueOf(distric_id));
                return parms;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(TeamListActivity.this);
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

//            System.out.println(names2.get(i));

//            hm.put("flag", Integer.toString(green[0]));
            aList.add(hm);
        }

        String[] from = {"team_name", "team_id"};
        int[] to = {R.id.team_name, R.id.team_id};
        final SimpleAdapter adapter1 = new SimpleAdapter(getBaseContext(), aList, R.layout.list_layout_teams, from, to);
        listView3= (ListView) findViewById(R.id.listview_dept);
        listView3.setAdapter(adapter1);


        listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView team_id=view.findViewById(R.id.team_id);
                TextView team_name=view.findViewById(R.id.team_name);


               // Toast.makeText(getApplicationContext(), "clickkkkkk", Toast.LENGTH_SHORT).show();
                JSONObject j=new JSONObject();
                JSONArray jr=new JSONArray();

                try {

                    j.put("team_id",team_id.getText());
                    j.put("team_name",team_name.getText());
//                        j.put("Dept_count",adapter1.getCount());
                    jr.put(j);
                    Intent intent = new Intent(getApplicationContext(), Vote_listActivity.class);
                    intent.putExtra("Dept_details", jr.toString());
                    startActivity(intent);


                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

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
                myIntent = new Intent( TeamListActivity.this, SplashActivity.class );
                TeamListActivity.this.startActivity( myIntent );
                SharedPreferences.Editor editor1 = sharedPref.edit();
                editor1.clear();
                editor1.commit();
                break;

            case R.id.action_dashboard:
                myIntent = new Intent( TeamListActivity.this, MainActivity.class );
                TeamListActivity.this.startActivity( myIntent );
                break;

        }
        return true;
    }




    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(TeamListActivity.this, MainActivity.class);
        TeamListActivity.this.startActivity(myIntent);
//        finish();
        super.onBackPressed();
    }


}
