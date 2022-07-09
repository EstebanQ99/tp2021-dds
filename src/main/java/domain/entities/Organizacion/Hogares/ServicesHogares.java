package domain.entities.Organizacion.Hogares;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServicesHogares {
    @GET("hogares")
    Call<ListadoDeHogares> hogares();

    @GET("hogares")
    Call<ListadoDeHogares> hogares(@Query("offset") int offset);
}
