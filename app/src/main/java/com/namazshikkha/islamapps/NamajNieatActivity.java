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
import com.namazshikkha.islamapps.FiveNamajNieat.AsrNamajActivity;
import com.namazshikkha.islamapps.FiveNamajNieat.FajrNamajActivity;
import com.namazshikkha.islamapps.FiveNamajNieat.IsharNamajActivity;
import com.namazshikkha.islamapps.FiveNamajNieat.MaghribActivity;
import com.namazshikkha.islamapps.FiveNamajNieat.ZoharNamajActivity;

import java.util.ArrayList;

public class NamajNieatActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<ListModel> list;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_namaj_nieat2);
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
                    startActivity(new Intent(NamajNieatActivity.this, FajrNamajActivity.class));
                }
                else if (position==1){
                    startActivity(new Intent(NamajNieatActivity.this, ZoharNamajActivity.class));
                }
                else if (position==2){
                    startActivity(new Intent(NamajNieatActivity.this, AsrNamajActivity.class));
                }
                else if (position==3){
                    startActivity(new Intent(NamajNieatActivity.this, MaghribActivity.class));
                }
                else if (position==4){
                    startActivity(new Intent(NamajNieatActivity.this, IsharNamajActivity.class));
                }

            }
        });

    }

    private void CostomArray() {
        list = new ArrayList<>();
        list.add(new ListModel("ফজরের নামাজ"));
        list.add(new ListModel("জোহরের নামাজ"));
        list.add(new ListModel("আছরের নামাজ"));
        list.add(new ListModel("মাগরিবের নামাজ"));
        list.add(new ListModel("এশার  নামাজ"));

        ListCostomAdapter listAdapter = new ListCostomAdapter(this, list);
        listView.setAdapter(listAdapter);
    }
}