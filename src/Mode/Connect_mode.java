package Mode;

import Items.LINE;
import Items.Port;
import Items.UML_item;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseEvent;

public class Connect_mode extends Basic_mode{
    // variables
    private final LINE connection_line;
    Port start, end;
    UML_item unconnected_line;
    // constructor
    public Connect_mode(LINE line){
        connection_line = line;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        UML_item item = get_canvas().get_inside_item(e.getPoint());
        unconnected_line = new Unconnected_line();
        get_canvas().add_uml_item(unconnected_line);
        start = (item != null) ? item.get_nearest_port(e.getPoint()) : null;

        if(start != null)
            unconnected_line.set_from(start.get_center());
        else
            unconnected_line.set_from(e.getPoint());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        UML_item item = get_canvas().get_inside_item(e.getPoint());
        end = (item != null) ? item.get_nearest_port(e.getPoint()) : null;

        if(end != null)
            unconnected_line.set_to(end.get_center());
        else
            unconnected_line.set_to(e.getPoint());

        get_canvas().repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(start != null && end != null)
            get_canvas().add_uml_item(connection_line.get_line(start, end));
        start = null;
        end = null;
        get_canvas().remove_uml_item(unconnected_line);
        unconnected_line = null;
        get_canvas().repaint();
    }

    private class Unconnected_line extends UML_item{
        // variables
        // constructor
        // functions
        //      override functions
        @Override
        public void draw(Graphics g) {
            if(get_from() == null || get_to() == null) return;
            g.setColor(new Color(0, 0, 0, 30));
            g.drawLine(get_from().x, get_from().y, get_to().x, get_to().y);
            g.setColor(Color.black);
        }
        //      setter

        //      getter
    }
}
