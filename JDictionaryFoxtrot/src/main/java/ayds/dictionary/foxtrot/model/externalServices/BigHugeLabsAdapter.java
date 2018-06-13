package ayds.dictionary.foxtrot.model.externalServices;


import ayds.dictionary.delta.services.BigHugeLabsService;

import java.io.IOException;

public class BigHugeLabsAdapter implements ServiceAdapter {
  private BigHugeLabsService bigHugeLabsService;

  BigHugeLabsAdapter(BigHugeLabsService bigHugeLabsService) {
    this.bigHugeLabsService = bigHugeLabsService;
  }

  @Override
  public String getMeaning(String term) throws IOException{
    String meaning = ""/*bigHugeLabsService.getMeaning(term)*/;
    return meaning;
  }

}
