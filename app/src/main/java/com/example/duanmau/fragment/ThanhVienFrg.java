package com.example.duanmau.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duanmau.R;
import com.example.duanmau.adapter.ThanhVienAdapter;
import com.example.duanmau.dao.ThanhVienDao;
import com.example.duanmau.model.ThanhVien;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class ThanhVienFrg extends Fragment {

    RecyclerView rcvtv;
    FloatingActionButton fltaddtv;

    ThanhVienDao dao;

    ThanhVienAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  =inflater.inflate(R.layout.thanhvien_frg,container,false);
        rcvtv = view.findViewById(R.id.rcvthanhvien);
        fltaddtv = view.findViewById(R.id.fltaddtv);
        dao = new ThanhVienDao(getContext());
        ArrayList<ThanhVien> list = dao.getalltv();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcvtv.setLayoutManager(layoutManager);
        adapter = new ThanhVienAdapter(list,getContext());
        rcvtv.setAdapter(adapter);
        return view;
    }
}