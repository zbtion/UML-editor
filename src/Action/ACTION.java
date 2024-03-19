package Action;

public enum ACTION {
    GROUP(new Group_action()),
    UNGROUP(new Ungroup_action()),
    CHANGE_OBJECT_NAME(new Change_object_name_action());
    private final Basic_action action;
    ACTION(Basic_action action){
        this.action = action;
    }
    public Basic_action get_action(){
        return action;
    }

}
