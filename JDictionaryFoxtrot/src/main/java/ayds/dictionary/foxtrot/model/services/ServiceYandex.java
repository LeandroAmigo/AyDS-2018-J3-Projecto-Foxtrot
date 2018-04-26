package ayds.dictionary.foxtrot.model.services;

import ayds.dictionary.foxtrot.excepciones.TraductorException;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.Response;

import java.io.IOException;


class ServiceYandex implements Service{

  private final String urlAPI = "https://translate.yandex.net/api/v1.5/tr/";
  private YandexAPI yandexAPI;

  ServiceYandex() {
    Retrofit retrofit = new Retrofit.Builder()
    .baseUrl(urlAPI)
    .addConverterFactory(ScalarsConverterFactory.create())
    .build();

    yandexAPI = retrofit.create(YandexAPI.class);


  }

  @Override public String getMeaning(String term) {
      String retorno=null;
      Response<String> callResponse;
      try {
        callResponse = yandexAPI.getTerm(term).execute();
        retorno=callResponse.body();
      } catch (IOException e) {
       // throw new TraductorException("Se produjo un error en la conexion con el servicio del traductor");
      }
      return retorno;
  }

}
