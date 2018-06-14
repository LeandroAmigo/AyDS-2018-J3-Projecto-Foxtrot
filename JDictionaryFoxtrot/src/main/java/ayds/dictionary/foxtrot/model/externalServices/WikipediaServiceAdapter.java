package ayds.dictionary.foxtrot.model.externalServices;

import wikipedia.service.WikipediaService;
import java.io.IOException;

public class WikipediaServiceAdapter implements ServiceAdapter {
  private WikipediaService wikipediaService;

  WikipediaServiceAdapter(WikipediaService wikipediaService) {
    this.wikipediaService = wikipediaService;
    wikipediaService.connectAPI();
  }

  @Override
  public String getMeaning(String term) throws IOException {
    String meaning = wikipediaService.getMeaning(term);
    return meaning;
  }

}
