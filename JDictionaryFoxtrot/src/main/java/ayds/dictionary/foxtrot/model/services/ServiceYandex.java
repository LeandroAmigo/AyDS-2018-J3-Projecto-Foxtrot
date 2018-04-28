package ayds.dictionary.foxtrot.model.services;

import ayds.dictionary.foxtrot.model.Definition;
import ayds.dictionary.foxtrot.model.parsers.ParserFromXML;
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

  @Override public Definition getMeaning(String term) {
      String meaning=null;
      Response<String> callResponse;
      try {
        callResponse = yandexAPI.getTerm(term).execute();
        meaning=callResponse.body();
        meaning= ParserFromXML.getInstance().format(meaning);
      } catch (IOException e) {
       // throw new TranslatorException("Se produjo un error en la conexion con el servicio del traductor");
      }
      return new Definition(term, meaning);
  }

}
