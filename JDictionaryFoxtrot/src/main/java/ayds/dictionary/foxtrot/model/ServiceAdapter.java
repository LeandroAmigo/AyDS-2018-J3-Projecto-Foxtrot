package ayds.dictionary.foxtrot.model;

import java.io.IOException;

public interface ServiceAdapter {
  String getMeaning(String term) throws IOException;
  Source getSource();
}
