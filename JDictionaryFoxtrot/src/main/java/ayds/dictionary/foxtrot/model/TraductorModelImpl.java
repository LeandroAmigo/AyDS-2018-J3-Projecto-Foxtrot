package ayds.dictionary.foxtrot.model;


class TraductorModelImpl implements TraductorModel{

  //private UserModelListener listener;

  TraductorModelImpl() {
    DataBase.createNewDatabase();
  }

  @Override public void updateUser(String name, String lastName) {
    updateUserNow( name,  lastName);
    notifyListener();
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
