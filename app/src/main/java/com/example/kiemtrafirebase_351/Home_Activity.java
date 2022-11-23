package com.example.kiemtrafirebase_351;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.android.material.badge.BadgeUtils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Home_Activity extends AppCompatActivity {

    private ListView lv_danhSach;
    private List<CayThuoc> list;
    private CayThuocAdapter cayThuocAdapter;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private ImageButton btn_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_add = findViewById(R.id.btn_add);
        lv_danhSach = findViewById(R.id.lv_DanhSach);
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();

        list = new ArrayList<>();
        cayThuocAdapter = new CayThuocAdapter(this,R.layout.data_item,list);
        lv_danhSach.setAdapter(cayThuocAdapter);

        databaseReference.child("DanhSach").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot data: dataSnapshot.getChildren()){
                    String ten = data.child("tenKH").getValue(String.class);
                    String tenTG = data.child("tenTG").getValue(String.class);
                    String boPhan = data.child("boPhan").getValue(String.class);
                    list.add(new CayThuoc(ten,tenTG,boPhan));
                }
                cayThuocAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        lv_danhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Home_Activity.this, View_Activity.class);
                startActivity(intent);
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Add_Activity.class);
                startActivity(intent);
            }
        });
    }
}