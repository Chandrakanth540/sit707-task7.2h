package sit707_tasks;
public class LoginDriver {
    private OnTrackFunctions onTrackFunctions;

    public LoginDriver(OnTrackFunctions onTrackFunctions) {
        this.onTrackFunctions = onTrackFunctions;
    }

    public void simulateLogin() {
        onTrackFunctions.login();
    }
}

