package com.example.duanmau.fragment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duanmau.R;
import com.example.duanmau.adapter.SachAdapter;
import com.example.duanmau.dao.SachDao;
import com.example.duanmau.model.Sach;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class SachFrg extends Fragment {
    RecyclerView rcv;
    FloatingActionButton fltaddsach;
    SachDao dao;
    SachAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  =inflater.inflate(R.layout.sach_frg,container,false);
        rcv = view.findViewById(R.id.rcvsach);
        fltaddsach  =view.findViewById(R.id.fltaddsach);
        dao = new SachDao(getContext());
        ArrayList<Sach> list = dao.getSachAll();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcv.setLayoutManager(layoutManager);
        adapter = new SachAdapter(list,getContext());
        rcv.setAdapter(adapter);
        fltaddsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSach();
            }
        });
        return view;
    }
    public void addSach(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.add_sach,null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();

    }
}