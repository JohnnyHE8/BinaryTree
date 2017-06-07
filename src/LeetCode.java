import kotlin.reflect.jvm.internal.ReflectProperties;

import java.util.Stack;

public class LeetCode {
    public static void main(String args[]){

        LC leetcode = new LC();
        leetcode.Reverse(12345);

        String[] sample01 = { "I am Chinese", "I am Japanese", "I am American" };
        leetcode.LongestCommonPrefix(sample01);
        boolean a = leetcode.Parentheses("(aaa[aaasd]8ufhfjd)jljk");
        boolean b = leetcode.Parentheses("sajdas(sjdhaj]dsas");
        System.out.println(a + " " + b);
    }
}

class LC{
    public void Reverse(int n){
        int rez = 0;
        int r;
        int left = n;

        while(left > 0){
            r = left % 10;
            rez = rez * 10 + r;
            left = left / 10;
        }

        System.out.println(rez);
    }

    public void LongestCommonPrefix(String[] strs){
         if(strs == null || strs.length == 0)
             return;

         String pre = strs[0];
         int i = 1;

         while(i < strs.length){
             while(strs[i].indexOf(pre) != 0)
                 pre = pre.substring(0, pre.length() - 1);
             i++;
         }
         System.out.println(pre);
    }

    public Boolean Parentheses(String string){
        Stack<Character> stack = new Stack<>();

        for(char c: string.toCharArray()){
            if(c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if(stack.isEmpty() || stack.pop() != c)
                return false;
        }

        return stack.isEmpty();
    }
}
