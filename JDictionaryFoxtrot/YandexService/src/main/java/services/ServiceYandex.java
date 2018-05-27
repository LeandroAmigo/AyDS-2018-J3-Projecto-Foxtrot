package services;

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

  @Override public String getMeaning(String term) throws IOException {
      String meaning=null;
      Response<String> callResponse;
      callResponse = yandexAPI.getTerm(term).execute();
      meaning=callResponse.body();
      return meaning;
  }

}
