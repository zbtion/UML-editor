package Component;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import Action.ACTION;

public class Menubar extends JMenuBar {

    // variables

    // constructor
    public Menubar(){
        add_file();
        add_edit();
    }
    // functions
    private void add_file(){
        add(new JMenu("File"));
    }
    private void add_edit(){
        JMenu edit = new JMenu("Edit");
        edit.add(new MenuItem( ACTION.GROUP, "Group"));
        edit.add(new MenuItem( ACTION.UNGROUP, "Ungroup"));
        edit.add(new MenuItem( ACTION.CHANGE_OBJECT_NAME, "Change object name"));
        add(edit);
    }

    private class MenuItem extends JMenuItem{
        // variables
        // constructor
        public MenuItem(ACTION action, String name){
            super(name);
            addActionListener(action.get_action());
        }
        // functions
    }
}
