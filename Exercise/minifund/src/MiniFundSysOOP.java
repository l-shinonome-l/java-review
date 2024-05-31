import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MiniFundSysOOP {
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key = "";

    String details = "------------零钱通明细------------";

    double money = 0;
    double balance = 0;
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    String note = "";

    public void mainMenu() {
        do {
            System.out.println("\n==========零钱通菜单OOP==========");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退     出");

            System.out.print("请选择(1-4): ");
            key = scanner.next();
            switch (key) {
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.print("选择有误，请重新选择");
            }
        }while (loop);

        System.out.println("-----退出了零钱通项目-----");
    }

    public void detail() {
        System.out.println(details);
    }

    public void income() {
        System.out.print("收益入账金额:");
        money = scanner.nextDouble();
        if (money <= 0) {
            System.out.println("收益入账金额需要大于0");
            return;
        }
        balance += money;
        date = new Date();
        details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + balance;
    }

    public void pay() {
        System.out.print("消费金额:");
        money = scanner.nextDouble();
        if (money <= 0 || money > balance) {
            System.out.println("消费金额应该在 (0 ," + balance + ")");
            return;
        }
        balance -= money;
        System.out.print("请输入消费说明:");
        note = scanner.next();
        date = new Date();
        details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
    }

    public void exit() {
        System.out.println("4 退     出");
        String choice = "";
        while (true) {
            System.out.println("你确定要退出吗？y/n");
            choice = scanner.next();
            if (choice.equals("y") || choice.equals("n")) {
                break;
            } else {
                System.out.println("请输入y/n");
            }
        }
        if (choice.equals("y")) {
            loop = false;
        }
    }
}
