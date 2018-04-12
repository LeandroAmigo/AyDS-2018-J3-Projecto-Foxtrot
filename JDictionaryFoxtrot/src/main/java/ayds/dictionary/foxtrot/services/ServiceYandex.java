package ayds.dictionary.foxtrot.services;
class ServiceYandex implements Parser{
  private static ServiceYandex instance;
  private YandexAPI wikiAPI;

  private ServiceYandex() {
    Retrofit retrofit = new Retrofit.Builder()
    .baseUrl("https://translate.yandex.net/api/v1.5/tr/")
    .addConverterFactory(ScalarsConverterFactory.create())
    .build();

    wikiAPI = retrofit.create(YandexAPI.class);
  }
  @Override public static Service getInstance(){
    if(instance == null) {
      instance =  new ServiceYandex();
    }
    return instance;
  }
  @Override public String obtenerTermino(String request){
      String retorno;
      Response<String> callResponse;
      //try {
        callResponse = wikiAPI.getTerm(textField1.getText()).execute();
        retorno=callResponse.body();
      //Catch algo tiene que ser
      return retorno;
  }
	@Override public boolean hayResultados(String respuesta){
    return respuesta!=null;
  }
}
