package sync;

/**
 * Created by bogehu on 16/8/25.
 */
//使用synchronized关键字来同步代码块
//同步是一种高开销的操作，因此应该尽量减少同步的内容。通常没有必要同步整个方法，使用synchronized代码块同步关键代码即可。
public class Bank2 {
    //账户余额
    private int  count=0;
    //存钱
    public  void addMoney(int money){
        synchronized (this){count+=money;}
        System.out.println(System.currentTimeMillis()+"存钱 "+money+" 元");
    }
    //取钱
    public  void extractMoney(int money){
        synchronized (this){if (count-money<0)
        {System.out.println("对不起,您的余额不足.");
            return;}
        count-=money;}
        System.out.println(System.currentTimeMillis()+"取钱 "+money+" 元");
    }
    // 查询余额
    public void checkMoney(){
        System.out.println("您的余额为: "+count);
    }
}
