package day01;

public class NewThread implements Runnable {
    @Override
    public synchronized void run() {
        while (true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程启动了 ...");
        }
    }

    public static void main(String[] args) {
        // 创建线程,并指定Runnable接口。
        NewThread newThread = new NewThread();
        Thread thread = new Thread(newThread);

        thread.start(); //启动线程

        while (true) {
            synchronized (newThread) {
                System.out.println("main");
                newThread.notifyAll();
            }
        }
    }
}
