package Action;

import javax.swing.JOptionPane;
import javax.swing.JDialog;

public class Invalid_window{
    public Invalid_window(String message){
        //JOptionPane.showMessageDialog(null, text);
        JOptionPane optionPane = new JOptionPane(message,JOptionPane.WARNING_MESSAGE);
        JDialog dialog = optionPane.createDialog("Invalid Operation!");
        dialog.setAlwaysOnTop(true); // to show top of all other application
        dialog.setVisible(true); // to visible the dialog
    }

}
