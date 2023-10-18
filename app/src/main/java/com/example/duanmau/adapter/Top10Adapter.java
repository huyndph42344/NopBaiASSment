package com.example.duanmau.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmau.R;
import com.example.duanmau.dao.ThongKeDao;
import com.example.duanmau.model.Sach;

import java.util.ArrayList;

public class Top10Adapter extends RecyclerView.Adapter<Top10Adapter.ViewHoler>{
    private ArrayList<Sach> list;
    private Context context;

    ThongKeDao dao;

    public Top10Adapter(ArrayList<Sach> list, Context context) {
        this.list = list;
        this.context = context;
        dao = new ThongKeDao(context);
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view  = inflater.inflate(R.layout.item_top10,parent,false);
        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        holder.txtMaSach.setText(String.valueOf(list.get(position).getMaSach()));
        holder.txtTenSach.setText(list.get(position).getTenSach());
        holder.txtSoLuong.setText(String.valueOf(list.get(position).getSoLanMuon()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder{
        TextView txtMaSach, txtTenSach, txtSoLuong;
        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            txtMaSach = itemView.findViewById(R.id.Top_MS);
            txtTenSach = itemView.findViewById(R.id.Top_TS);
            txtSoLuong = itemView.findViewById(R.id.Top_SL);
        }
    }
}
