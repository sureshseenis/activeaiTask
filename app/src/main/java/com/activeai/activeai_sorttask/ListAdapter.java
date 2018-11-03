package com.activeai.activeai_sorttask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    Context context;
    ArrayList<Integer> nos=new ArrayList<>();
    LayoutInflater inflter;

    public ListAdapter(Context applicationContext, ArrayList<Integer> list) {
        this.context = applicationContext;
        this.nos = list;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return nos.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return nos.get(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_list, null);
        TextView no=(TextView)view.findViewById(R.id.no);
        no.setText(""+nos.get(i).intValue());

        return view;
    }
}