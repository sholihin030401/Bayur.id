package com.project.ichwan.bayurid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.project.ichwan.bayurid.cnbfragment.HomeFragment;
import com.project.ichwan.bayurid.cnbfragment.ProfilFragment;
import com.subhrajyoti.passwordview.PasswordView;

public class RegisterActivity extends AppCompatActivity {

    EditText username, email;
    PasswordView pass, conpass;
    CheckBox checkBox;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        conpass = findViewById(R.id.confirm_pw);
        checkBox = findViewById(R.id.check_terms);
        
        findViewById(R.id.btnregist).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registUser();
            }
        });
    }

    private void registUser() {
        final String txuser, txemail, txpas, txconpass;

        txuser = username.getText().toString();
        txemail = email.getText().toString();
        txpas = pass.getText().toString();
        txconpass = conpass.getText().toString();

        if (TextUtils.isEmpty(txuser)){
            Toast.makeText(this, "Username tidak boleh kosong!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(txemail)){
            Toast.makeText(this, "Email tidak boleh kosong!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(txpas)){
            Toast.makeText(this, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(txconpass)){
            Toast.makeText(this, "Konfirmasi password terlebih dahulu!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!checkBox.isChecked()){
            Toast.makeText(this, "Setujui dahulu layanan aplikasi!", Toast.LENGTH_SHORT).show();
        }

        auth.createUserWithEmailAndPassword(txemail,txpas).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "Berhasil membuat akun", Toast.LENGTH_SHORT).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("username",txuser);
                    HomeFragment home = new HomeFragment();
                    ProfilFragment profil = new ProfilFragment();
                    home.putArguments(bundle);
                    profil.putUsername(bundle);
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                } else {
                    Toast.makeText(RegisterActivity.this, "Gagal membuat akun", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}