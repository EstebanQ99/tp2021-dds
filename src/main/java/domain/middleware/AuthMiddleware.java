package domain.middleware;

import spark.Request;
import spark.Response;

public class AuthMiddleware {

    public Response verificarSesion(Request request, Response response){
        if(request.session().isNew() || request.session().attribute("id") == null){
            response.redirect("/login");
        }
        return response;
    }
}