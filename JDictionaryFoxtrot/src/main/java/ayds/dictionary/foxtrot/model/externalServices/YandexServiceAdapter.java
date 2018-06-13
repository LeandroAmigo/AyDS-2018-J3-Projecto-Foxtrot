package ayds.dictionary.foxtrot.model.externalServices;

import ayds.dictionary.foxtrot.services.YandexService;
import java.io.IOException;

class YandexServiceAdapter implements ServiceAdapter {
  private YandexService yandexService;

  YandexServiceAdapter(YandexService yandexService) {
    this.yandexService = yandexService;
  }

  @Override
  public String getMeaning(String term) throws IOException {
    String meaning = yandexService.getMeaning(term);
    return meaning;
  }

}
