package Registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.sharedpreferencestp.R;

import Model.Usuario;
import request.ApiClient;

public class RegistroActivity extends AppCompatActivity {
private EditText dni,nombre,apellido,mail,password;
    private ApiClient ap;
    private Usuario user;
    private RegistroViewModel vm;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(RegistroViewModel.class);
        setContentView(R.layout.activity_registro);
        datos();
    }

    public void datos()
    {
        intent= getIntent();
        dni = findViewById(R.id.etDniRegistro2);
        nombre = findViewById(R.id.etNombreRegistro);
        apellido = findViewById(R.id.etApellidoRegistro);
        mail = findViewById(R.id.etMailRegistro);
        password = findViewById(R.id.etPasswordRegistro);
        ap.conectar(this);
        user = ap.leer(this);
        vm.checkearDatos(dni,nombre,apellido,mail,password,user,intent);

    }
    public void guardarDatos(View v)
    {
       vm.registrar(user,this,dni,nombre,apellido,mail,password,ap);

    }


}
