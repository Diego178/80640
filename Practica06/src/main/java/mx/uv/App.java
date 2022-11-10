package mx.uv;

import static spark.Spark.*;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
        

        get("/hello", (req, res) -> "Hello World");

        get("/lalo", (req, res) -> "Hello Eduardo");

        get("/yo", (req, res) -> "Hello Diego");

        get("/m", (req, res) -> "<h1>Bienvenido</h1><img src='https://www.uv.mx/v2/images/logouv.jpg'>");

        post("/", (req, res)->{
            System.out.println(req.queryParams("email")+" "+ req.queryParams("password"));
            System.out.println(req.body());
            JsonParser parser = new JsonParser();
            JsonElement arbol= parser.parse(req.body());
            JsonObject peticionDelCliente = arbol.getAsJsonObject();
            System.out.println(peticionDelCliente.get("email")); 
            System.out.println(peticionDelCliente.get("password")); 
            System.out.println(peticionDelCliente.get("email").getAsString()); 
            
            res.status(200);
            JsonObject oRespuesta = new JsonObject();
            oRespuesta.addProperty("msj", "hola");
            // oRespuesta.addProperty("email", req.queryParams("email"));
            oRespuesta.addProperty("email", peticionDelCliente.get("email").getAsString());
            return oRespuesta;
        });
    }
}
