/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activeai.activeai_sorttask.sort.algorithms;

import com.activeai.activeai_sorttask.sort.SortObserver;
import com.activeai.activeai_sorttask.sort.Sorter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Vector;


/**
 *
 * @author InproDevSys3
 */
public class BucketSorter extends Sorter {
    
    private SortObserver sortListener;
    
    public BucketSorter(SortObserver s){
        sortListener = s;
    }

    @Override
    public void Sort(ArrayList<Integer> list) {

        int[] sequence = new int[list.size()];
        int indx = 0;
        for(Integer i: list){
            sequence[indx] = i;
            indx++;
        }

        sortListener.onArrayUpdate(BucketSort(sequence,maxValue(sequence)));


    }

    int maxValue(int[] sequence)
    {
        int maxValue = 0;
        for (int i = 0; i < sequence.length; i++)
            if (sequence[i] > maxValue)
                maxValue = sequence[i];
        return maxValue;
    }

    private ArrayList<Integer> BucketSort(int[] sequence, int maxValue)
    {
        // Bucket Sort
        int[] Bucket = new int[maxValue + 1];
        int[] sorted_sequence = new int[sequence.length];

        for (int i = 0; i < sequence.length; i++)
            Bucket[sequence[i]]++;

        int outPos = 0;
        for (int i = 0; i < Bucket.length; i++)
            for (int j = 0; j < Bucket[i]; j++)
                sorted_sequence[outPos++] = i;

        ArrayList<Integer> sortedList = new ArrayList<>();
        for(int i = 0; i< sorted_sequence.length; i++){
            sortedList.add(sorted_sequence[i]);
        }
        return sortedList;
    }


}
