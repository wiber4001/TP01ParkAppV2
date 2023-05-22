package com.wny2023.tp01parkappv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.wny2023.tp01parkappv2.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(v->clickLogin());
        binding.btnSignin.setOnClickListener(v->clickSign());

        binding.btnEnter.setOnClickListener(v->clickEnter());
    }

    void clickEnter(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    void clickLogin(){
        Toast.makeText(this, "기능을 바꿀 예정입니다.메인화면으로 입장합니다.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    void clickSign(){
        Toast.makeText(this, "기능을 바꿀 예정입니다.메인화면으로 입장합니다.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}