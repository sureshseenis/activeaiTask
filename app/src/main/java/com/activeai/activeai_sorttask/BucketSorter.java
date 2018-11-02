package com.activeai.activeai_sorttask;

import java.util.ArrayList;

public class BucketSorter implements Sorter{

    ArrayList<Integer> arrayList;
    SortObserver sortObserver;

    public BucketSorter(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
         HeapSort(arrayList);
    }


    @Override
    public void HeapSort(ArrayList<Integer> array) {
       System.out.print("HeapSort"+array.size());

        ArrayList<Integer> b=new ArrayList<>(array.size());

        for (int i=0; i<array.size(); i++)
        {
            int bi = array.size()*array.get(i); // Index in bucket
            b.get(bi).push_back(arr[i]);
        }

        // 3) Sort individual buckets
        for (int i=0; i<n; i++)
            sort(b[i].begin(), b[i].end());

        // 4) Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < b[i].size(); j++)
                arr[index++] = b[i][j];
        sortObserver.onArrayUpdate(arrayList);
    }

    @Override
    public void BubbleSort(ArrayList<Integer> arrayList) {
        System.out.print("BubbleSort");
    }
}
