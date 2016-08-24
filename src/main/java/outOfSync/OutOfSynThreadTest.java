package outOfSync;

/**
 * Created by bogehu on 16/8/24.
 */
public class OutOfSynThreadTest {
    public static void main(String[] args) {
        final Bank bank=new Bank();
        final Thread threadAdd=new Thread(new Runnable() {
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e){e.printStackTrace();}
                    bank.addMoney(100);
                    bank.checkMoney();
                    System.out.println("\n");
                }

            }
        });

        Thread threadExtract=new Thread(new Runnable() {
            public void run() {
                while (true){
                    bank.extractMoney(100);
                    bank.checkMoney();
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
