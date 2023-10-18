package com.example.duanmau.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmau.R;
import com.example.duanmau.dao.PhieuMuonDao;
import com.example.duanmau.model.PhieuMuon;

import java.util.ArrayList;


    public class PhieuMuonAdapter extends RecyclerView.Adapter<PhieuMuonAdapter.Viewholer>{
        private ArrayList<PhieuMuon> list;
        private Context context;

        PhieuMuonDao phieuMuonDao;


        public PhieuMuonAdapter(ArrayList<PhieuMuon> list, Context context) {
            this.list = list;
            this.context = context;
            phieuMuonDao = new PhieuMuonDao(context);
        }

        @NonNull
        @Override
        public Viewholer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            View view = inflater.inflate(R.layout.item_phieumuon,parent,false);
            return new Viewholer(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Viewholer holder, int position) {
            holder.txtmapm.setText(String.valueOf(list.get(position).getMaPM()));
            holder.txttentv.setText(list.get(position).getHoTenTV());

            holder.txttens.setText(list.get(position).getTenSach());
            holder.txtgiat.setText(String.valueOf(list.get(position).getTienThue()));
            String trangthai = "";
            if(list.get(position).getTrangThai() == 1){
                trangthai = "Đã trả sách";
                holder.txttrangthai.setTextColor(ContextCompat.getColor(context, R.color.TrangThai));
            }else{
                trangthai = "Chưa trả sách";
            }
            holder.txttrangthai.setText(trangthai);
            holder.txtngaythue.setText(list.get(position).getNgayThue());



        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class Viewholer extends RecyclerView.ViewHolder{
            TextView txttentv,txttens,txtgiat,txtmapm,txttrangthai,txtngaythue;

            public Viewholer(@NonNull View itemView) {
                super(itemView);
                txtmapm = itemView.findViewById(R.id.txtmaPM);
                txttentv = itemView.findViewById(R.id.txttentv);
                txttens = itemView.findViewById(R.id.txttensach);
                txtgiat = itemView.findViewById(R.id.txttienthue);
                txttrangthai = itemView.findViewById(R.id.txttrasach);
                txtngaythue = itemView.findViewById(R.id.txtngaythue);

            }
        }
}
