package Mode;

import Component.Canvas;

import java.awt.event.MouseAdapter;

public abstract class Basic_mode extends MouseAdapter {

    public Canvas get_canvas(){
        return Canvas.get_instance();
    }
}
