package intermediate.class02;

public class Problem04_ParenthesesDeep {
    /**
     * 一个合法的括号匹配序列有以下定义:
     * ①空串""是一个合法的括号匹配序列
     * ②如果"X"和"Y"都是合法的括号匹配序列,"XY"也是一个合法的括号匹配序列
     * ③如果"X"是一个合法的括号匹配序列,那么"(X)"也是一个合法的括号匹配序列
     * ④每个合法的括号序列都可以由以上规则生成。
     * 例如: "","()","()()","((()))"都是合法的括号序列
     * 对于一个合法的括号序列我们又有以下定义它的深度:
     * ①空串""的深度是0
     * ②如果字符串"X"的深度是x,字符串"Y"的深度是y,那么字符串"XY"的深度为
     * max(x,y) 3、 如果"X"的深度是x,那么字符串"(X)"的深度是x+1
     * 例如: "()()()"的深度是1,"((()))"的深度是3。 牛牛现在给你一个合法的括号
     * 序列,需要你计算出其深度。
     */

    public static int deep(String str){
        char[] chs = str.toCharArray();
        if (!isValid(chs)){
            return 0;
        }

        int count = 0;
        int max = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '('){
                max = Math.max(max, ++count);
            }else{
                count--;
            }
        }
        return max;
    }

    public static boolean isValid(char[] chs){
        if (chs == null || chs.equals("")){
            return false;
        }
        int status = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] != '(' && chs[i] != ')'){
                return false;
            }
            if (chs[i] == ')' && --status < 0){
                return false;
            }
            if (chs[i] == '('){
                status++;
            }
        }
        return status == 0;
    }


    public static void main(String[] args) {
        String test = "(((())))()";
        System.out.println(deep(test));

    }

}
