package com.namazshikkha.islamapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;
    RecyclerView recyclerView;
    CostomAdapter costomAdapter;
    ArrayList<ModelClass> modelClassList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        recyclerView = findViewById(R.id.recyclerView);
        arrayList();
        recyclerView();


    }


    private void recyclerView() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        costomAdapter = new CostomAdapter(MainActivity.this, modelClassList);
        recyclerView.setAdapter(costomAdapter);
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void arrayList() {
        modelClassList = new ArrayList<>();
        modelClassList.add(new ModelClass(R.drawable.namajj, "নামাজের নিয়ত"));
        modelClassList.add(new ModelClass(R.drawable.five, "পাঁচ ওয়াক্ত নামাজের তাসবিহ  মোনাজাত"));
        modelClassList.add(new ModelClass(R.drawable.kalimaa, "কালেমা"));
        modelClassList.add(new ModelClass(R.drawable.e, "সূরা"));
        modelClassList.add(new ModelClass(R.drawable.hasur, "সূরা হাশর "));
        modelClassList.add(new ModelClass(R.drawable.romjan, "রোজা ও তারাবী নামাজ"));
        modelClassList.add(new ModelClass(R.drawable.aiatul, " আয়াতুল কুরসী "));
        modelClassList.add(new ModelClass(R.drawable.janaja, " জানাযা নামাযের নিয়ত, নিয়ম ও দোয়া"));
        modelClassList.add(new ModelClass(R.drawable.ic_launcher, "অযুর দোয়া এবং অযুর করার নিয়ম জেনে নিন"));
        modelClassList.add(new ModelClass(R.drawable.dowa, "প্রয়োজনীয় ৭০টি ছোট আমাল  "));
        modelClassList.add(new ModelClass(R.drawable.islam, "কিভাবে নামাজ আদায় করবেন"));
        modelClassList.add(new ModelClass(R.drawable.juma, "জুম্মার নামাজের নিয়ম ও নিয়ত"));
        modelClassList.add(new ModelClass(R.drawable.surayesin, "সূরা ইয়াসিন এর বাংলা উচ্চারণ ও অর্থ"));
        modelClassList.add(new ModelClass(R.drawable.surarohoman, "সূরা আর-রাহমান এর বাংলা উচ্চারণ ও অর্থ"));
        modelClassList.add(new ModelClass(R.drawable.doinodin, "দৈনন্দিন দোয়া"));
        modelClassList.add(new ModelClass(R.drawable.namajj, "ঈদের নামাজের সহজ নিয়ম জেনে নিন"));


    }
}