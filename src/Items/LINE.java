package Items;

public enum LINE {
    ASSOCIATION, GENERALIZATION, COMPOSITION;

    private Connection_line line;
    public Connection_line get_line(Port start, Port end){
        switch (this) {
            case ASSOCIATION -> line = new Association_line(start, end);
            case GENERALIZATION -> line = new Generalization_line(start, end);
            case COMPOSITION -> line = new Composition_line(start, end);
        }
        return line;
    }
}
