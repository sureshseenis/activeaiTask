package com.activeai.activeai_sorttask;

import android.app.usage.NetworkStats;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class SortVizActivity extends AppCompatActivity implements SortObserver{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(23);
        arrayList.add(34);
        Sorter sorter=new BucketSorter(arrayList);

    }

    @Override
    public void onArrayUpdate(ArrayList<Integer> integers) {

    }
}
