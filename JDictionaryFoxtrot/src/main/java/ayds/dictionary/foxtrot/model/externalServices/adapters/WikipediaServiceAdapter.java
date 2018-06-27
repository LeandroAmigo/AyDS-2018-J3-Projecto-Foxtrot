package ayds.dictionary.foxtrot.model.externalServices.adapters;

import wikipedia.service.WikipediaService;

class WikipediaServiceAdapter implements ServiceAdapter {
  private WikipediaService wikipediaService;

  WikipediaServiceAdapter(WikipediaService wikipediaService) {
    this.wikipediaService = wikipediaService;
    wikipediaService.connectAPI();
  }

  @Override
  public String getMeaning(String term) throws Exception {
    return wikipediaService.getMeaning(term);
  }

}
