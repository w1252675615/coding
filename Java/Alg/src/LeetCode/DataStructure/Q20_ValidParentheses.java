package LeetCode.DataStructure;
/*
    给定字符串只包含(、)、{、}、[、]，判断是否有效，（[]）有效，(])[无效。
    不用栈而用char[],避免频繁装箱开箱
 */

import java.util.Stack;

public class Q20_ValidParentheses {
    public boolean isValid(String s) {
        char[] charStr = s.toCharArray();
        Stack stack = new Stack();
        int length = s.length();
        boolean res = false;
        if ((length & 1) == 1) return res;
        for (int i = 0; i < length; ++i) {
            switch(charStr[i]) {
                case ']' :
                    if (!stack.isEmpty() && stack.peek().equals('[')) {
                        stack.pop();
                        break;
                    }
                    else return res;
                case ')' :
                    if (!stack.isEmpty() && stack.peek().equals('(')) {
                        stack.pop();
                        break;
                    }
                    else return res;
                case '}' :
                    if (!stack.isEmpty() && stack.peek().equals('{')) {
                        stack.pop();
                        break;
                    }
                    else return res;
                case '[' :
                    stack.push('[');
                    break;
                case '(' :
                    stack.push('(');
                    break;
                case '{' :
                    stack.push('{');
                    break;
                default :
                    return res;
            }
        }
        if (stack.isEmpty()) res = true;
        return res;
    }
    public boolean isValid2(String s) {
        int l = s.length();
        if ((l & 1) == 1) return false;
        char[] a= new char[l/2+1];
        int top=0;
        for(int i =0; i<l;i++)
        {switch (s.charAt(i))
        {
            case '(':
            case '{':
            case '[':
                a[top++]=s.charAt(i);
                if (top>= s.length()/2+1)
                    return false;
                break;
            case ')':
                if(top>0)
                    if (a[top-1] == '(')
                    {
                        top--;
                        break;
                    }
                return false;
            case '}':
                if(top>0)
                    if (a[top-1] == '{')
                    {
                        top--;
                        break;
                    }
                return false;
            case ']':
                if(top>0)
                    if (a[top-1] == '[')
                    {
                        top--;
                        break;
                    }
                return false;

            default:
                return false;
        }
        }

        if (top>0)
            return false;
        return true;
    }
}
