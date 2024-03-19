package Items;

import java.awt.*;

public class Generalization_line extends Connection_line{

    public Generalization_line(Port start, Port end){
        super(start, end);
    }

    @Override
    public void draw(Graphics g) {
        double length = get_length();
        Point middle = new Point((int)((get_to().x * (length-get_arrow_size()) + get_from().x * get_arrow_size()) / length),
                (int)((get_to().y * (length-get_arrow_size()) + get_from().y * get_arrow_size()) / length));
        g.drawLine(get_from().x, get_from().y, middle.x, middle.y);
        draw_arrow(g);
    }

    @Override
    public void draw_arrow(Graphics g) {
        double length = get_length();

        if(length < get_arrow_size())
            length = get_arrow_size() + 1;

        Point middle = new Point((int)((get_to().x * (length-get_arrow_size()) + get_from().x * get_arrow_size()) / length),
                (int)((get_to().y * (length-get_arrow_size()) + get_from().y * get_arrow_size()) / length));

        int[] x_poly = new int[]{ get_to().x, middle.x-(get_to().y- middle.y), middle.x+(get_to().y- middle.y)};
        int[] y_poly = new int[]{ get_to().y, middle.y+(get_to().x- middle.x), middle.y-(get_to().x- middle.x)};

        g.drawPolygon(x_poly, y_poly, 3);

    }
}
