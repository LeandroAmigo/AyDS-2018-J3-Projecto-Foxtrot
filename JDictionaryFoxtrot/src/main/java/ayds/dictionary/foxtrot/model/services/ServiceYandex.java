package ayds.dictionary.foxtrot.model.services;

import ayds.dictionary.foxtrot.excepciones.TraductorException;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.Response;

import java.io.IOException;


public class ServiceYandex implements Service{
  private static ServiceYandex instance;
  private final String urlAPI = "https://translate.yandex.net/api/v1.5/tr/";
  private YandexAPI yandexAPI;

  private ServiceYandex() {
    Retrofit retrofit = new Retrofit.Builder()
    .baseUrl(urlAPI)
    .addConverterFactory(ScalarsConverterFactory.create())
    .build();

    yandexAPI = retrofit.create(YandexAPI.class);
  }
  public static ServiceYandex getInstance(){
    if(instance == null) {
      instance =  new ServiceYandex();
    }
    return instance;
  }
  @Override public String obtenerTermino(String request) throws TraductorException {
      String retorno=null;
      Response<String> callResponse;
      try {
        callResponse = yandexAPI.getTerm(request).execute();
        retorno=callResponse.body();
      } catch (IOException e) {
        throw new TraductorException("Se produjo un error en la conexion con el servicio del traductor");
      }
      return retorno;
  }
	@Override public boolean hayResultados(String respuesta){
    return respuesta!=null;
  }
}
