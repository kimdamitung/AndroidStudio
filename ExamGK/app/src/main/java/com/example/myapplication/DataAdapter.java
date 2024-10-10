package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Data> dataArrayList;

    public DataAdapter(Context context, ArrayList<Data> dataArrayList) {
        this.context = context;
        this.dataArrayList = dataArrayList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Data> getDataArrayList() {
        return dataArrayList;
    }

    public void setDataArrayList(ArrayList<Data> dataArrayList) {
        this.dataArrayList = dataArrayList;
    }

    @Override
    public int getCount() {
        return dataArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view =  layoutInflater.inflate(R.layout.viewcourse, viewGroup, false);
        }
        Data data = (Data) getItem(i);
        TextView name = view.findViewById(R.id.name);
        TextView nameHP = view.findViewById(R.id.nameHP);
        TextView hocphi = view.findViewById(R.id.hocphi);
        name.setText(data.getName());
        nameHP.setText(data.getNameHP());
        hocphi.setText(data.getHocphi());
        return view;
    }
}
