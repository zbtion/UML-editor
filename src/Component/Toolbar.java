package Component;

import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

import Mode.MODE;


public class Toolbar extends JToolBar {
    // variables
    private final Canvas canvas = Canvas.get_instance();
    private JButton hold;
    // constructor
    public Toolbar(){
        setOrientation(JToolBar.VERTICAL);
        add_button();
    }
    // functions
    private void add_button(){
        add(new Toolbutton( MODE.SELECT,"img/select.png"));
        add(new Toolbutton( MODE.ASSOCIATION,"img/association_line.png"));
        add(new Toolbutton( MODE.GENERALIZATION, "img/generalization_line.png"));
        add(new Toolbutton( MODE.COMPOSITION, "img/composition_line.png"));
        add(new Toolbutton( MODE.CLASS, "img/class.png"));
        add(new Toolbutton( MODE.USECASE, "img/use_case.png"));
    }

    private class Toolbutton extends JButton{
        // variables
        private final MODE mode;
        // constructor
        public Toolbutton( MODE mode, String img_path){
            super(new ImageIcon(img_path));
            this.mode = mode;
            addActionListener(e -> actionListener());
        }

        private void actionListener(){      // black the button and set the canvas mode
            if(hold != null)
                hold.setBackground(Color.WHITE);
            hold = this;
            this.setBackground(Color.BLACK);
            canvas.set_mode(this.mode);
            canvas.clear_selected_items();
            canvas.repaint();
        }
        // functions
    }

}
