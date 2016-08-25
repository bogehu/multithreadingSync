package sync;

/**
 * Created by bogehu on 16/8/24.
 */
public class SyncThreadTest {
    public static void main(String[] args) {
        final Bank2 bank2=new Bank2();
        final Thread threadAdd=new Thread(new Runnable() {
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e){e.printStackTrace();}
                    bank2.addMoney(100);
                    bank2.checkMoney();
                    System.out.println("\n");
                }

            }
        });

        Thread threadExtract=new Thread(new Runnable() {
            public void run() {
                while (true){
                    bank2.extractMoney(100);
                    bank2.checkMoney();
                    System.out.println("\n");
                    try{Thread.sleep(1000);}
                    catch (InterruptedException e){e.printStackTrace();}
                }
            }

        });
        threadAdd.start();
        threadExtract.start();

    }
}
