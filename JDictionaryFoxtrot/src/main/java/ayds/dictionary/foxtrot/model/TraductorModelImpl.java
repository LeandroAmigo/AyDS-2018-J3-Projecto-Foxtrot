package ayds.dictionary.foxtrot.model;


class TraductorModelImpl implements TraductorModel{

  //private UserModelListener listener;

  TraductorModelImpl() {
    DataBase.createNewDatabase();
  }



/*
  private void notifyListener() {
    if (listener != null) {
      listener.didUpdateRequest();
    }
  }
  @Override public void setListener(UserModelListener listener) {
    this.listener = listener;
  }

  @Override public User getUser() {
    return user;
  }
*/
}
