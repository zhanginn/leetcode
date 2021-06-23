package leetcode.editor.cn.design;

public class Singleton {
    private static volatile Singleton A;

    private Singleton() {
    }

    public static Singleton getA() {
        if (A == null) {
            synchronized (Singleton.class) {
                if (A == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    A = new Singleton();
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton.getA().hashCode());
            }).start();
        }
    }
}
