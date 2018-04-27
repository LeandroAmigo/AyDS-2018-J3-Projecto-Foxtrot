package ayds.dictionary.foxtrot.model;import ayds.dictionary.foxtrot.excepciones.TraductorException;import ayds.dictionary.foxtrot.model.databases.DataBase;import ayds.dictionary.foxtrot.model.services.Service;class RepositoryImpl implements Repository{    private final String dataBaseSymbol = "[*]";    private DataBase dataBase;    private Service service;    RepositoryImpl(DataBase dataBase, Service service) {        this.dataBase = dataBase;        this.service = service;    }    public Definition getDefinition(String term) {        Definition definition = dataBase.getMeaning(term);        if (definition == null) {            definition = service.getMeaning(term);            guardarResultado(definition);        }        else{            String meaningCache = getResultadoCacheado(definition.getMeaning());            definition.setMeaning(meaningCache);        }        return definition;    }    private String getResultadoCacheado(String term) {        return dataBaseSymbol + term;    }    private void guardarResultado(Definition definition) {        dataBase.saveDefinition(definition);    }}