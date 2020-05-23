package com.example.sharedpreferencestp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Model.Usuario;
import Registro.RegistroActivity;
import request.ApiClient;

public class MainActivity extends AppCompatActivity {
private EditText mail,password;
private Usuario user;
private LoginViewModel vm;
private ApiClient ap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datos();
    }
    public void login(View v)
    {
        vm.autenticar(mail,password,this,user);

    }
    public void registrar(View v)
    {
        Intent i = new Intent(this, RegistroActivity.class);
        startActivity(i);
    }
    public void datos()
    {
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LoginViewModel.class);
        ap.conectar(this);
        user = ap.leer(this);
        mail = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPass);
    }
}
