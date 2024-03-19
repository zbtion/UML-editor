package Items;

import java.awt.Point;
import java.awt.Graphics;
import java.util.List;

public abstract class UML_item {
    // variables
    private Point from, to;
    private String name = "Object Name";

    // abstract functions
    public abstract void draw(Graphics g);

    // Composite Pattern
    public void move(Point p){}
    public void draw_selected(Graphics g){}
    public boolean is_inside(Point p){
        return false;
    }
    public Port get_nearest_port(Point p){
        return null;
    }
    public List<UML_item> get_items(){
        return null;
    }


    // functions
    public boolean is_surrounded(Point from, Point to){
        boolean surrounded_by_x = Math.min(from.x, to.x) < this.from.x && this.to.x < Math.max(from.x, to.x);
        boolean surrounded_by_y = Math.min(from.y, to.y) < this.from.y && this.to.y < Math.max(from.y, to.y);
        return surrounded_by_x && surrounded_by_y;
    }

    // setter
    public void set_from(Point from) {
        this.from = from;
    }
    public void set_to(Point to) {
        this.to = to;
    }
    public void set_name(String name) {
        this.name = name;
    }

    // getter
    public Point get_from() {
        return from;
    }
    public Point get_to() {
        return to;
    }
    public String get_name() {
        return name;
    }


}
