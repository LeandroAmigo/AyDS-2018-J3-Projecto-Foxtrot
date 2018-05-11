package ayds.dictionary.foxtrot.controller;

import ayds.dictionary.foxtrot.model.TranslatorModel;
import ayds.dictionary.foxtrot.view.TranslatorView;

class TranslatorControllerImpl implements TranslatorController {

    private TranslatorModel translatorModel;
    private TranslatorView translatorView;

    TranslatorControllerImpl(TranslatorModel translatorModel) {
        this.translatorModel = translatorModel;
    }

    @Override
    public void setTranslatorView(TranslatorView translatorView) {
        this.translatorView = translatorView;
    }

    @Override
    public void onEventGo(String request) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                translatorModel.requestResult(request);
            }
        }).start();
    }

}