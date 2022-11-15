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
import com.namazshikkha.islamapps.AllSura.AlIikhlasSuraActivity;
import com.namazshikkha.islamapps.AllSura.AlaPhalakaActivity;
import com.namazshikkha.islamapps.AllSura.FatehaSuraActivity;
import com.namazshikkha.islamapps.AllSura.KafirunSuraActivity;
import com.namazshikkha.islamapps.AllSura.KauserSuraActivity;
import com.namazshikkha.islamapps.AllSura.LahabSuraActivity;
import com.namazshikkha.islamapps.AllSura.MaunaSuraActivity;
import com.namazshikkha.islamapps.AllSura.NasSuraActivity;
import com.namazshikkha.islamapps.AllSura.NassarSuraActivity;
import com.namazshikkha.islamapps.AllSura.PhilSuraActivity;
import com.namazshikkha.islamapps.AllSura.SuraQuraishActivity;

import java.util.ArrayList;

public class SuraActivity extends AppCompatActivity {

    ListCostomAdapter listCostomAdapter;
    ArrayList<ListModel> arrayList;
    ListView listView;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sura);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        listView = findViewById(R.id.list_sura);
        AdapterArrayList();
        setOnItemClickListener();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setOnItemClickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    startActivity(new Intent(SuraActivity.this, FatehaSuraActivity.class));
                } else if (position == 1) {
                    startActivity(new Intent(SuraActivity.this, PhilSuraActivity.class));
                } else if (position == 2) {
                    startActivity(new Intent(SuraActivity.this, SuraQuraishActivity.class));
                } else if (position == 3) {
                    startActivity(new Intent(SuraActivity.this, MaunaSuraActivity.class));
                } else if (position == 4) {
                    startActivity(new Intent(SuraActivity.this, KauserSuraActivity.class));
                } else if (position == 5) {
                    startActivity(new Intent(SuraActivity.this, KafirunSuraActivity.class));
                } else if (position == 6) {
                    startActivity(new Intent(SuraActivity.this, NassarSuraActivity.class));
                } else if (position == 7) {
                    startActivity(new Intent(SuraActivity.this, LahabSuraActivity.class));
                } else if (position == 8) {
                    startActivity(new Intent(SuraActivity.this, AlIikhlasSuraActivity.class));
                } else if (position == 9) {
                    startActivity(new Intent(SuraActivity.this, AlaPhalakaActivity.class));
                } else if (position == 10) {
                    startActivity(new Intent(SuraActivity.this, NasSuraActivity.class));
                }
            }
        });

    }

    private void AdapterArrayList() {
        arrayList = new ArrayList<>();
        arrayList.add(new ListModel("সূরা আল-ফাতিহা"));
        arrayList.add(new ListModel("সূরা ফীল"));
        arrayList.add(new ListModel("সূরা কুরাইশ"));
        arrayList.add(new ListModel("সূরা মাউন"));
        arrayList.add(new ListModel("সূরা কাওসার"));
        arrayList.add(new ListModel("সূরা কাফিরুন"));
        arrayList.add(new ListModel("সূরা নাসর"));
        arrayList.add(new ListModel("সূরা লাহাব"));
        arrayList.add(new ListModel("সূরা আল-ইখলাস"));
        arrayList.add(new ListModel("সূরা আল-ফালাক"));
        arrayList.add(new ListModel("সূরা আন-নাস"));

        listCostomAdapter = new ListCostomAdapter(SuraActivity.this, arrayList);
        listView.setAdapter(listCostomAdapter);
    }
}