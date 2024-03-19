package Items;

import java.awt.Graphics;
import java.awt.Point;

public class Composition_line extends Connection_line{

    public Composition_line(Port start, Port end){
        super(start, end);
    }
    @Override
    public void draw_arrow(Graphics g) {
        double length = get_length();

        if(length < get_arrow_size())
            length = get_arrow_size() + 1;

        Point middle = new Point((int)((get_to().x * (length-get_arrow_size()) + get_from().x * get_arrow_size()) / length),
                (int)((get_to().y * (length-get_arrow_size()) + get_from().y * get_arrow_size()) / length));

        int[] x_poly = new int[]{ get_to().x, middle.x-(get_to().y- middle.y), 2*middle.x-get_to().x, middle.x+(get_to().y- middle.y)};
        int[] y_poly = new int[]{ get_to().y, middle.y+(get_to().x- middle.x), 2*middle.y-get_to().y, middle.y-(get_to().x- middle.x)};

        g.fillPolygon(x_poly, y_poly, 4);

    }
}
