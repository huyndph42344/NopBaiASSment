package com.example.duanmau.fragment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.duanmau.R;
import com.example.duanmau.adapter.TheLoaiAdapter;
import com.example.duanmau.dao.TheLoaiDao;
import com.example.duanmau.model.TheLoai;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class TheLoaiFrg extends Fragment {
    RecyclerView rcvtheloai;
    FloatingActionButton fltadds;

    TheLoaiDao theLoaiDao;
    TheLoaiAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  =inflater.inflate(R.layout.theloai_frg,container,false);
        rcvtheloai = view.findViewById(R.id.rcvtheloai);
        FloatingActionButton fltadd = view.findViewById(R.id.fltaddtl);
        fltadds = view.findViewById(R.id.fltaddtl);
        theLoaiDao = new TheLoaiDao(getContext());
        ArrayList<TheLoai> list = theLoaiDao.getalltheloai();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcvtheloai.setLayoutManager(layoutManager);
        adapter = new TheLoaiAdapter(list, getContext());
        rcvtheloai.setAdapter(adapter);
        fltadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTL();
            }
        });
        return view;
    }
    public void addTL(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.add_loaisach,null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();

        TextInputLayout in_TenLS = view.findViewById(R.id.in_addTenLS);
        TextInputEditText ed_TenLS = view.findViewById(R.id.ed_addTenLS);
        Button AddLS = view.findViewById(R.id.LS_add);
        Button CancelLS = view.findViewById(R.id.LS_Cancel);

        ed_TenLS.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() == 0){
                    in_TenLS.setError("Vui lòng nhập tên loại sách");
                }else{
                    in_TenLS.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        AddLS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenloai = ed_TenLS.getText().toString();
                if(tenloai.isEmpty()){
                    if(tenloai.equals("")){
                        in_TenLS.setError("Vui lòng nhập tên loại sách");
                    }else{
                        in_TenLS.setError(null);
                    }
                }else{
                    if(theLoaiDao.insert(tenloai)){
                        loadData();
                        Toast.makeText(getContext(), "Thêm loại sách thành công", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }else{
                        Toast.makeText(getContext(), "Thêm loại sách không thành công", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        CancelLS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed_TenLS.setText("");
            }
        });

    }
    private void loadData(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcvtheloai.setLayoutManager(layoutManager);
        ArrayList<TheLoai> list = theLoaiDao.getalltheloai();
        adapter = new TheLoaiAdapter(list, getContext());
        rcvtheloai.setAdapter(adapter);
    }
}
