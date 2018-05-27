package services;

import java.io.IOException;

public interface Service {
  String getMeaning(String term) throws IOException;
}
