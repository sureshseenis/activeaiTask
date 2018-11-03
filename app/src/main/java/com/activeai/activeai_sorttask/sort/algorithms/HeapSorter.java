/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activeai.activeai_sorttask.sort.algorithms;

import com.activeai.activeai_sorttask.sort.SortObserver;
import com.activeai.activeai_sorttask.sort.Sorter;

import java.util.ArrayList;
/**
 *
 * @author InproDevSys3
 */
public class HeapSorter extends Sorter {

    ArrayList<Integer> data = new ArrayList<>();
    private SortObserver listener;

    public HeapSorter(SortObserver s) {
        this.listener = s;
    }

    @Override
    public void Sort(ArrayList<Integer> list) {
        System.out.println("Heap Sort Started "+list);
        int i = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.addAll(list);
        for (i = arr.size() / 2 - 1; i >= 0; i--) {
            heapify(arr, arr.size(), i);
        }
        for (i = arr.size() - 1; i >= 0; i--) {
            int temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);
            heapify(arr, i, 0);
        }
        if (this.listener != null) {
            this.listener.onArrayUpdate(arr);
        }
        System.out.println(arr);
        System.out.println("Heap Sort Ended");
    }

    void heapify(ArrayList<Integer> arr, int size, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arr.get(left) > arr.get(largest)) {
            largest = left;
        }

        if (right < size && arr.get(right) > arr.get(largest)) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, temp);
            heapify(arr, size, largest);
        }
    }

}
