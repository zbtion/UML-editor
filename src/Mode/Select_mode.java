package Mode;

import Items.UML_item;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.awt.event.MouseEvent;

public class Select_mode extends Basic_mode{
    // variables
    Point from, to, offset;
    UML_item moving_item;
    UML_item selected_region;

    // override functions

    @Override
    public void mouseClicked(MouseEvent e) {
        get_canvas().clear_selected_items();
        get_canvas().add_selected_item(get_canvas().get_inside_item(e.getPoint()));
        get_canvas().repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        get_canvas().clear_selected_items();

        moving_item = get_canvas().get_inside_item(e.getPoint());
        from = e.getPoint();
        selected_region = new Region();

        get_canvas().add_selected_item(get_canvas().get_inside_item(e.getPoint()));
        if(moving_item != null)
            offset = new Point( moving_item.get_from().x - e.getX(), moving_item.get_from().y - e.getY());
        else
            get_canvas().add_uml_item(selected_region);

        get_canvas().repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        to = e.getPoint();
        if(moving_item != null){
            moving_item.move(new Point(to.x + offset.x, to.y + offset.y));
        } else {
            // selected_region.set_region(from, to);
            selected_region.set_from(new Point(Math.min(from.x, to.x), Math.min(from.y, to.y)));
            selected_region.set_to(new Point(Math.max(from.x, to.x), Math.max(from.y, to.y)));

            get_canvas().clear_selected_items();
            for(UML_item item : get_canvas().get_uml_items())
                if(item.is_surrounded(from, to))
                    get_canvas().add_selected_item(item);
        }
        get_canvas().repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        from = null;
        to = null;
        moving_item = null;
        get_canvas().remove_uml_item(selected_region);
        selected_region = null;
        get_canvas().repaint();
    }

    private class Region extends UML_item{
        // variables
        // constructor
        // functions
        // override functions
        @Override
        public void draw(Graphics g) {
            if(get_from() == null || get_to() == null)
                return;
            g.setColor(new Color(0, 0, 0, 30));
            g.fillRect( get_from().x, get_from().y, get_to().x - get_from().x, get_to().y - get_from().y);
            g.setColor(Color.BLACK);
        }
        // setter
        // getter
    }
}
