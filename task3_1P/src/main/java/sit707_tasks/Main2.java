package sit707_tasks;

public class Main2 {
    public static void main(String[] args) {
        OnTrackFunctions onTrackFunctions = new OnTrackFunctions();
        LoginDriver loginDriver = new LoginDriver(onTrackFunctions);
        HomeScreenDriver homeScreenDriver = new HomeScreenDriver(onTrackFunctions);
        TaskListDriver taskListDriver = new TaskListDriver(onTrackFunctions);

        // Test path: Login -> Home Screen -> Task List
        loginDriver.simulateLogin();
        homeScreenDriver.simulateHomeScreen();
        taskListDriver.simulateTaskList();
    }
}
