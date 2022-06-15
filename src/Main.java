import task.Task;
import task.TaskStatus;
import task.sub.Epic;
import task.sub.SubTask;
import service.*;

public class Main {
    public static void main(String[] args) {

        TaskManager inMemoryTaskManager = Managers.getDefault();

        inMemoryTaskManager.createTask(new Task("Таск 1", TaskStatus.NEW, "Доделать тз"));
        inMemoryTaskManager.createTask(new Task("Таск 2", TaskStatus.NEW, "Купить еды"));

        inMemoryTaskManager.createEpic(new Epic("Эпик 1", TaskStatus.NEW, "Покупка квартиры"));
        inMemoryTaskManager.createEpic(new Epic("Эпик 2", TaskStatus.NEW, "Продажа дачи"));

        inMemoryTaskManager.addSubTask(new SubTask("Сабтаск 1", TaskStatus.NEW, "---", 3));
        inMemoryTaskManager.addSubTask(new SubTask("Сабтаск 2", TaskStatus.NEW, "---", 3));
        inMemoryTaskManager.addSubTask(new SubTask("Сабтаск 3", TaskStatus.NEW, "---", 3));

inMemoryTaskManager.getTaskByID(1);
inMemoryTaskManager.getTaskByID(2);
inMemoryTaskManager.getEpicByID(3);
inMemoryTaskManager.getTaskByID(1);
inMemoryTaskManager.getTaskByID(2);
inMemoryTaskManager.getEpicByID(4);
inMemoryTaskManager.getSubtaskByID(5);
inMemoryTaskManager.getSubtaskByID(5);
inMemoryTaskManager.getSubtaskByID(7);

inMemoryTaskManager.deleteEpicById(3);

        System.out.println(inMemoryTaskManager.getHistory());
    }
}