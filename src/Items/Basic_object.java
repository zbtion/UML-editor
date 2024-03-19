package Items;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Basic_object extends UML_item{
    // variables
    Port north, south, east, west;
    private final int port_offset = 5;

    // constructor
    public Basic_object(Point from){
        int width = 80, height = 80;

        set_from(from);
        set_to(new Point(from.x + width, from.y + height));

        create_ports();
    }

    // functions
    public void create_ports(){
        north = new Port(new Point(get_from().x + get_width()/2, get_from().y - port_offset));
        south = new Port(new Point(get_from().x + get_width()/2, get_to().y + port_offset));
        east = new Port(new Point(get_to().x + port_offset, get_from().y + get_height()/2));
        west = new Port(new Point(get_from().x - port_offset, get_from().y + get_height()/2));
    }
    public void show_ports(Graphics g){
        north.draw(g);
        south.draw(g);
        east.draw(g);
        west.draw(g);
    }
    public void move_ports(){
        north.move(new Point(get_from().x + get_width()/2, get_from().y - port_offset));
        south.move(new Point(get_from().x + get_width()/2, get_to().y + port_offset));
        east.move(new Point(get_to().x + port_offset, get_from().y + get_height()/2));
        west.move(new Point(get_from().x - port_offset, get_from().y + get_height()/2));
    }
    // abstract functions
    public abstract void draw(Graphics g);
    // override functions
    @Override
    public boolean is_inside(Point p) {
        boolean in_x_range = (get_from().x <= p.x && p.x <= get_to().x);
        boolean in_y_range = (get_from().y <= p.y && p.y <= get_to().y);
        return in_x_range && in_y_range;
    }
    @Override
    public Port get_nearest_port(Point p) {
        Port nearest_port = north;
        double min_distance = calculate_distance(p, north.get_center());
        if(min_distance > calculate_distance(p, south.get_center())){
            nearest_port = south;
            min_distance = calculate_distance(p, south.get_center());
        }
        if(min_distance > calculate_distance(p, east.get_center())){
            nearest_port = east;
            min_distance = calculate_distance(p, east.get_center());
        }
        if(min_distance > calculate_distance(p, west.get_center())){
            nearest_port = west;
        }
        return nearest_port;
    }
    private double calculate_distance(Point p1, Point p2){      // calculate distance between two points
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y,2));
    }
    @Override
    public void draw_selected(Graphics g) {
        show_ports(g);
    }

    @Override
    public void move(Point new_from) {
        set_to(new Point(new_from.x + get_width(), new_from.y + get_height()));
        set_from(new_from);
        move_ports();
    }

    // setter
    // getter
    public int get_width(){
        return Math.abs(get_from().x - get_to().x);
    }
    public int get_height(){
        return Math.abs(get_from().y - get_to().y);
    }
    public int get_top(){
        return Math.min(get_from().y, get_to().y);
    }
    public int get_left(){
        return Math.min(get_from().x, get_to().x);
    }
    public int get_right(){
        return Math.max(get_from().x, get_to().x);
    }
}
