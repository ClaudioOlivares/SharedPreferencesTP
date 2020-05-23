package Registro;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.example.sharedpreferencestp.MainActivity;

import Model.Usuario;
import request.ApiClient;

public class RegistroViewModel extends ViewModel {

 public void checkearDatos(EditText dni, EditText nombre, EditText apellido, EditText mail, EditText pass, Usuario user,Intent i)
 {
     if(i.getExtras() != null)
     {
         if (user.getApellido() != "-1" && i.getStringExtra("mensaje").equals("login")) {
             dni.setText(user.getDni().toString());
             nombre.setText(user.getNombre());
             apellido.setText(user.getApellido());
             mail.setText(user.getMail());
             pass.setText(user.getPassword());
         }
     }
 }

     public void registrar(Usuario user, Context ctx, EditText dni, EditText nombre, EditText apellido, EditText mail, EditText pass, ApiClient ac)
    {
        user.setDni(Long.parseLong(dni.getText().toString()));
        user.setApellido(apellido.getText().toString());
        user.setNombre(nombre.getText().toString());
        user.setMail(mail.getText().toString());
        user.setPassword(pass.getText().toString());
        ac.guardar(ctx,user);
        Intent i = new Intent(ctx, MainActivity.class);
        Toast.makeText(ctx, "registrado", Toast.LENGTH_LONG).show();
        ctx.startActivity(i);
    }
}
