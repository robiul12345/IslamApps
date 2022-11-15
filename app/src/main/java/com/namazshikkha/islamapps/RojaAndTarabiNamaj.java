package com.namazshikkha.islamapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.namazshikkha.islamapps.rojatarabi.IpterDwoa;
import com.namazshikkha.islamapps.rojatarabi.RojaNieat;
import com.namazshikkha.islamapps.rojatarabi.RojaarFojilot;
import com.namazshikkha.islamapps.rojatarabi.SahariDwoa;
import com.namazshikkha.islamapps.rojatarabi.TarabiNamaj;

import java.util.ArrayList;

public class RojaAndTarabiNamaj extends AppCompatActivity {
    ListView listView;
    ArrayList<ListModel> list;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roja_and_tarabi_namaj);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        listView = findViewById(R.id.listId);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        CostomArray();
        OnClickListener();

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()== android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
    private void OnClickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position==0){
                    startActivity(new Intent(RojaAndTarabiNamaj.this, RojaarFojilot.class));
                }
                else if (position==1){
                    startActivity(new Intent(RojaAndTarabiNamaj.this, RojaNieat.class));
                }
                else if (position==2){
                    startActivity(new Intent(RojaAndTarabiNamaj.this, IpterDwoa.class));
                }
                else if (position==3){
                    startActivity(new Intent(RojaAndTarabiNamaj.this, SahariDwoa.class));
                }
                else if (position==4){
                    startActivity(new Intent(RojaAndTarabiNamaj.this, TarabiNamaj.class));
                }

            }
        });

    }
    private void CostomArray() {
        list = new ArrayList<>();
        list.add(new ListModel("রোজার প্রকারভেদ"));
        list.add(new ListModel("রোজার নিয়ত"));
        list.add(new ListModel(" ইফতারের দোয়া"));
        list.add(new ListModel("রোজা ভঙের ও মাকরুহ কারণ"));
        list.add(new ListModel("তারাবী নামাজ"));

        ListCostomAdapter listAdapter = new ListCostomAdapter(this, list);
        listView.setAdapter(listAdapter);
    }

}