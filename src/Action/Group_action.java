package Action;

import Items.Composite_container;
import Items.UML_item;

import java.util.ArrayList;
import java.util.List;

import java.awt.event.ActionEvent;
public class Group_action extends Basic_action{
    @Override
    public void actionPerformed(ActionEvent e) {
        List<UML_item> selected_items = get_canvas().get_selected_items();
        if(selected_items.size() > 1){
            UML_item group = new Composite_container(new ArrayList<>(selected_items));
            get_canvas().add_uml_item(group);
            for(UML_item item : selected_items)
                get_canvas().remove_uml_item(item);
        } else {
            Invalid_window window = new Invalid_window("Please select more than one item to group.");
        }
        get_canvas().clear_selected_items();
        get_canvas().repaint();
    }
}
