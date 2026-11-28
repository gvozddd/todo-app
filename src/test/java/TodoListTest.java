import org.example.TodoList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodoListTest {

    @Test
    void addAndList() {
        TodoList t = new TodoList();
        t.add(" task1 ");
        assertEquals(1, t.size());
        assertEquals("task1", t.getAll().getFirst());
    }

    @Test
    void remove() {
        TodoList t = new TodoList();
        t.add("a");
        t.add("b");
        assertTrue(t.remove(0));
        assertEquals(1, t.size());
        assertFalse(t.remove(10));
    }

    @Test
    void addEmptyIgnored() {
        TodoList t = new TodoList();
        t.add(" ");
        assertEquals(0, t.size());
    }


    @Test
    void testClear() {
        TodoList t = new TodoList();
        t.add("Задача 1");
        t.add("Задача 2");

        t.clear();

        assertEquals(0, t.size(), "После очистки размер списка должен быть 0");
        assertTrue(t.getAll().isEmpty(), "Список должен быть пустым");
    }

    @Test
    void testMarkDone() {
        TodoList t = new TodoList();
        t.add("Купить молоко");

        boolean result = t.markDone(0);

        assertTrue(result, "Метод должен вернуть true при успешной отметке");
        assertTrue(t.getAll().get(0).startsWith("[x]"), "Задача должна начинаться с [x]");
    }

    @Test
    void testMarkDoneInvalidIndex() {
        TodoList t = new TodoList();
        t.add("Задача");

        assertFalse(t.markDone(10), "Метод должен вернуть false для несуществующего индекса");
        assertFalse(t.markDone(-1), "Метод должен вернуть false для отрицательного индекса");
    }

    @Test
    void testSearch() {
        TodoList t = new TodoList();
        t.add("Купить хлеб");
        t.add("Купить машину");
        t.add("Помыть окна");


        List<String> found = t.search("Купить");
        assertEquals(2, found.size(), "Должно найтись две задачи со словом 'Купить'");

        List<String> notFound = t.search("Самолет");
        assertTrue(notFound.isEmpty(), "Поиск не должен ничего найти");
    }
}