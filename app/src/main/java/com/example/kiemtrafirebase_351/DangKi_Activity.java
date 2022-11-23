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

public class DangKi_Activity extends AppCompatActivity {

    private EditText txt_name, txt_pass, txt_cfpass;
    private Button btn_dk;
    private TextView tv_dn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);

        mAuth = FirebaseAuth.getInstance();

        AnhXa();
        tv_dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_dk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txt_name.getText().toString();
                String pass = txt_pass.getText().toString();
                String cfpass = txt_cfpass.getText().toString();

                if (email.equals("") || pass.equals("") || cfpass.equals("")){
                    Toast.makeText(DangKi_Activity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    if (pass.equals(cfpass)){
                        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(DangKi_Activity.this, "Bạn đã đăng kí Tài khoản thành công.", Toast.LENGTH_SHORT).show();
                                    onBackPressed();
                                }else {
                                    Toast.makeText(DangKi_Activity.this, "Đăng kí không thành công", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }else {
                        Toast.makeText(DangKi_Activity.this, "Xác nhân khôg trùng khớp", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    private void AnhXa() {
        txt_name = findViewById(R.id.txt_name_dk);
        txt_pass =findViewById(R.id.txt_pass_dk);
        txt_cfpass = findViewById(R.id.txt_cfpass_dk);
        btn_dk = findViewById(R.id.btn_dk);
        tv_dn = findViewById(R.id.tv_dn);

    }
}