package ayds.dictionary.foxtrot.model;

class TranslatorModelImpl implements TranslatorModel {

 private final Repository repository;
 private TranslatorModelListener listener;
 private Definition definition;

  TranslatorModelImpl(Repository repository) {
    this.repository= repository;
  }

  @Override
  public void setListener(TranslatorModelListener translatorModelListener) {
      this.listener = translatorModelListener;
    }

  @Override
  public void requestResult(String term) {
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
