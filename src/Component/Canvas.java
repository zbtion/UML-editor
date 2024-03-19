package Component;

import Items.UML_item;

import Mode.MODE;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Point;

import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel{
    // variables
    private volatile static Canvas instance = null;
    private final List<UML_item> uml_items = new ArrayList<>();
    private final List<UML_item> selected_items = new ArrayList<>();
    private MODE current_mode = MODE.SELECT;

    // constructor
    private Canvas(){}
    public static Canvas get_instance(){
        if(instance == null)
            synchronized (Canvas.class){
                if(instance == null)
                    instance = new Canvas();
            }
        return instance;
    }
    // functions
    public void add_uml_item(UML_item item){
        if(item != null)
            uml_items.add(item);
    }
    public void remove_uml_item(UML_item item){
        if(item != null)
            uml_items.remove(item);
    }
    public void add_selected_item(UML_item item){
        if (item != null)
            selected_items.add(item);
    }
    public void clear_selected_items(){
        selected_items.clear();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (UML_item item : uml_items)
            item.draw(g);
        for (UML_item item : selected_items)
            item.draw_selected(g);
    }

    // setter
    public void set_mode(MODE mode){
        removeMouseListener(current_mode.get_current_mode());
        removeMouseMotionListener(current_mode.get_current_mode());

        current_mode = mode;

        addMouseListener(current_mode.get_current_mode());
        addMouseMotionListener(current_mode.get_current_mode());
    }

    // getter
    public UML_item get_inside_item(Point point){
        for(int i = uml_items.size() - 1; i >= 0; i--)
            if(uml_items.get(i).is_inside(point))
                return uml_items.get(i);
        return null;
    }
    public List<UML_item> get_selected_items(){
        if(selected_items.size() == 0)
            return null;
        return new ArrayList<>(selected_items);
    }
    public List<UML_item> get_uml_items(){
        if(uml_items.size() == 0)
            return null;
        return new ArrayList<>(uml_items);
    }
}
