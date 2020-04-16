package in.ankushrodewad.coronaindia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Matrix;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

import static java.net.Proxy.Type.HTTP;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ImageView loading;
    CardView content_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //textView = (TextView) findViewById(R.id.text);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        //change country name in the end of url to get updates for different country
        String url ="https://corona-stats.online/india";

        loading = (ImageView) findViewById(R.id.loading);
        content_card = (CardView) findViewById(R.id.content_card);
        loading.setVisibility(View.VISIBLE);
        content_card.setVisibility(View.INVISIBLE);
        Animation aniRotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        loading.startAnimation(aniRotate);


// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        String str_short = response.substring(1300,1720);
                        char car = response.charAt(0);
                        char[] new_str = new char[1000];
                        int j=0;
                        for(int i=0; i<str_short.length(); i++){
                            if(str_short.charAt(i)!='║'  && str_short.charAt(i)!='─' && str_short.charAt(i)!='═'
                                    && str_short.charAt(i)!='╚' && str_short.charAt(i)!='╟' && str_short.charAt(i)!='┼' &&
                                    str_short.charAt(i)!='╢' && str_short.charAt(i)!='╧'){
                                new_str[j++] = str_short.charAt(i);
                            }
                        }

                        CountryStatus india = parse_data(String.copyValueOf(new_str));
                        Log.d("OUTPUT",str_short);
                        loading.setVisibility(View.INVISIBLE);
                        content_card.setVisibility(View.VISIBLE);
                        ((TextView) findViewById(R.id.country_name)).setText(india.getCountry_name());
                        ((TextView) findViewById(R.id.tv_total_cases)).setText(india.getTotal_cases());
                        ((TextView) findViewById(R.id.tv_new_cases)).setText(india.getNew_cases());
                        ((TextView) findViewById(R.id.tv_total_deaths)).setText(india.getTotal_deaths());
                        ((TextView) findViewById(R.id.tv_new_deaths)).setText(india.getNew_deaths());
                        ((TextView) findViewById(R.id.tv_total_recovered)).setText(india.getRecovered());
                        ((TextView) findViewById(R.id.tv_active_cases)).setText(india.getActive());
                        ((TextView) findViewById(R.id.tv_critical)).setText(india.getCritical());
                        ((TextView) findViewById(R.id.tv_cases_per_million)).setText(india.getCases_per_million_pop());

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("That didn't work!");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }


    public CountryStatus parse_data(String raw_data){
        String[] idata_array = raw_data.split("│");
        String data_array[]=new String[100];
        int j=0;
        String str = "";
        for(int i=0; i<11; i++) {
                if(!idata_array[i].trim().equals(""))
                data_array[j++] = idata_array[i].trim();
                else
                    data_array[j++] = "-";
             //   str+= idata_array[i].trim() + "\n";
        }
        //textView.setText(str);
        return new CountryStatus(data_array[1],data_array[2], data_array[3], data_array[4],data_array[5], data_array[6], data_array[7],data_array[8], data_array[9]);
    }


}
