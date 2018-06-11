package ayds.dictionary.foxtrot.model.externalServices;

import services.Service;

import java.io.IOException;

public class WikipediaServiceAdapter implements ServiceAdapter {
  private Service wikipediaService;

  WikipediaServiceAdapter(Service wikipediaService) {
    this.wikipediaService = wikipediaService;
    //wikipediaService.connectAPI();
  }

  @Override
  public String getMeaning(String term) throws IOException {
    String meaning = wikipediaService.getMeaning(term);
    return meaning;
  }

}
