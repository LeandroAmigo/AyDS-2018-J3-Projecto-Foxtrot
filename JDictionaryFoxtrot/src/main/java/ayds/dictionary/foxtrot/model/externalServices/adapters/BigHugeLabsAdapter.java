package ayds.dictionary.foxtrot.model.externalServices.adapters;

import ayds.dictionary.delta.services.BigHugeLabsService;

class BigHugeLabsAdapter implements ServiceAdapter {
  private BigHugeLabsService bigHugeLabsService;

  BigHugeLabsAdapter(BigHugeLabsService bigHugeLabsService) {
    this.bigHugeLabsService = bigHugeLabsService;
  }

  @Override
  public String getMeaning(String term) throws Exception{
    return bigHugeLabsService.getMeaning(term);
  }

}
