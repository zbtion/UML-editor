package Action;

import Items.UML_item;

import java.awt.event.ActionEvent;
import java.util.List;

public class Ungroup_action extends Basic_action{
    @Override
    public void actionPerformed(ActionEvent e) {
        List<UML_item> selected_items = get_canvas().get_selected_items();
        if(selected_items.size() == 1){
            UML_item group = selected_items.get(0);
            if(group.get_items() != null){       // if item is a composite container
                for(UML_item item : group.get_items())
                    get_canvas().add_uml_item(item);
                get_canvas().remove_uml_item(group);
            } else {
                Invalid_window window = new Invalid_window("Please select a group to ungroup.");
            }
        } else {
            Invalid_window window = new Invalid_window("Please select only one item to ungroup.");
        }
        get_canvas().clear_selected_items();
        get_canvas().repaint();
    }
}
