package Mode;

import Items.OBJECT;
import Items.UML_item;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseEvent;

public class Create_mode extends Basic_mode{
    // variables
    private final OBJECT basic_object;
    private final UML_item preview = new Preview();

    // constructor
    public Create_mode(OBJECT object){
        basic_object = object;
    }
    // functions

    @Override
    public void mouseClicked(MouseEvent e) {
        get_canvas().add_uml_item(basic_object.get_object(e.getPoint()));
        get_canvas().repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        get_canvas().clear_selected_items();
        preview.set_from(e.getPoint());
        get_canvas().add_selected_item(preview);
        get_canvas().repaint();
    }

    private class Preview extends UML_item {
        // variables
        private final int width = 80;
        private final int height = 80;
        @Override
        public void draw(Graphics g) {
        }
        @Override
        public void draw_selected(Graphics g) {
            g.setColor(new Color(0, 0, 0, 20));
            g.fillRect(get_from().x, get_from().y, width, height);
            g.setColor(Color.BLACK);
        }
    }
}
