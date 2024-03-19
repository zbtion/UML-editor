package Items;

import java.awt.Point;
import java.awt.Graphics;

public class Port{
    // variables
    private final int width = 10;
    private final int height = 10;
    private Point center;
    // functions
    public Port(Point center){
        this.center = center;
    }
    public void move(Point center){
        this.center = center;
    }
    public void draw(Graphics g){
        g.fillRect(center.x - width/2, center.y - height/2, width, height);
    }
    // getter
    public Point get_center(){
        return center;
    }

}
