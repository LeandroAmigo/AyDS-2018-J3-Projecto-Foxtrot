package ayds.dictionary.foxtrot.model;

import org.xml.sax.SAXException;
import services.Service;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

class YandexServiceAdapter implements ServiceAdapter{
  private Service yandexService;
  private final Source source;

  YandexServiceAdapter(Service yandexService) {
    this.yandexService = yandexService;
    source = Source.YANDEX;
  }

  @Override
  public String getMeaning(String term) throws IOException, ParserConfigurationException, SAXException {
    String meaning = null;
    meaning = yandexService.getMeaning(term);
    return meaning;
  }

  @Override
  public Source getSource() {
    return source;
  }

}
