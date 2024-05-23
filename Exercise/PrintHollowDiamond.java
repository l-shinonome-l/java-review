public class PrintHollowDiamond {
    public static void main(String[] args) {
        // TODO: 修改为指定行数n而非固定行数
        // 打印空心棱形
        for (int i = 1; i <= 9; i++) {
            // 打印每行最前面的空格
            for (int j = 0; j < Math.abs(5 - i); j++) {
                System.out.print(" ");
            }
            // 除第一行和最后一行，都要打印第一个*
            if (i != 1 && i != 9) {
                System.out.print("*");
            }
            //中间的空格分前五行和后四行讨论
            if (i <= 5) {
                for (int j = 0; j < 2 * i - 3; j++) {
                        System.out.print(" ");
                }
            } else {
                for (int j = 0; j < 17 - 2 * i; j++) {
                    System.out.print(" ");
                }
            }
            // 打印每行最后的*
            System.out.println("*");
        }
    }
}
