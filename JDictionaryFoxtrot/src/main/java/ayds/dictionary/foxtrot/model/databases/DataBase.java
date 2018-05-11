package ayds.dictionary.foxtrot.model.databases;

import ayds.dictionary.foxtrot.model.Definition;

public interface  DataBase {
   void saveDefinition(Definition definition);
   Definition getMeaning(String term);
}
