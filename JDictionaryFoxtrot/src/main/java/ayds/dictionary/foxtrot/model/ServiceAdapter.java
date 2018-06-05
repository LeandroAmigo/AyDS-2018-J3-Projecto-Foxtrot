package ayds.dictionary.foxtrot.model;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface ServiceAdapter {
  String getMeaning(String term) throws IOException, ParserConfigurationException, SAXException;
  Source getSource();
}
