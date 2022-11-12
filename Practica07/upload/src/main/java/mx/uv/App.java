package mx.uv;
import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

/**
 * Diego Arellano Moreno
 *
 */
public class App 
    
{
    public static Gson gson = new Gson();
    //base de datos en memoria
    public static Map<String, Usuario> usuarios = new HashMap<>();
    public static void main( String[] args )
    {
        Usuario u1 = new Usuario("1USER", "Juanito", "123");
        Usuario u2 = new Usuario("2USER", "Ana", "456");
        usuarios.put(u1.getId(), u1);
        usuarios.put(u2.getId(), u2);
        System.out.println( "Hello World!" );
        port(80);
        before((req, res)-> res.type("application/json"));
        // get("/usuario", (req, res)-> gson.toJson(u1));
        //get("/usuario", (req, res)-> gson.toJson(usuarios));
        get("/usuarios", (req, res)-> gson.toJson(usuarios));


        post("/usuarios", (req, res)->{
            String datosFormulario = req.body();
            System.out.println(datosFormulario);
            Usuario u = gson.fromJson(datosFormulario, Usuario.class);
            usuarios.put(u.getId(), u);
            return "usuarioAgregado";
        });

    }
}
