package Items;

import java.awt.Point;
import java.awt.Graphics;
import java.awt.Font;

public class Class_object extends Basic_object{

    //variable
    //constructor
    public Class_object(Point from){
        super(from);
    }
    //function
    @Override
    public void draw(Graphics g){
        g.drawRect(get_left(), get_top(), get_width(), get_height());

        int portion = get_height() / 3;

        g.drawLine(get_left(), get_top() + portion, get_right(), get_top() + portion);
        g.drawLine(get_left(), get_top() + portion*2, get_right(), get_top() + portion*2);

        Font font = new Font(Font.DIALOG, Font.BOLD,10);
        int name_width = g.getFontMetrics(font).stringWidth(get_name());
        int margin = (Math.abs(get_left()-get_right()) - name_width)/2;

        g.setFont(font);
        g.drawString(get_name(), get_left() + margin, get_top() + get_height()/6);
    }
}
