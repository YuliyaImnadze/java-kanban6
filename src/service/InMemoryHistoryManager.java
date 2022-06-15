package service;

import task.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {


    private List<Task> listHistory = new ArrayList<>();
    private HashMap<Integer, Node> customLinkedList = new HashMap<>(); // новый хэшмэп

    private Node first;
    private Node last;
    private int size = 0;


  /*  @Override
    public void add(Task task) {

        if (listHistory.size() == LIST_SIZE) {
            listHistory.remove(0);
        }
        if (task != null) {
            listHistory.add(task);
        }
    } */

    @Override
    public void add(Task task) {
        if (customLinkedList.containsKey(task.getId())) {
            removeNode(customLinkedList.get(task.getId()));
            customLinkedList.remove(task.getId());
            size--;
        }
        Node nodeAdded = linkLast(task); //После добавления задачи не забудьте обновить значение узла в HashMap.
        customLinkedList.put(task.getId(), nodeAdded);
    }


    public Node linkLast(Task task) { // добавлять задачу в конец списка
        final Node secondLast = last;
        final Node newNode = new Node(secondLast, task, null);
        last = newNode;
        if (secondLast != null) {
            secondLast.next = newNode;
        } else {
            first = newNode;
        }
        size++;
        return newNode;
    }


    public List<Task> getTasks() { // собирать все задачи из списка в обычный ArrayList
        List<Task> allListHistory = new ArrayList<>(); // другой лист???
        Node node = customLinkedList.get(1);
        while (node != null) {
            allListHistory.add(node.value);
            node = node.next;
        }
        return allListHistory;
    }


    public void removeNode(Node value) { //  В качестве параметра этот метод должен принимать объект Node — узел связного списка и вырезать его.
        if (value.previous != null) {
            value.previous.next = value.next;
                if (value.next != null) {
                    value.next.previous = value.previous;
                }
        }
}

    @Override
    public List<Task> getHistory() {
        listHistory = getTasks();
        return listHistory;
    }

    public void remove(int id) {
        if (customLinkedList.containsKey(id)) {
            removeNode(customLinkedList.get(id));
            customLinkedList.remove(id);
            size--;
        }
    }


private static class Node {
    private Node previous;
    private Task value;
    private Node next;

    public Node(Node previous, Task value, Node next) {
        this.previous = previous;
        this.value = value;
        this.next = next;
    }

}
}

