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
import com.example.duanmau.dao.SachDao;
import com.example.duanmau.model.Sach;

import java.util.ArrayList;

public class SachAdapter extends RecyclerView.Adapter<SachAdapter.ViewHoler> {
    private ArrayList<Sach> list;
    private Context context;

    SachDao dao;

    public SachAdapter(ArrayList<Sach> list, Context context) {
        this.list = list;
        this.context = context;
        dao = new SachDao(context);
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_sach,parent,false);
        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        holder.txtmas.setText(String.valueOf(list.get(position).getMaSach()));
        holder.txttens.setText((list.get(position).getTenSach()));
        holder.txtgiat.setText(String.valueOf(list.get(position).getGiaThue()));
        holder.txtloais.setText(String.valueOf(list.get(position).getMaLoai()));
        holder.txttenloai.setText((list.get(position).getTenLoai()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class ViewHoler extends RecyclerView.ViewHolder{

        TextView txtmas,txttens,txtgiat,txtloais,txttenloai;


        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            txtmas = itemView.findViewById(R.id.txtmasach1);
            txttens = itemView.findViewById(R.id.txttensach1);
            txtgiat = itemView.findViewById(R.id.txtgiathue1);
            txtloais = itemView.findViewById(R.id.txtloaisach1);
            txttenloai = itemView.findViewById(R.id.txttenloaisach1);


        }
    }
}
