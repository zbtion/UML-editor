package Action;

import Component.Canvas;

import java.awt.event.ActionListener;

public abstract class Basic_action implements ActionListener {
    public Canvas get_canvas(){
        return Canvas.get_instance();
    }
}
