package ayds.dictionary.foxtrot.model;

import ayds.dictionary.foxtrot.excepciones.TraductorException;

class TraductorModelImpl implements TraductorModel{

 private final Repository repository;
 private TraductorModelListener listener;
 private Definition definition;

  TraductorModelImpl(Repository repository) {
    this.repository= repository;
  }

  @Override
  public void setListener(TraductorModelListener traductorModelListener) {
      this.listener = traductorModelListener;
    }

  @Override
  public void solicitarResultado(String term) {
      definition = repository.getDefinition(term);
      notifyListener();
  }

  @Override
  public Definition getDefinition(){
      return definition;
  }

  private void notifyListener() {
      if (listener != null) {
          listener.didUpdateTraductor();
      }
  }

}
