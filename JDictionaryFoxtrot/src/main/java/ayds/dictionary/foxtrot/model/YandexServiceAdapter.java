package ayds.dictionary.foxtrot.model;

import ayds.dictionary.foxtrot.model.exceptions.TranslatorException;
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
  public String getMeaning(String term) throws IOException{
    String meaning = null;
    meaning = yandexService.getMeaning(term);
    return meaning;
  }

  @Override
  public Source getSource() {
    return source;
  }

}
