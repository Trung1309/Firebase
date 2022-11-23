package com.example.kiemtrafirebase_351;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText txt_name, txt_pass;
    private Button btn_dn;
    private TextView tv_dk;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        AnhXa();

        btn_dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DangNhap();
            }
        });

        tv_dk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DangKi_Activity.class);
                startActivity(intent);
            }
        });
    }

    private void DangNhap() {
        String name = txt_name.getText().toString();
        String pass = txt_pass.getText().toString();

        if (name.equals("")){
            Toast.makeText(this, "Vui lòng nhập email !", Toast.LENGTH_SHORT).show();
            return;
        }
        if (pass.equals("")){
            Toast.makeText(this, "Vui lòng nhập mật khẩu !", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(name,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,Home_Activity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void AnhXa() {
        txt_name = findViewById(R.id.txt_name_dn);
        txt_pass = findViewById(R.id.txt_pass_dn);
        tv_dk = findViewById(R.id.tv_dk);
        btn_dn = findViewById(R.id.btn_dn);
    }
}