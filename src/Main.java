public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        System.out.println("Получение списка всех задач");
        Task task1 =  manager.addTask("Задача 1", "Описание 1");
        Task task2 = manager.addTask("Задача 2", "Описание 2");
        Epic epic1 = manager.addEpic("Эпик 1","Описание эпика 1");
        Subtask subtask = manager.addSubTask("Подзадача 1", "Описание подзадачи 1", epic1.getId());
        Subtask subtask1 = manager.addSubTask("Подзадача 2", "Описание подзадачи 2", epic1.getId());
        Epic epic2 = manager.addEpic("Эпик 2","Описание эпика 2");
        Subtask subtask2 = manager.addSubTask("Подзадача 1", "Описание подзадачи 1", epic2.getId());
        manager.getTasks();
        manager.getEpics();
        manager.getSubTask();

        System.out.println("Получение по идентификатору!");
        manager.getTaskById(task1);
        manager.getEpicById(epic1);
        manager.printSubtasksForEpic(epic1);
        System.out.println("Обновление задач");
        manager.updateTask(task1.getId(),task2);
        manager.getTasks();
        manager.updateSubtask(subtask.getId(),subtask2);
        manager.getSubTask();
        manager.updateEpic(epic1.getId(),epic2);
        manager.getEpics();

        System.out.println("Управление статусами");
        manager.changeStatusEpicAndSubtask(subtask1,epic1,subtask1.getStatus());
        manager.changeStatusEpicAndSubtask(task1,Status.DONE);

        System.out.println("Получение по идентификатору!");
        manager.getTaskById(task2);
        manager.getEpicById(epic1);
        manager.getSubtaskById(subtask2.getId());

        System.out.println("Удаление по идентификатору.");
        manager.deleteTaskById(task2.getId());
        manager.getTasks();
        manager.deleteEpicById(epic2.getId());
        manager.getEpics();
        manager.deleteSubtaskById(subtask);

        System.out.println("Удаление всех задач.");
        manager.deleteEpics();
        manager.getEpics();
        manager.deleteSubtasks();
        manager.deleteTasks();
        manager.getTasks();
    }
}
