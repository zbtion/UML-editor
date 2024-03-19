package Items;


import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;

import java.util.ArrayList;
import java.util.List;

public class Composite_container extends UML_item{

    // variables
    private final List<UML_item> items;
    // constructors
    public Composite_container(List<UML_item> items){
        this.items = items;
        //set something
        set_from(calculate_from());
        set_to(calculate_to());
    }
    // functions
    private Point calculate_from(){
        Point from = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for(UML_item item : items){
            if(item.get_from().x < from.x)
                from.x = item.get_from().x;
            if(item.get_from().y < from.y)
                from.y = item.get_from().y;
        }
        return from;
    }
    private Point calculate_to(){
        Point to = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for(UML_item item : items){
            if(item.get_to().x > to.x)
                to.x = item.get_to().x;
            if(item.get_to().y > to.y)
                to.y = item.get_to().y;
        }
        return to;
    }
    // override functions
    @Override
    public void draw(Graphics g) {
        for(UML_item item : items)
            item.draw(g);
    }
    @Override
    public boolean is_inside(Point p) {
        boolean in_x_range = get_from().x <= p.x && p.x <= get_from().x + get_edge_length();
        boolean in_y_range = get_from().y <= p.y && p.y <= get_from().y + get_edge_length();
        return in_x_range && in_y_range;
    }
    @Override
    public void draw_selected(Graphics g) {
        g.setColor(new Color(0, 0, 0, 30));
        g.fillRect( get_from().x, get_from().y, get_edge_length(), get_edge_length());
        g.setColor(Color.BLACK);
    }

    @Override
    public List<UML_item> get_items() {
        return new ArrayList<>(items);
    }

    @Override
    public void move(Point new_from) {
        for(UML_item item : items){
            Point offset = new Point( get_from().x-item.get_from().x,
                                        get_from().y-item.get_from().y);
            item.move(new Point(new_from.x - offset.x, new_from.y - offset.y));
        }
        set_to(calculate_to());
        set_from(new_from);
    }

    // getter
    public int get_edge_length(){
        return Math.max( get_to().x - get_from().x, get_to().y - get_from().y );
    }
}
