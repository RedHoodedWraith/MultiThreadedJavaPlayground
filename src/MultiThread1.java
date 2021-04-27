/***
 * Code used here is based on the following tutorial: https://www.tutorialspoint.com/java/java_multithreading.htm
 */

class MyCustomTask implements Runnable {

    private Thread thread;
    private final String threadName;

    public MyCustomTask(String name) {
        this.threadName = name;
        System.out.println("Creating a Thread named: '" + threadName + "'");
    }

    @Override
    public void run() {
        System.out.println("Currently Running: " + threadName);
        try {
            for(int i=4; i>0; i--){
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread '" + threadName + "' was interrupted.");
        }

        System.out.println("Thread '" + threadName + "' ended.");
    }

    public void start() {
        System.out.println("Starting '" + threadName + "'");
        if(this.thread == null){
            this.thread = new Thread(this, this.threadName);
            thread.start();
        }
    }
}

public class MultiThread1 {

    public static void main(String[] args){
        MyCustomTask t1 = new MyCustomTask("Rhysand");
        t1.start();

        MyCustomTask t2 = new MyCustomTask("Feyre");
        t2.start();
    }

}
