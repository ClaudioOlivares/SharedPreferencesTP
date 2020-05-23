package com.example.sharedpreferencestp;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import Model.Usuario;
import Registro.RegistroActivity;
import request.ApiClient;

public class LoginViewModel extends ViewModel {

    public void autenticar (EditText mail, EditText password, Context ctx, Usuario user)
    {
        if(user.getApellido() != "-1")
        {
            if(  (user.getMail().equals(mail.getText().toString())) && ( user.getPassword().equals(password.getText().toString())  ) )
            {
                Intent i = new Intent(ctx, RegistroActivity.class);
                i.putExtra("mensaje","login");
                ctx.startActivity(i);
            }
            else {
                Toast.makeText(ctx, "contraseña o email incorrectos", Toast.LENGTH_LONG).show();

            }
        }
        else
        {
            Toast.makeText(ctx, "Primero Debe Registrarse", Toast.LENGTH_LONG).show();
        }
    }
}
