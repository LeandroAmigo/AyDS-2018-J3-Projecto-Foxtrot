package ayds.dictionary.foxtrot.model.externalServices;

import services.Service;
import java.io.IOException;

class YandexServiceAdapter implements ServiceAdapter {
  private Service yandexService;

  YandexServiceAdapter(Service yandexService) {
    this.yandexService = yandexService;
  }

  @Override
  public String getMeaning(String term) throws IOException {
    String meaning = yandexService.getMeaning(term);
    return meaning;
  }

}
