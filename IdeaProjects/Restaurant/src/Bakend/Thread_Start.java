package Bakend;

import GUI.First_Frame;
import GUI.Second_Frame;
import java.time.LocalDateTime;

public class Thread_Start extends Thread {
    boolean bool;
    LocalDateTime LT;
    int compare_time = -1;
    public Thread_Start() {
        start();
    }

    @Override
    public void run() {
        while (true) {
            if (Second_Frame.second_frame_on) {
                break;
            }
            bool = false;
            for (int i = 0; i < 10; i++) {
                LT = LocalDateTime.now();
                System.out.println(First_Frame.city);
                if (UserData.local_Time[First_Frame.city][i] != null) {
                    compare_time = LT.compareTo(UserData.local_Time[First_Frame.city][i]);
                    bool = true;
                }
                if (compare_time > 0 || compare_time == 0) {
                    UserData.local_Time[First_Frame.city][i] = null;
                    First_Frame.button[First_Frame.city][i] = null;
                    First_Frame.frame.dispose();
                    new First_Frame();
                    compare_time = -1;
                }
            }
            if (!bool) {
                break;
            } else {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
