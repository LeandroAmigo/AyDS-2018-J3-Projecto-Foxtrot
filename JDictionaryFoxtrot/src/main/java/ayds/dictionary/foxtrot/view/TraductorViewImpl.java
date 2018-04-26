package ayds.dictionary.foxtrot.view;
import ayds.dictionary.foxtrot.controller.TraductorController;
import ayds.dictionary.foxtrot.model.TraductorModel;
import ayds.dictionary.foxtrot.model.TraductorModelListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

public class TraductorViewImpl implements TraductorView {
  private JTextField textField1;
  private JButton goButton;
  private JPanel contentPane;
  private JTextPane PaneldeTraduccion;

  private TraductorController traductorController;
  private TraductorModel traductorModel;
  private OutputParser outputParser;

	public TraductorViewImpl(TraductorController traductorController, TraductorModel traductorModel, OutputParser outputParser){
    this.traductorController=traductorController;
    this.traductorModel= traductorModel;
    this.outputParser = outputParser;

    PaneldeTraduccion.setContentType("text/html");

    initListeners();
  }

  private void initListeners() {
    initButtonListener();
    initTraductorModelListener();
  }

  private void  initButtonListener(){
    goButton.addActionListener(new ActionListener() {
      @Override public void actionPerformed(ActionEvent e) {
        traductorController.onEventGo(textField1.getText().trim());
      }
     });
  }

  private void  initTraductorModelListener(){
	  traductorModel.setListener(new TraductorModelListener() {
        @Override
        public void didUpdateTraductor() {
            updateTranslationPanel();
        }
      });
  }

  private void updateTranslationPanel() {
	  String meaning = traductorModel.getMeaning();
	  meaning = outputParser.format(meaning);
    PaneldeTraduccion.setText(outputParser.resaltar(meaning,meaning));
  }

  public void inicializarGUI() {
    JFrame frame = new JFrame("Online Translator");
    frame.setContentPane(contentPane);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
