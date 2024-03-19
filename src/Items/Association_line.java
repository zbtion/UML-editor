package Items;

import java.awt.Graphics;
import java.awt.Point;

public class Association_line extends Connection_line{

    public Association_line(Port start, Port end){
        super(start, end);
    }
    @Override
    public void draw_arrow(Graphics g) {
        double length = get_length();

        if(length < get_arrow_size())
            length = get_arrow_size() + 1;
        
        Point middle = new Point((int)((get_to().x * (length-get_arrow_size()) + get_from().x * get_arrow_size()) / length),
                                (int)((get_to().y * (length-get_arrow_size()) + get_from().y * get_arrow_size()) / length));

        g.drawLine(get_to().x, get_to().y,
                middle.x-(get_to().y- middle.y), middle.y+(get_to().x- middle.x));
        g.drawLine(get_to().x, get_to().y,
                middle.x+(get_to().y- middle.y), middle.y-(get_to().x- middle.x));
    }
}
