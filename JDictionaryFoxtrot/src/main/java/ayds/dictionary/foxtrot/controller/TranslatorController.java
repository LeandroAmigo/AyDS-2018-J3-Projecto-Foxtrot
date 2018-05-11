package ayds.dictionary.foxtrot.controller;

import ayds.dictionary.foxtrot.view.TranslatorView;

public interface TranslatorController {
  void onEventGo(String request);
  void setTranslatorView(TranslatorView translatorView);
}
