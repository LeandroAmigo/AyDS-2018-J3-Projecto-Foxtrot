package ayds.dictionary.foxtrot.view;
import ayds.dictionary.foxtrot.controller.TraductorController;
import ayds.dictionary.foxtrot.model.TraductorModel;

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

	public TraductorViewImpl(TraductorController traductorController, TraductorModel traductorModel){
    this.traductorController=traductorController;
    this.traductorModel=traductorModel;

    PaneldeTraduccion.setContentType("text/html");
    initListeners();
  }
  private void initListeners() {
    goButton.addActionListener(new ActionListener() {
      @Override public void actionPerformed(ActionEvent e) {
        //new Thread(new Runnable() {
        //  @Override public void run() {
              traductorController.onEventUpdate(textField1.getText());
        //  }
        //}).start();
     }
    });
/*
    traductorModel.setListener(new TraductorModelListener() {
      @Override public void didUpdateRequest() {
        updateRequest();
      }
    });
*/
  }

  @Override public void updateTraduccion(String traduccion) {
    PaneldeTraduccion.setText(traduccion);
  }
  protected JPanel getContentPane(){
    return contentPane;
  }
}
