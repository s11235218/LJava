package Thread7;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*定时器：
* 1.约定好的时间点，执行某个任务
* 2.间隔时间到后，不停的执行任务
*/
public class MyTimer {

    /**
     * 定时任务
     * @param task 需要执行的任务
     * @param delay 从当前时间延迟多少毫秒，执行任务
     * @param period 间隔时间：<= 0忽略, > 0 需要每间隔给定时间执行任务
     *
     * @return void
     * @author Sssserein
     * @creed: Talk is cheap,show me the code
     * @date 2020/9/18 17:11
     */

    public static void schedule(Runnable task, long delay, long period) {
        try {
            Thread.sleep(delay);
            new Thread(task).start();
            if (period > 0) {
                Thread.sleep(period);
                new Thread(task).start();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       /* while (true) {
            long next = System.currentTimeMillis();
            // 当前时间next超过约定好的时间current + delay, 执行任务
            if (current + delay <= next) {

                if (period <= 0) {
                    break;
                } else {

                }
            }
        }*/
    }

    // jdk的时间操作
    public static void main(String[] args) {
        // Date
        Date date = new Date();// 无参构造方法，返回系统当前时间
        // System.out.println(date);
        Date date1 = new Date(9999999);// 以格林威治时间1970-01-01开始，经过给定时间数量的毫秒
        // DateFormat
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(df.format(date));
//        System.out.println(df.format(date1));
        // System时间获取:从1970-01-01开始到当前时间点经过的毫秒数
        long current = System.currentTimeMillis();

/*        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("起床！");
            }
        };
        new Timer().schedule(task, 3000, 1000);
        */

        /*new MyTimer().schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("起床！");
            }
        }, 3000, 1000);*/

        // ExecutorService pool = Executors.newSingleThreadExecutor(); // 线程池员工只有一个
        // ExecutorService pool1 = Executors.newFixedThreadPool(4); // 正式员工为4，没有临时员工
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(4);// 正式员工
        // ExecutorService pool = Executors.newCachedThreadPool();// 正式员工为0，临时工数量不限制

        /*pool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("起床！");
            }
        },1, TimeUnit.SECONDS); // 延迟时间执行任务*/

        pool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("起床！");
            }
        },1, 1, TimeUnit.SECONDS);
    }

}
