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
import com.example.duanmau.adapter.PhieuMuonAdapter;
import com.example.duanmau.dao.PhieuMuonDao;
import com.example.duanmau.model.PhieuMuon;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class PhieuMuonFrg extends Fragment {

    PhieuMuonAdapter adapter;
    PhieuMuonDao dao;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  =inflater.inflate(R.layout.phieumuonfrg,container,false);
        RecyclerView rcv = view.findViewById(R.id.rcvpm);
        FloatingActionButton floatingActionButton = view.findViewById(R.id.fltaddphieumuon);
        dao =  new PhieuMuonDao(getContext());
        ArrayList<PhieuMuon> list = dao.getDSPhieuMuon();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcv.setLayoutManager(layoutManager);
        adapter = new PhieuMuonAdapter(list,getContext());
        rcv.setAdapter(adapter);
        return view;
    }
}