import java.util.ArrayList;
import java.util.HashMap;


public class Manager {
    private Integer ID = 0;
    private final HashMap<Integer, Task> tasks = new HashMap<>();
    private final HashMap<Integer, Epic> epics = new HashMap<>();
    private final HashMap<Integer, Subtask> subTasks = new HashMap();


    Task addTask(String name, String description) {
        ID++;
        Task task = new Task(name, description);
        task.setId(ID);
        tasks.put(task.getId(), task);
        return task;
    }

    public void getTasks() {
       for(Task task : tasks.values()){
           System.out.println(task);
       }
    }

    public void getTaskById(Task task) {
        System.out.println(tasks.get(task.getId()));
    }

    public void updateTask(Integer id, Task newTask) {
        Task task = tasks.get(id);
        if (task == null) {
            System.out.println("Нет задачи с таким ID");
            return;
        }
        newTask.setId(id);
        tasks.put(id, newTask);
    }

    public void deleteTaskById(Integer id) {
        tasks.remove(id);
    }

    public void deleteTasks() {
        tasks.clear();
    }

    public Epic addEpic(String name, String description) {
        ID++;
        Epic epic = new Epic(name, description);
        epic.setId(ID);
        epics.put(epic.getId(), epic);
        return epic;
    }

    public void getEpics() {
        for (Epic epic : epics.values()) {
            epics.get(epic);
        }
    }

    public void getEpicById(Epic epic) {
        System.out.println(epics.get(epic.getId()));
    }

    public void updateEpic(Integer id, Epic newEpic) {
        Epic epic = epics.get(id);
        if (epic == null) {
            System.out.println("Нет задачи с таким ID");
            return;
        }
        newEpic.setId(id);
        tasks.put(id, newEpic);
    }

    public void deleteEpicById(Integer id) {
        tasks.remove(id);
    }

    public void deleteEpics() {
        tasks.clear();
    }

    public Subtask addSubTask(String name, String description, Integer epicId) {
        ID++;
        Subtask subtask = new Subtask(name, description, epicId);
        subtask.setId(ID);
        subTasks.put(subtask.getId(), subtask);
        Epic epic = epics.get(epicId);
        epic.addSubtaskIdInEpic(subtask.getId());
        epics.put(epicId, epic);
        return subtask;
    }
    public void getSubTask(){
        for (Subtask subtask : subTasks.values()) {
            subTasks.get(subtask);
        }
    }

    public void printSubtasksForEpic(Epic epic) {
        ArrayList<Integer> listIdSubtasks = epic.getListSubtaskId();
        for (Integer listIdSubtask : listIdSubtasks) {
            System.out.println(subTasks.get(listIdSubtask));
        }
    }

    public void getSubtaskById(Integer idSubtask){
        System.out.println(subTasks.get(idSubtask));
    }
    public void updateSubtask(Integer id, Subtask newSubtask){
        Subtask subtask = subTasks.get(id);
        if (subtask == null) {
            System.out.println("Нет задачи с таким ID");
            return;
        }
        newSubtask.setId(id);
        subTasks.put(id, newSubtask);
    }

    public void deleteSubtaskById(Subtask subtask) {
        Epic epic = epics.get(subtask.getEpicId());
        epic.removeSubtaskIdInEpic(subtask.getEpicId());
        epics.put(epic.getId(), epic);
        subTasks.remove(subtask.getId());
    }

    public void deleteSubtasks() {
        subTasks.clear();
    }


    public void changeStatusEpicAndSubtask(Task task, Status status) {
        task.setStatus(status);
    }

    public void changeStatusEpicAndSubtask(Subtask subtask, Epic epic, Status subtaskStatus) {
        if (subtaskStatus == Status.DONE) {
            epic.setStatus(Status.DONE);
        } else {
            subtask.setStatus(Status.IN_PROGRESS);
            epic.setStatus(Status.IN_PROGRESS);
        }
    }


}
