package sit707_tasks;
public class HomeScreenDriver {
    private OnTrackFunctions onTrackFunctions;

    public HomeScreenDriver(OnTrackFunctions onTrackFunctions) {
        this.onTrackFunctions = onTrackFunctions;
    }

    public void simulateHomeScreen() {
        onTrackFunctions.displayHome();
    }
}

