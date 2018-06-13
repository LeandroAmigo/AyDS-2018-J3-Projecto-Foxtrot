package ayds.dictionary.foxtrot.model.externalServices;


//import services.Service;

import java.io.IOException;

public class BigHugeLabsAdapter implements ServiceAdapter {
  //private Service bigHugeLabsService;

  /*
  BigHugeLabsAdapter(Service bigHugeLabsService) {
    this.bigHugeLabsService = bigHugeLabsService;
    //bigHugeLabsService.connect();
  }
  */
  @Override
  public String getMeaning(String term) throws IOException {
    //String meaning = bigHugeLabsService.getMeaning(term);
    return null;
  }

}
