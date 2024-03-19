package Items;

import java.awt.Graphics;
import java.awt.Point;


public abstract class Connection_line extends UML_item{
    // variables
    private Port start, end;
    private final int arrow_size = 10;

    // constructor
    public Connection_line(Port start, Port end){
        set_start(start);
        set_end(end);
        set_from(start.get_center());
        set_to(end.get_center());
    }

    // functions

    // abstract functions
    public abstract void draw_arrow(Graphics g);

    // override functions
    @Override
    public void draw(Graphics g){
        g.drawLine( get_from().x, get_from().y, get_to().x, get_to().y);
        draw_arrow(g);
    }
    @Override
    public boolean is_surrounded(Point from, Point to) {
        return false;
    }

    // setter
    public void set_start(Port start){
        this.start = start;
        set_from(start.get_center());
    }
    public void set_end(Port end){
        this.end = end;
        set_to(end.get_center());
    }
    // getter
    @Override
    public Point get_from() {
        super.set_from(get_start().get_center());
        return super.get_from();
    }
    @Override
    public Point get_to() {
        super.set_to(get_end().get_center());
        return super.get_to();
    }

    public Port get_start(){
        return start;
    }
    public Port get_end(){
        return end;
    }
    public int get_arrow_size(){
        return arrow_size;
    }
    public double get_length(){
        return  Math.sqrt(Math.pow(get_to().x - get_from().x, 2)
                + Math.pow(get_to().y - get_from().y, 2));
    }
}
