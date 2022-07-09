package domain.entities.Organizacion.Hogares;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class HogaresAPI {
    private static HogaresAPI instancia = null;
    private static final String urlAPI = "https://api.refugiosdds.com.ar/api/";
    private Retrofit retrofit;

    private HogaresAPI(){
        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static HogaresAPI getInstancia(){
        if(instancia == null){
            instancia = new HogaresAPI();
        }
        return instancia;
    }

    public ListadoDeHogares listadoDeHogares() throws IOException {
        ServicesHogares servicesHogares = this.retrofit.create(ServicesHogares.class);
        Call<ListadoDeHogares> requestHogares = servicesHogares.hogares();
        Response<ListadoDeHogares> responseHogares = requestHogares.execute();
        return responseHogares.body();
    }
}
