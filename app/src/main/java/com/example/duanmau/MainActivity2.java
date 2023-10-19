package com.example.duanmau;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.duanmau.fragment.DoanhThuFrg;
import com.example.duanmau.fragment.Doimak;
import com.example.duanmau.fragment.PhieuMuonFrg;
import com.example.duanmau.fragment.SachFrg;
import com.example.duanmau.fragment.ThanhVienFrg;
import com.example.duanmau.fragment.TheLoaiFrg;
import com.example.duanmau.fragment.Top10Frg;
import com.example.duanmau.fragment.UserFrg;
import com.google.android.material.navigation.NavigationView;

public class MainActivity2 extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navlayout);
        setSupportActionBar(toolbar);
//        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new PhieuMuonFrg()).commit();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.phieumuon){
                    PhieuMuonFrg frgPM = new PhieuMuonFrg();
                    relaceFrg(frgPM);
                    toolbar.setTitle("Quản lý phiếu mượn");
                }else if(item.getItemId() == R.id.loaisach){
                    TheLoaiFrg frgLS =  new TheLoaiFrg();
                    relaceFrg(frgLS);
                    toolbar.setTitle("Quản lý loại sách");
                }else if(item.getItemId() == R.id.sach){
                    SachFrg frgS = new SachFrg();
                    relaceFrg(frgS);
                    toolbar.setTitle("Quản lý sách");
                }else if(item.getItemId() == R.id.thanhvien){
                    ThanhVienFrg frgTV = new ThanhVienFrg();
                    relaceFrg(frgTV);
                    toolbar.setTitle("Quản lý thành viên");
                }else if(item.getItemId() == R.id.top10){
                    Top10Frg frgt = new Top10Frg();
                    relaceFrg(frgt);
                    toolbar.setTitle("Top 10 sách mượn nhiều nhất");
                }else if(item.getItemId() == R.id.topdoanhthu) {
                    DoanhThuFrg frgTND = new DoanhThuFrg();
                    relaceFrg(frgTND);
                    toolbar.setTitle("Top Doanh Thu");
                }else if(item.getItemId()==R.id.addall){
                    UserFrg frgđ = new UserFrg();
                    relaceFrg(frgđ);
                }else if(item.getItemId() == R.id.changepass){
                    Doimak frgCP = new Doimak();
                    relaceFrg(frgCP);
                    toolbar.setTitle("Đổi mật khẩu");
                }else if(item.getItemId() == R.id.logout){
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Đăng Xuất");
                    builder.setMessage("Bạn chắc chăn muướn đăng xuất chứ!");
                    builder.setPositiveButton("Đăng xuất", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            startActivity(new Intent(MainActivity2.this, Login.class));
                            finish();
                        }
                    });
                    builder.setNegativeButton("Hủy",null);
                    builder.create().show();
                }
                drawerLayout.closeDrawer(navigationView);
                return true;
            }
        });

        // hiển thị một số chức năng cho Admin

    }

    public void relaceFrg(Fragment frg){
        FragmentManager fg = getSupportFragmentManager();
        fg.beginTransaction().replace(R.id.framelayout,frg).commit();
    }
}
