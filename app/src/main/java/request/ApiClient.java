package request;

import android.content.Context;
import android.content.SharedPreferences;

import Model.Usuario;

public class ApiClient {

    private static SharedPreferences sp;

    public static SharedPreferences conectar(Context ctx) {
        if (sp == null) {
            sp = ctx.getSharedPreferences("datos", 0);
        }
        return sp;
    }

    public static void guardar(Context ctx, Usuario user) {
        SharedPreferences sp = conectar(ctx);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong("dni", user.getDni());
        editor.putString("apellido", user.getApellido());
        editor.putString("nombre", user.getNombre());
        editor.putString("mail", user.getMail());
        editor.putString("pass", user.getPassword());
        editor.commit();

    }

    public static Usuario leer(Context ctx) {
        SharedPreferences sp = conectar(ctx);
       Long dni= sp.getLong("dni", -1);
       String apellido = sp.getString("apellido", "-1");
        String nombre = sp.getString("nombre", "-1");
        String mail = sp.getString("mail", "-1");
        String pass = sp.getString("pass", "-1");

        Usuario user = new Usuario(dni,apellido,nombre,mail,pass);
        return  user;

    }
}