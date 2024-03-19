package Items;

import java.awt.Point;
import java.awt.Graphics;
import java.awt.Font;

public class Use_case_object extends Basic_object{
    //variable
    //constructor
    public Use_case_object(Point from){
        super(from);
    }

    //function
    public void draw(Graphics g){
        g.drawOval(get_left(), get_top(), get_width(), get_height());

        Font font = new Font(Font.DIALOG, Font.BOLD,10);
        int name_width = g.getFontMetrics(font).stringWidth(get_name());
        int margin = (Math.abs(get_left()-get_right()) - name_width)/2;

        g.setFont(font);
        g.drawString(get_name(), get_left() + margin, get_top() + get_height()/2);
    }
}
