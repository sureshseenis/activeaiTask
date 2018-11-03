package com.activeai.activeai_sorttask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.activeai.activeai_sorttask.sort.SortObserver;
import com.activeai.activeai_sorttask.sort.Sorter;
import com.activeai.activeai_sorttask.sort.algorithms.BucketSorter;
import com.activeai.activeai_sorttask.sort.algorithms.HeapSorter;

import java.util.ArrayList;

public class SortVizActivity extends AppCompatActivity implements SortObserver {

    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> orglist = new ArrayList<>();
    Sorter heap, bucket;

    ListView listView;
    Button gererateButton, HeapSortButton, BucketSortButton, ResetButton;
    EditText getRadomNumber;

    ListAdapter listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getRadomNumber = (EditText) findViewById(R.id.randomNumber);
        gererateButton = (Button) findViewById(R.id.generateButton);
        HeapSortButton = (Button) findViewById(R.id.heapSort);
        BucketSortButton = (Button) findViewById(R.id.bucketSort);
        ResetButton = (Button) findViewById(R.id.reset);
        listView = (ListView) findViewById(R.id.list_item);


        listAdapter = new ListAdapter(this, list);
        listView.setAdapter(listAdapter);
        GenerateRandoms();

        gererateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GenerateRandoms();
            }
        });

        ResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.clear(); list.addAll(orglist);
                listAdapter.notifyDataSetChanged();
            }
        });

        HeapSortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                heap.Sort(list);
            }
        });

        BucketSortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bucket.Sort(list);
            }
        });

        heap = new HeapSorter(this);
        bucket = new BucketSorter(this);
    }

    @Override
    public void onArrayUpdate(ArrayList<Integer> out) {
        list.clear();
        list.addAll(out);
        listAdapter.notifyDataSetChanged();
    }

    public void GenerateRandoms(){
        list.clear();
        list.addAll(generateRandomNumber(Integer.parseInt(getRadomNumber.getText().toString())));
        orglist.clear(); orglist.addAll(list);
        listAdapter.notifyDataSetChanged();
    }

    private ArrayList<Integer> generateRandomNumber(int limit) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < limit; i++)
            arrayList.add((int) (Math.random() * ((limit - 1) + 1)) + 1);
        return arrayList;
    }
}
