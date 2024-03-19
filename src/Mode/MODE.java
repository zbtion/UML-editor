package Mode;

import Items.LINE;
import Items.OBJECT;

public enum MODE {
    SELECT(new Select_mode()),
    ASSOCIATION(new Connect_mode(LINE.ASSOCIATION)),
    GENERALIZATION(new Connect_mode(LINE.GENERALIZATION)),
    COMPOSITION(new Connect_mode(LINE.COMPOSITION)),
    CLASS(new Create_mode(OBJECT.CLASS)),
    USECASE(new Create_mode(OBJECT.USECASE));
    private final Basic_mode current_mode;
    MODE(Basic_mode current_mode){
        this.current_mode = current_mode;
    }
    public Basic_mode get_current_mode(){
        return current_mode;
    }
}
