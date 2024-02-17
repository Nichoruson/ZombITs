import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer {
    private static boolean timeExpired = false;

    public static void main(String[] args) {
        Questions.playGame();
    }

    public static void startTimer() {
        timeExpired = false;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Lost Life");
                timeExpired = true;
                timer.cancel();
            }
        }, 15000);
    }

    public static boolean isTimeExpired() {
        return timeExpired;
    }
}
