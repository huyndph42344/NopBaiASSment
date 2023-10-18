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
import com.example.duanmau.dao.ThanhVienDao;
import com.example.duanmau.model.ThanhVien;

import java.util.ArrayList;

public class ThanhVienAdapter extends RecyclerView.Adapter<ThanhVienAdapter.ViewHoler>{
    private ArrayList<ThanhVien> list;
    private Context context;
    ThanhVienDao thanhVienDao;
    public ThanhVienAdapter(ArrayList<ThanhVien> list,Context context){
        this.list = list;
        this.context = context;
        thanhVienDao = new ThanhVienDao(context);

    }
    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_thanhvien,parent,false);
        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        holder.txtmatv.setText(String.valueOf(list.get(position).getMaTV()));
        holder.txttetv.setText(list.get(position).getHoTen());
        holder.txtns.setText(list.get(position).getNamSinh());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder{
        TextView txtmatv,txttetv,txtns;

        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            txtmatv = itemView.findViewById(R.id.txtmatv1);
            txttetv = itemView.findViewById(R.id.hoten1);
            txtns = itemView.findViewById(R.id.txtnamsinh1);

        }
    }
}
