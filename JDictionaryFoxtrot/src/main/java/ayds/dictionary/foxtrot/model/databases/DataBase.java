package ayds.dictionary.foxtrot.model.databases;

import ayds.dictionary.foxtrot.model.Definition;
import ayds.dictionary.foxtrot.model.externalServices.Source;

public interface  DataBase {
   void saveDefinition(Definition definition);
   Definition getMeaning(String term, Source source);
}
