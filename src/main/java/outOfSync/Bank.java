package outOfSync;

/**
 * Created by bogehu on 16/8/24.
 */
// 这是线程不同步的情况
public class Bank {
    //账户余额
    private int  count=0;
    //存钱
    public void addMoney(int money){
      count+=money;
        System.out.println(System.currentTimeMillis()+"存钱 "+money+" 元");
    }
    //取钱
    public void extractMoney(int money){
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
