package ayds.dictionary.foxtrot.view;
import ayds.dictionary.foxtrot.controller.TranslatorController;
import ayds.dictionary.foxtrot.model.Definition;
import ayds.dictionary.foxtrot.model.ExceptionListener;
import ayds.dictionary.foxtrot.model.TranslatorModel;
import ayds.dictionary.foxtrot.model.TranslatorModelListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.*;

class TranslatorViewImpl implements TranslatorView {
  private JTextField searchField;
  private JButton goButton;
  private JPanel contentPane;
  private JLabel loadingLabel;
  private JTextPane translatorPanel1;
  private JTextPane translatorPanel2;
  private JTextPane translatorPanel3;
  private JLabel sourceLabelPanel1;
  private JLabel sourceLabelPanel2;
  private JLabel sourceLabelPanel3;
  private LinkedList<JTextPane> translatorPanels;
  private LinkedList <JLabel> sourceLabelPanels;
  private TranslatorController translatorController;
  private TranslatorModel translatorModel;
  private OutputParser outputParser;

	TranslatorViewImpl(TranslatorController translatorController, TranslatorModel translatorModel, OutputParser outputParser){
    this.translatorController = translatorController;
    this.translatorModel = translatorModel;
    this.outputParser = outputParser;
    initTranslatorPanels();
    initSourceLanelPanels();
    initListeners();
  }

  private void initTranslatorPanels() {
    loadingLabel.setVisible(false);
    translatorPanels = new LinkedList<JTextPane>();
    translatorPanels.add(translatorPanel1);
    translatorPanels.add(translatorPanel2);
    translatorPanels.add(translatorPanel3);
  }

  private void initSourceLanelPanels(){
    sourceLabelPanels = new LinkedList<JLabel>();
    sourceLabelPanels.add(sourceLabelPanel1);
    sourceLabelPanels.add(sourceLabelPanel2);
    sourceLabelPanels.add(sourceLabelPanel3);
  }

  private void initListeners() {
    initGoButtonListener();
    initTraductorModelListener();
    initExceptionListener();
  }


  private void  initGoButtonListener(){
    goButton.addActionListener(new ActionListener() {
      @Override public void actionPerformed(ActionEvent e) {
        if (InputValidation.isInputValid(searchField.getText().trim())) {
          translatorController.onEventGo(searchField.getText().trim());
          loadingLabel.setVisible(true);
        }
        else {
          showWindowException("Ingrese un termino valido");
        }
      }
     });
  }

  private void  initTraductorModelListener(){
	  translatorModel.setListener(new TranslatorModelListener() {
        @Override
        public void didUpdateTraductor() {
          loadingLabel.setVisible(false);
          updateTranslationPanels(translatorModel.getDefinitions());
        }
      });
  }

  private void updateTranslationPanels(Iterable<Definition> definitions) {
	  int currentPanel = 0;
	  for (Definition definition : definitions) {
	    String meaning = formatMeaning(definition);
	    if (!meaning.isEmpty()) {
	      translatorPanels.get(currentPanel).setText(meaning);
        }
        else {
         translatorPanels.get(currentPanel).setText("No hubo resultado. ");
        }
        sourceLabelPanels.get(currentPanel).setText("Source: "+definition.getSource());
        currentPanel++;
	  }
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
            "Mensaje de error",
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
