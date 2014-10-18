
import java.util.List;
import java.util.ArrayList;

public class Main {

  private static boolean schedule(int[] tasks, int task, int[] servers) {

    if(task == tasks.length)
      return true;

    for(int i = 0; i < servers.length; i++) {
      if(servers[i] >= tasks[task]) {
        servers[i] -= tasks[task];
        if(schedule(tasks, task + 1, servers))
          return true;
        servers[i] += tasks[task];
      }
    }
    return false;
  }
 



  public static void main(String[] args) {
    int[] tasks = {18,4,8,4,6,6,8,8,3};
    int[] servers = {8,16,8,32};

    System.out.println(schedule(tasks,0, servers));

  }

}

