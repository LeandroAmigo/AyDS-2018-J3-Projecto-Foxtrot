package ayds.dictionary.foxtrot.view;
import ayds.dictionary.foxtrot.controller.TranslatorController;
import ayds.dictionary.foxtrot.model.Definition;
import ayds.dictionary.foxtrot.model.ExceptionListener;
import ayds.dictionary.foxtrot.model.TranslatorModel;
import ayds.dictionary.foxtrot.model.TranslatorModelListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class TranslatorViewImpl implements TranslatorView {
  private JTextField textField1;
  private JButton goButton;
  private JPanel contentPane;
  private JTextPane translatorPanel;
  private TranslatorController translatorController;
  private TranslatorModel translatorModel;
  private OutputParser outputParser;

	TranslatorViewImpl(TranslatorController translatorController, TranslatorModel translatorModel, OutputParser outputParser){
    this.translatorController = translatorController;
    this.translatorModel = translatorModel;
    this.outputParser = outputParser;
    initTranslatorPanel();
    initListeners();
  }

  private void initTranslatorPanel() {
    translatorPanel.setContentType("text/html");
  }

  private void initListeners() {
    initButtonListener();
    initTraductorModelListener();
    initExceptionListener();
  }


  private void  initButtonListener(){
    goButton.addActionListener(new ActionListener() {
      @Override public void actionPerformed(ActionEvent e) {
        translatorController.onEventGo(textField1.getText().trim());
      }
     });
  }

  private void  initTraductorModelListener(){
	  translatorModel.setListener(new TranslatorModelListener() {
        @Override
        public void didUpdateTraductor() {
            updateTranslationPanel(translatorModel.getDefinition());
        }
      });
  }

  private void updateTranslationPanel(Definition definition) {
    String meaning = formatMeaning(definition);
    translatorPanel.setText(meaning);
  }

  private String formatMeaning(Definition definition) {
	  String meaning = "";
	  if(!definition.isMeaningEmpty())
	    meaning = outputParser.format(definition.getMeaning(), definition.getTerm());
	  return meaning;

  }

  private void initExceptionListener() {
	  translatorModel.setExceptionListener(new ExceptionListener() {
        @Override
        public void notifyMessage(String message) {
          showWindowException(message);
        }
      });

  }

  private void showWindowException(String message) {
    JOptionPane.showMessageDialog(new JFrame(),
            message,
            "Mensaje de Error",
            JOptionPane.ERROR_MESSAGE);
  }


  public void showView() {
    JFrame frame = new JFrame("Online Translator");
    frame.setContentPane(contentPane);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
