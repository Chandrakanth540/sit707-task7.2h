package sit707_tasks;
public class TaskListDriver {
    private OnTrackFunctions onTrackFunctions;

    public TaskListDriver(OnTrackFunctions onTrackFunctions) {
        this.onTrackFunctions = onTrackFunctions;
    }

    public void simulateTaskList() {
        onTrackFunctions.displayTaskList();
    }
}
