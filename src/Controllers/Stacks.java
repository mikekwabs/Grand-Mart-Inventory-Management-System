package Controllers;

//stack implementation
import java.util.Vector;

public class Stacks {
    public Vector<String> items;

    public Stacks() {
        items = new Vector<>();
    }

    public boolean isEmpty() {
        if (items.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public String peek() {
        String top = items.get(items.size() - 1);
        return top;
    }

    public String pop(String a, String b, String c, String d) {
        String top = items.remove(items.size() - 1);
        return top;
    }

    public void push(String item, String string, String string2, String string3) {
        items.add(item + "  " + string + "  " + string2 + "  " + string3);
    }

}
