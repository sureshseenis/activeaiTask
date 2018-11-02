package com.activeai.activeai_sorttask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class SortVizActivity extends AppCompatActivity implements SortObserver{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(3454);
        arrayList.add(34343);
        arrayList.add(2123);
        arrayList.add(2223);
        arrayList.add(2123);
        new BucketSorter(arrayList);

    }

    @Override
    public void onArrayUpdate(ArrayList<ArrayList<Integer>> integers) {
        for(int i=0;i<integers.size();i++){
            ArrayList<Integer> list=integers.get(i);
            for(int j=0;j<list.size();j++){
                System.out.println(""+list.get(j));
            }

        }

    }
}
