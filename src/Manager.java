import java.util.ArrayList;
import java.util.HashMap;


public class Manager {
    private Integer ID = 0;
    private final HashMap<Integer, Task> tasks = new HashMap<>();
    private final HashMap<Integer, Epic> epics = new HashMap<>();
    private final HashMap<Integer, Subtask> subTasks = new HashMap();


    public Task addTask(String name, String description) {
        ID++;
        Task task = new Task(name, description);
        task.setId(ID);
        tasks.put(task.getId(), task);
        return task;
    }

    public ArrayList<Task> getTasks() {
       return new ArrayList<>(tasks.values());
    }

    public Task getTaskById(Task task) {
        return tasks.get(task.getId());
    }

    public void updateTask(Integer id, String newName, String newDescription) {
        Task task = tasks.get(id);
        if (task != null) {
            tasks.get(id).setName(newName);
            tasks.get(id).setDescription(newDescription);
        } else {
            System.out.println("Нет задачи с таким ID");
        }
    }

    public void deleteTaskById(Task task) {
        tasks.remove(task.getId());
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

    public ArrayList<Epic> getEpics() {
            return new ArrayList<>(epics.values());
    }

    public Epic getEpicById(Epic epic) {
        return epics.get(epic.getId());
    }

    public void updateEpic(Integer id, String newName, String newDescription) {
        Epic epic = epics.get(id);
        if (epic != null) {
            epics.get(id).setName(newName);
            epics.get(id).setDescription(newDescription);
        } else {
            System.out.println("Нет задачи с таким ID");
        }
    }

    public void deleteEpicById(Epic epic) {
        epics.remove(epic.getId());
    }

    public void deleteEpics() {
        epics.clear();
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

    public ArrayList<Subtask> getSubTask(){
        return new ArrayList<>(subTasks.values());
    }

    public void printSubtasksForEpic(Epic epic) {
        ArrayList<Integer> listIdSubtasks = epic.getListSubtaskId();
        for (Integer listIdSubtask : listIdSubtasks) {
            System.out.println(subTasks.get(listIdSubtask));
        }
    }

    public Subtask getSubtaskById(Subtask subtask){
        return subTasks.get(subtask.getId());
    }

    public void updateSubtask(Integer id, String newName, String newDescription) {
        Subtask subtask = subTasks.get(id);
        if (subtask != null) {
            subTasks.get(id).setName(newName);
            subTasks.get(id).setDescription(newDescription);
        } else {
            System.out.println("Нет задачи с таким ID");
        }
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

    public void changeStatusTask(Task task, Status status) {
        task.setStatus(status);
    }

    public void changeStatusSubtask(Subtask subtask, Status status){
        subtask.setStatus(status);
        epics.get(subtask.epicId);
        for (Integer subtaskId : epics.get(subtask.epicId).getListSubtaskId()) {
            if(subTasks.get(subtaskId).getStatus() == Status.NEW){
                epics.get(subtask.epicId).setStatus(Status.NEW);
            } else if (subTasks.get(subtaskId).getStatus() == Status.DONE){
                epics.get(subtask.epicId).setStatus(Status.DONE);
            } else {
                epics.get(subtask.epicId).setStatus(Status.IN_PROGRESS);
            }
        }
    }
}
