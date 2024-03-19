package Items;

import java.awt.Point;

public enum OBJECT{
    CLASS, USECASE;
    private Basic_object object;
    public Basic_object get_object(Point point){
        switch (this) {
            case CLASS -> object = new Class_object(point);
            case USECASE -> object = new Use_case_object(point);
        }
        return object;
    }
}
