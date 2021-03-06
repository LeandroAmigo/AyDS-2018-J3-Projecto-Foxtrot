package ayds.dictionary.foxtrot.model.externalServices.adapters;

import ayds.dictionary.foxtrot.services.YandexService;

class YandexServiceAdapter implements ServiceAdapter {
  private YandexService yandexService;

  YandexServiceAdapter(YandexService yandexService) {
    this.yandexService = yandexService;
  }

  @Override
  public String getMeaning(String term) throws Exception {
    return yandexService.getMeaning(term);
  }

}
