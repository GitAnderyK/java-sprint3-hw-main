public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        System.out.println("Получение списка всех задач");
        Task task1 =  manager.addTask("Задача 1", "Описание 1");
        Task task2 = manager.addTask("Задача 2", "Описание 2");
        Epic epic1 = manager.addEpic("Эпик 1","Описание эпика 1");
        Subtask subtask = manager.addSubTask("Подзадача 1, Эпика 1", "Описание подзадачи 1", epic1.getId());
        Subtask subtask1 = manager.addSubTask("Подзадача 2, Эпика 1", "Описание подзадачи 2", epic1.getId());
        Epic epic2 = manager.addEpic("Эпик 2","Описание эпика 2");
        Subtask subtask2 = manager.addSubTask("Подзадача 1, Эпика 2", "Описание подзадачи 1", epic2.getId());
        System.out.println(manager.getTasks());
        System.out.println(manager.getEpics());
        System.out.println(manager.getSubTask());

        System.out.println("Получение по идентификатору!");
        System.out.println(manager.getTaskById(task2));
        System.out.println(manager.getEpicById(epic1));
        System.out.println(manager.getSubtaskById(subtask2));
        manager.printSubtasksForEpic(epic1);

        System.out.println("Обновление задач");
        manager.updateTask(1,"Задача New", "Описание New");
        manager.updateSubtask(5,"Подзадача New", "Описание подзадачи New");
        manager.updateEpic(6,"Эпик New","Описание New");
        System.out.println(manager.getTasks());
        System.out.println(manager.getEpics());
        System.out.println(manager.getSubTask());


        System.out.println("Управление статусами");
        manager.changeStatusSubtask(subtask1, Status.DONE);
        manager.changeStatusSubtask(subtask, Status.DONE);
        manager.changeStatusTask(task2, Status.IN_PROGRESS);
        System.out.println(manager.getTasks());
        System.out.println(manager.getEpics());
        System.out.println(manager.getSubTask());

        System.out.println("Удаление по идентификатору.");
        manager.deleteTaskById(task2);
        manager.deleteSubtaskById(subtask);
        manager.deleteEpicById(epic2);
        System.out.println(manager.getTasks());
        System.out.println(manager.getEpics());
        System.out.println(manager.getSubTask());

        System.out.println("Удаление всех задач.");
        manager.deleteEpics();
        manager.deleteSubtasks();
        manager.deleteTasks();
        System.out.println(manager.getTasks());
        System.out.println(manager.getEpics());
        System.out.println(manager.getSubTask());
    }
}
