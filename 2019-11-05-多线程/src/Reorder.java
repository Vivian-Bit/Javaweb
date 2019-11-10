public class Reorder {
    private static int a0 = 0;
    private static int a1 = 0;
    private static int a2 = 0;
    private static int a3 = 0;
    private static int a4 = 0;
    private static int a5 = 0;
    private static int a6 = 0;
    private static int a7 = 0;
    private static int a8 = 0;
    private static int a9 = 0;
    private static int a10 = 0;
    private static int a11 = 0;
    private static int a12 = 0;
    private static int a13 = 0;

    private static class Set extends Thread {
        @Override
        public void run() {
            a0 = 1;
            a1 = 2;
            a2 = 3;
            a3 = 4;
            a4 = 5;
            a5 = 6;
            a6 = 7;
            a7 = 8;
            a8 = 9;
            a9 = 10;
            a10 = 11;
            a11 = 12;
            a12 = 13;
            a13 = 14;
        }
    }

    private static class Print extends Thread {
        @Override
        public void run() {
            System.out.println(a0);
            System.out.println(a1);
            System.out.println(a2);
            System.out.println(a3);
            System.out.println(a4);
            System.out.println(a5);
            System.out.println(a6);
            System.out.println(a7);
            System.out.println(a8);
            System.out.println(a9);
            System.out.println(a10);
            System.out.println(a11);
            System.out.println(a12);
            System.out.println(a13);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Set();
        Thread t2 = new Print();
        t1.start();
        t2.start();
    }
}











