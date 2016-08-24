package sync;

/**
 * Created by bogehu on 16/8/24.
 */
//使用synchronized关键字来同步方法
public class Bank {
    //账户余额
    private int  count=0;
    //存钱
    public synchronized void addMoney(int money){
        count+=money;
        System.out.println(System.currentTimeMillis()+"存钱 "+money+" 元");
    }
    //取钱
    public synchronized void extractMoney(int money){
        if (count-money<0)
        {System.out.println("对不起,您的余额不足.");
            return;}
        count-=money;
        System.out.println(System.currentTimeMillis()+"取钱 "+money+" 元");
    }
    // 查询余额
    public void checkMoney(){
        System.out.println("您的余额为: "+count);
    }
}
