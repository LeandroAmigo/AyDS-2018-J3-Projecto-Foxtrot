package ayds.dictionary.foxtrot.view;
import ayds.dictionary.foxtrot.controller.TranslatorController;
import ayds.dictionary.foxtrot.model.Definition;
import ayds.dictionary.foxtrot.model.TranslatorModel;
import ayds.dictionary.foxtrot.model.TranslatorModelListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

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
    String meaning;
    if (!definition.isMeaningEmpty())
       meaning = outputParser.format(definition.getMeaning(), definition.getTerm());
    else
      meaning = "No existe resultado";
    translatorPanel.setText(meaning);
  }

  public void showView() {
    JFrame frame = new JFrame("Online Translator");
    frame.setContentPane(contentPane);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
