package lesson5;

public class ATM {
    int money;

    public ATM(int money) {
        this.money = money;
    }

    public synchronized void takeMoney(String name, int amount){
        if(money>=amount){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            money-=amount;
            System.out.println(name + " take" + amount);
        }else {
            System.out.println(name + " not enough money");
        }
        info();
    }

    public void info(){
        System.out.println("ATM: " + money);
    }

    public static void main(String[] args) {
        ATM atm = new ATM(100_000);
        new Thread(()->{atm.takeMoney("Bob1", 50000);}).start();
        new Thread(()->{atm.takeMoney("Bob2", 50000);}).start();
        new Thread(()->{atm.takeMoney("Bob3", 50000);}).start();
    }
}
