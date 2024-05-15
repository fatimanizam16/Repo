package Practice.utils;

public class Utils {

    public static void pauseExecution(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
