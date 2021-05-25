package advanced.class01;

public class Code_01_Palindrome_Number {
    /**
     * 给定一个整数， 判断该数是否是回文数
     * @param n
     * @return
     */
    public static boolean isPalindrome(int n){
        if (n < 0){
            return false;
        }

        int help = 1;
        while(n / help >= 10){
            help *= 10;
        }

        while (n != 0){
            if (n / help != n % 10){
                return false;
            }
            n = (n % help) /10;
            help = help / 100;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean palindrome = Code_01_Palindrome_Number.isPalindrome(12221);
        System.out.println(palindrome);
    }
}
