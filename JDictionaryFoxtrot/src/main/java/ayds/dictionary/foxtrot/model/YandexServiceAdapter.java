package ayds.dictionary.foxtrot.model;

import ayds.dictionary.foxtrot.exceptions.TranslatorException;
import services.Service;

import java.io.IOException;

class YandexServiceAdapter implements ServiceAdapter{
  private Service yandexService;
  private final Source source;

  YandexServiceAdapter(Service yandexService) {
    this.yandexService = yandexService;
    source = Source.YANDEX;
  }

  @Override
  public String getMeaning(String term) {
    String meaning = "";
    try {
      meaning = yandexService.getMeaning(term);
    } catch (IOException e) {
      TranslatorModelModule.getInstance().getExceptionHandler().notifyException(new TranslatorException("Hubo un fallo en la conexión al servicio."));
    }
    return meaning;
  }

  @Override
  public Source getSource() {
    return source;
  }

}
