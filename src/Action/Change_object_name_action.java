package Action;

import Items.UML_item;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Change_object_name_action extends Basic_action{
    @Override
    public void actionPerformed(ActionEvent e) {
        List<UML_item> selected_items = get_canvas().get_selected_items();
        if(selected_items.size() == 1){     // only one item selected
            UML_item item = selected_items.get(0);
            if(item.get_items() == null){   // item is a Basic_object
                JFrame window = new Action_window(item);
            } else {                          // item is a composite container
                Invalid_window window = new Invalid_window("Please select a object to change its name.");
            }
        } else {
            Invalid_window window = new Invalid_window("Please select only one item");
        }
        get_canvas().clear_selected_items();
        get_canvas().repaint();
    }
    private class Action_window extends JFrame{
        private JTextField Text;
        private final UML_item item;
        public Action_window(UML_item item){
            super("Change object name");
            setLayout(new BorderLayout());
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.item = item;
            add_textField();
            add_ok();
            add_cancel();

            setSize(200, 100);
            setLocationRelativeTo(null);
            setVisible(true);
        }
        private void add_textField(){
            Text = new JTextField("Object Name");
            Text.setSize(200, 100);
            add(Text, BorderLayout.NORTH);
        }
        private void add_ok(){
            JButton ok = new JButton("OK");
            add(ok, BorderLayout.WEST);
            ok.addActionListener(new_e->{
                item.set_name(Text.getText());
                get_canvas().repaint();
                dispose();
            });
        }
        private void add_cancel(){
            JButton cancel = new JButton("Cancel");
            add(cancel, BorderLayout.EAST);
            cancel.addActionListener(new_e-> dispose());
        }
    }
}
