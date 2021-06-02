package advanced.class06;

public class Code03_AddMinusMultiDivideByBit {
    /**
     * 给定两个有符号32位整数a和b， 不能使用算术运算符， 分别实现a和b的加、 减、 乘、 除运算
     * 【要求】
     * 如果给定a、 b执行加减乘除的运算结果就会导致数据的溢出， 那么你实现的函数不必对此
     * 负责， 除此之外请保证计算过程不发生溢出
     */
    public static int add(int a, int b){
        int sum = a;
        while (b != 0){
            sum = a ^ b;//无进位相加的结果
            b = (a & b) << 1;//进位信息
            a = sum;
        }
        return sum;
    }

    public static int negNum(int n){
        return add(~n, 1);
    }

    public static int minus(int a, int b){
        return add(a, negNum(b));
    }

    public static int multi(int a, int b){
        int res = 0;
        while (b != 0){
            if ((b & 1) != 0){
                res = add(res, a);
            }
            a<<=1;
            b>>>=1;
        }
        return res;
    }




    public static void main(String[] args) {
        int a = (int) (Math.random() * 100000) - 50000;
        int b = (int) (Math.random() * 100000) - 50000;
        System.out.println("a = " + a + ", b = " + b);
        System.out.println(add(a, b));
        System.out.println(a + b);
        System.out.println("=========");
        System.out.println(minus(a, b));
        System.out.println(a - b);
        System.out.println("=========");
        System.out.println(multi(a, b));
        System.out.println(a * b);
        System.out.println("=========");
//        System.out.println(divide(a, b));
//        System.out.println(a / b);
//        System.out.println("=========");
//
//        a = Integer.MIN_VALUE;
//        b = 32;
//        System.out.println(divide(a, b));
//        System.out.println(a / b);

    }
}
