package com.example.votingsys;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.example.votingsys.utill.DateandTimeClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vote_listActivity extends AppCompatActivity {
    ArrayList<String> names1 = new ArrayList<>();
    ArrayList<String> names2 = new ArrayList<>();
    ArrayList<String> names3 = new ArrayList<>();
    ArrayList<String> names4 = new ArrayList<>();
    ArrayList<String> names5 = new ArrayList<>();

    Map<String, Integer> mapIndex;
    ListView fruitList;
    String TAG = "test";
    JSONArray jsonArray;
    JSONObject obj;
    SharedPreferences sharedPref;
    ListView listView_employee;
    String id,employee_id_shred;
    ListView list_emp_att1;

    Dialog myDialog;
    ArrayList<String> namesx = new ArrayList<>();
    ArrayList<String> names2x = new ArrayList<>();
    ArrayList<String> names3x = new ArrayList<>();
    ArrayList<String> names4x = new ArrayList<>();
    ArrayList<String> names5x = new ArrayList<>();
    ArrayList<String> names6x = new ArrayList<>();
    ArrayList<String> names7x = new ArrayList<>();

    private EditText emp_name_tct;
    private EditText location_txt,datetime_txt;
    private Button in,out,btnCemara;
    private ImageView ImageView_cemara;
    private LocationManager locationManager;
    Bitmap bitmap;
    TelephonyManager telephonyManager;
    boolean GpsStatus ;
    Context context;
    String base64_encode_image,imeiNumber,enrollid,verifymode,iomode;
    TextView dept_count_txt,detp_name_titel_txt;
    Button vote_txt;
    String team_name;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_votel_list);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String Dept_details = getIntent().getStringExtra("Dept_details");
        try {
            JSONArray jsonArray=new JSONArray(Dept_details);
            team_name=jsonArray.getJSONObject(0).getString("team_name");
            String team_id=jsonArray.getJSONObject(0).getString("team_id");
            dept_count_txt=findViewById(R.id.detp_total);
            detp_name_titel_txt=findViewById(R.id.detp_name_titel);
            detp_name_titel_txt.setText(team_name);
            connection_jason(team_id);
            //listVew_data();
        }catch (Exception e){
            e.printStackTrace();
        }
//            vote_txt= findViewById(R.id.vote);
        try{
            TextView detp_name_titel=findViewById(R.id.detp_name_titel);
            listView_employee= (ListView) findViewById(R.id.listview_emp);

        }catch (Exception e){
            e.printStackTrace();
        }
        myDialog=new Dialog(this);
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
                myIntent = new Intent( Vote_listActivity.this, SplashActivity.class );
                Vote_listActivity.this.startActivity( myIntent );
                SharedPreferences.Editor editor1 = sharedPref.edit();
                editor1.clear();
                editor1.commit();
                break;



        }
        return true;
    }

    public void connection_jason(final String team_id){
        String url = "http://192.168.8.101:9090/voteapp/vote/api/v1/politcion/getpoliList";

        StringRequest stringRequest=new StringRequest( Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
//                Log.d(TAG, "response_data" + response);
                JSONArray jsonarray = null;
                try {
                    jsonarray = new JSONArray(response);
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonobject = jsonarray.getJSONObject(i);
                    int poli_has_elc_id = jsonobject.getInt("poli_has_elc_id");
                    int poli_id = jsonobject.getInt("poli_id");
                    int person_id = jsonobject.getInt("person_id");
                    String person_name = jsonobject.getString("person_name");
                    String person_mobile = jsonobject.getString("person_mobile");
                    String poli_number = jsonobject.getString("poli_number");
                    names1.add(String.valueOf(poli_has_elc_id));
                    names2.add( person_name );
                    names3.add( person_mobile );
                    names4.add(String.valueOf(poli_number));
                    names5.add(String.valueOf(poli_id));

                }
                    listVew_data();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error", error);
                String errormsg = error.getMessage();
                try {
//                    error.wait(1000,0);
//                    Toast.makeText(getApplicationContext(), errormsg, Toast.LENGTH_SHORT).show();
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


                parms.put("team_id",team_id);
                return parms;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Vote_listActivity.this);
        requestQueue.add(stringRequest);
    }

    public void listVew_data() {

//        Log.d( "ArraySize", String.valueOf( names1.size() ) );
        dept_count_txt.setText("Count : "+names5.size());
//        System.out.println(names.size());
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
//        int[] green = new int[]{R.drawable.common_google_signin_btn_icon_dark};
        for (int i = 0; i < names1.size(); i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("poli_has_elc_id", "" + names1.get(i));
            hm.put("person_name", "" + names2.get(i));
            hm.put("person_mobile", "" + names3.get(i));
            hm.put("poli_vote_number", "" + names4.get(i));
            hm.put("poli_id", "" + names5.get(i));

//            hm.put("flag", Integer.toString(green[0]));
            aList.add(hm);
        }

        String[] from = {"poli_has_elc_id", "person_name","person_mobile","poli_vote_number","poli_id"};
        int[] to = {R.id.poli_has_elc_id, R.id.person_name,R.id.person_mobile,R.id.poli_vote_number,R.id.poli_id};
        final SimpleAdapter adapter2 = new SimpleAdapter(getBaseContext(), aList, R.layout.list_layout_emp, from, to);
        listView_employee.setAdapter(adapter2);

        try {
            listView_employee.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    view.setClickable(false);
                    final TextView mobile=view.findViewById(R.id.person_mobile);
                    final TextView name_emp=view.findViewById(R.id.person_name);
                    final TextView poli_vote_number=view.findViewById(R.id.poli_vote_number);
                    final TextView poli_has_elc_id_txt=view.findViewById(R.id.poli_has_elc_id);

                    Button call = view.findViewById(R.id.call);
                    Button vote_txt=view.findViewById(R.id.vote);

                    vote_txt.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            TextView txtclose_update;
                            Button btnFollow,vote_yes,vote_no;
                            myDialog.setContentView(R.layout.update_layout);
                            txtclose_update=(TextView) myDialog.findViewById(R.id.txtclose_update);
                            emp_name_tct=myDialog.findViewById(R.id.name_txt_emp);
                            emp_name_tct.setText("Name:"+name_emp.getText().toString() +"Vote Number "+poli_vote_number.getText());
                            vote_yes=myDialog.findViewById(R.id.yes);
                            vote_no=myDialog.findViewById(R.id.no);
                            vote_yes.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    make_btn_vote(poli_has_elc_id_txt.getText().toString());
                                }
                            });

                            vote_no.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    myDialog.dismiss();
                                }
                            });

                            list_emp_att1 = myDialog.findViewById(R.id.listview_emp_att);
                            txtclose_update.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    myDialog.dismiss();
                                }
                            });

                            myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                            myDialog.show();


                        }
                    });
                    call.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(mobile.getText().toString() != ""){
                                listView_employee.setFocusable(false);
                                Intent intent = new Intent(Intent.ACTION_DIAL);
                                intent.setData(Uri.parse("tel:"+mobile.getText().toString()));
                                startActivity(intent);

                            }



                        }
                    });

                }
            });

        }catch (Exception e)
        {
            e.printStackTrace();
        }



    }

    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(Vote_listActivity.this, TeamListActivity.class);
        Vote_listActivity.this.startActivity(myIntent);
//        finish();
        super.onBackPressed();
    }
    private void make_btn_vote(final String id) {

        String URL = "http://192.168.8.101:9090/voteapp/vote/api/v1/vote/";


            StringRequest stringRequest = new StringRequest( Request.Method.POST, URL,

                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
//                            Toast.makeText( getApplicationContext(), response, Toast.LENGTH_SHORT ).show();
                            if (response != null) {
                                try {
                                    JSONObject jsonObject=new JSONObject(response);
                                   String id= jsonObject.getString("id");
                                   String status= jsonObject.getString("status");
                                   String message= jsonObject.getString("message");
                                   Toast.makeText( getApplicationContext(), message, Toast.LENGTH_SHORT ).show();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }


                            } else {
                                Toast.makeText( getApplicationContext(), "Error", Toast.LENGTH_SHORT ).show();
                            }

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            String errormsg = error.getMessage();
                            try {
//                                error.wait(5500,1);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
//                      Toast.makeText(info_track_LoginActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                            Toast.makeText(getApplicationContext(), errormsg, Toast.LENGTH_SHORT).show();
//                            Toast.makeText( Att_emp_list_all_activity.this, "Check Miss Fields", Toast.LENGTH_LONG ).show();
//                            System.out.println("ERRRRRRRRR"+errormsg);
                        }
                    } ) {

                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    String citizen_id = sharedPref.getString("citizen_id", String.valueOf(""));




                    params.put( "citizen_id", citizen_id );
                    params.put( "p_has_ele_id", id );



//                    Log.d(TAG, "allparametrs" + location_n + "  " + bill_img + "  " + datetime + "  " + total_balance + "  " +
//                            cash_collect + "  " +
//                            noted);
                    return params;
                }

            };
            RequestQueue requestQueue = Volley.newRequestQueue( this );
            requestQueue.add( stringRequest );


    }

}
