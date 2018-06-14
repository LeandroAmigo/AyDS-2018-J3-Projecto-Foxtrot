package ayds.dictionary.foxtrot.model.externalServices.adapters;

import java.io.IOException;

public interface ServiceAdapter {
  String getMeaning(String term) throws IOException;
}
