import java.util.ArrayList;
public class Epic extends Task {

    private final ArrayList<Integer> listSubtaskId = new ArrayList<>();

    public Epic(String name, String description) {
        super(name, description);
    }

    public void addSubtaskIdInEpic(Integer subtaskId){
        listSubtaskId.add(subtaskId);
        System.out.println("Добавление прошло успешно!");
    }

    public ArrayList<Integer> getListSubtaskId() {
        return listSubtaskId;
    }

    public void removeSubtaskIdInEpic(Integer subtaskIdToRemove){
        listSubtaskId.remove(subtaskIdToRemove);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public Status getStatus() {
        return super.getStatus();
    }

    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public void setStatus(Status status) {
        super.setStatus(status);
    }

    @Override
    public String toString() {
        return "Epic{" +
                "name = " + getName() + '\'' +
                ", description = " + getDescription() + '\'' +
                ", status = " +  getStatus() +
                ", id = " + getId() +
                "}"+"\n";
    }
}
