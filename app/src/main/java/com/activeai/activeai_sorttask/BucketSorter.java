package com.activeai.activeai_sorttask;

import java.io.IOException;
import java.util.ArrayList;

public class BucketSorter implements Sorter{

    ArrayList<Integer> arrayList;
    SortObserver sortObserver;

    public BucketSorter(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
         BubbleSort(arrayList);
    }


    @Override
    public void HeapSort(ArrayList<Integer> array) {
       System.out.print("HeapSort"+array.size());
    }


    @Override
    public void BubbleSort(ArrayList<Integer> array) {
        System.out.print("BubbleSort");

        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        for(int i = 0; i < array.size(); i++)
        {
            buckets.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < array.size(); i++)
        {
            int check = array.size();
            int arrayToPlace = 0;
            boolean greater = true;
            while(greater)
            {
                if(array.get(i) > check)
                {
                    check = check * array.size();
                    arrayToPlace++;
                }
                else
                {
                    try {
                        buckets.get(arrayToPlace).add(array.get(i));
                        greater = false;
                    }catch (ArrayIndexOutOfBoundsException e){
                       e.printStackTrace();
                    }
                }
                //sortObserver.onArrayUpdate(buckets);
            }

        }
    }

}