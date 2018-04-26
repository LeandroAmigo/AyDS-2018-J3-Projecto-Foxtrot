package ayds.dictionary.foxtrot.model;

import ayds.dictionary.foxtrot.excepciones.TraductorException;

class TraductorModelImpl implements TraductorModel{

 private final Repository repository;
 private TraductorModelListener listener;
 private String meaning;

  TraductorModelImpl(Repository repository) {
    this.repository= repository;
  }

  public void setListener(TraductorModelListener traductorModelListener) {
      this.listener = traductorModelListener;
    }

  @Override
  public void solicitarResultado(String term) {
    try {
      meaning = repository.getMeaning(term);
    } catch(TraductorException e) {
      System.out.println(e.getMessage());
    }
    notifyListener();
  }

  public String getMeaning(){
      return meaning;
  }

  private void notifyListener() {
      if (listener != null) {
          listener.didUpdateTraductor();
      }
  }

}
