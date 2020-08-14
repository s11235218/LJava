package Thread6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPool {
    ExecutorService pool = Executors.newFixedThreadPool(4);

}
