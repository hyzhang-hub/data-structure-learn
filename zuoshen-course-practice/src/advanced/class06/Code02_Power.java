package advanced.class06;

public class Code02_Power {
    /**
     * 判断一个32位正数是不是2的幂、 4的幂
     */

    public static boolean is2Power(int n){
        return (n & (n - 1)) == 0;
    }

    public static boolean is4Power(int n){
        return n > 0 && (n & (n -1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }

    public static void main(String[] args) {
        System.out.println(is4Power(2));
    }

}
