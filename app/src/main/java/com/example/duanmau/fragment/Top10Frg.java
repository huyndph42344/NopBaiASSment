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
import com.example.duanmau.adapter.Top10Adapter;
import com.example.duanmau.dao.ThongKeDao;
import com.example.duanmau.model.Sach;

import java.util.ArrayList;

public class Top10Frg extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  =inflater.inflate(R.layout.top10_frg,container,false);
        RecyclerView rcv = view.findViewById(R.id.rcvtop10);
        ThongKeDao thongKeDao = new ThongKeDao(getContext());
        ArrayList<Sach> list = thongKeDao.getTop10();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcv.setLayoutManager(layoutManager);
        Top10Adapter adapter = new Top10Adapter(list,getContext());
        rcv.setAdapter(adapter);
        return view;
    }
}