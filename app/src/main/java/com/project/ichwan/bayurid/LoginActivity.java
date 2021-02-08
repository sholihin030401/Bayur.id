package com.project.ichwan.bayurid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.project.ichwan.bayurid.buyer.MainClientActivity;
import com.subhrajyoti.passwordview.PasswordView;

public class LoginActivity extends AppCompatActivity {

    EditText email;
    PasswordView passwordView;
    FirebaseAuth mAuth;
    RadioButton cpembeli, cpenjual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email_login);
        passwordView = findViewById(R.id.password_login);
        mAuth = FirebaseAuth.getInstance();
        cpembeli = findViewById(R.id.choose_pembeli);
        cpenjual = findViewById(R.id.choose_penjual);

        findViewById(R.id.btnlogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

        findViewById(R.id.btnregist_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    private void loginUser() {
        String txmail, txpass;

        txmail = email.getText().toString();
        txpass = passwordView.getText().toString();

        if (TextUtils.isEmpty(txmail)){
            Toast.makeText(this, "Email tidak boleh kosong!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(txpass)){
            Toast.makeText(this, "Password tidak boleh kosong!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!cpembeli.isChecked() || !cpenjual.isChecked()){
            Toast.makeText(this, "Pilih tipe pengguna!", Toast.LENGTH_SHORT).show();
        }
        mAuth.signInWithEmailAndPassword(txmail, txpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    if (cpenjual.isChecked()){
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }
                    if (cpembeli.isChecked()){
                        startActivity(new Intent(LoginActivity.this, MainClientActivity.class));
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Login gagal!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}