package junojunho.threadstudy;

public class ThreadTest1 {
    public static void main(String[] args) {

        Thread thread1 = new Thread(() ->
        {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 100; i++) {
                System.out.print("a");
            }
            long end = System.currentTimeMillis();
            System.out.println("Thread1 running time: " + (end - start));
        }
        );

        Thread thread2 = new Thread(() ->
        {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 100; i++) {
                System.out.print("b");
            }
            long end = System.currentTimeMillis();
            System.out.println("Thread2 running time: " + (end - start));
        }
        );
        thread1.start();
        thread2.start();
    }
}
