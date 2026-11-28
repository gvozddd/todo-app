package org.example;
import java.util.ArrayList;
import java.util.List;
public class TodoList {
    private final List<String> items = new ArrayList<>();

    public void add(String item) {
        if (item != null) {
            item = item.trim();
            if (!item.isEmpty()) {
                items.add(item);
            }
        }
    }

    public boolean remove(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            return true;
        }
        return false;
    }

    public List<String> getAll() {
        return new ArrayList<>(items);
    }

    public int size() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }


    public boolean markDone(int index) {
        if (index >= 0 && index < items.size()) {
            String task = items.get(index);
            if (!task.startsWith("[x]")) {
                items.set(index, "[x] " + task);
            }
            return true;
        }
        return false;
    }

    public List<String> search(String query) {
        List<String> result = new ArrayList<>();
        for (String task : items) {
            if (task.toLowerCase().contains(query.toLowerCase())) {
                result.add(task);
            }
        }
        return result;
    }
}


