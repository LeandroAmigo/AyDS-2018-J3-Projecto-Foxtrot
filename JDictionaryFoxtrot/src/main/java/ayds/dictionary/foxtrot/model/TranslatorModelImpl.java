package ayds.dictionary.foxtrot.model;


class TranslatorModelImpl implements TranslatorModel {

 private final Repository repository;
 private TranslatorModelListener listener;
 private Iterable<Definition> definitions;

  TranslatorModelImpl(Repository repository) {
    this.repository= repository;
  }

  @Override
  public void setListener(TranslatorModelListener translatorModelListener) {
      this.listener = translatorModelListener;
    }

  @Override
  public void requestResult(String term) {
      definitions = repository.getDefinitions(term);
      notifyListener();
  }

  @Override
  public Iterable<Definition> getDefinitions(){
      return definitions;
  }

  private void notifyListener() {
      if (listener != null) {
          listener.didUpdateTraductor();
      }
  }

  @Override
  public void setExceptionListener(ExceptionListener exceptionListener) {
      TranslatorModelModule.getInstance().getExceptionHandler().setExceptionListener(exceptionListener);
    }
}
