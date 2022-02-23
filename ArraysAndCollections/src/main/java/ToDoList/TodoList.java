package ToDoList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoList {

    private ArrayList<String> myTodoList;

    public TodoList() {
        myTodoList = new ArrayList<>();
    }

    public void add(String todo) {
        myTodoList.add(todo);
        System.out.println("To-do added: " + "\"" + todo + "\"");
    }

    public void add(int index, String todo) {

        int sizeMyTodoList = myTodoList.size();

        if (index < 0 || index > sizeMyTodoList) {
            add(todo);
        } else {
            myTodoList.add(index, todo);
            System.out.println("To-do added: " + "\"" + todo + "\"" + " to index " + index);
        }
    }

    public void edit(String todo, int index) {

        if (index < 0 || index > myTodoList.size()) {
            System.out.println("Error. Index must be greater than 0 and less than the size of the list, " +
                    "which is now equal:  " + myTodoList.size());
        } else {
            System.out.println("To-do " + "\"" + myTodoList.get(index) + "\"" + "changed to " +
                    "\"" + todo + "\"");
            myTodoList.set(index, todo);
        }
    }

    public void delete(int index) {

        if (index >= myTodoList.size() || index < 0) {
            System.out.println("To-do with this number does not exist");
        } else {
            System.out.println("To-do " + "\"" + myTodoList.get(index) + "\"" + " deleted");
            myTodoList.remove(index);
        }
    }

    public List<String> getTodos() {
        return Collections.unmodifiableList(myTodoList);
    }
}