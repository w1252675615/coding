package Offer.Q19_RegularExpressionsMatching;
/*
    请实现一个函数用来匹配包括'.'和'*'的正则表达式。
    模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
    在本题中，匹配是指字符串的所有字符匹配整个模式。
    例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class RegularExpressionsMatching {
    public boolean match(char[] str, char[] pattern)
    {
        if (str == null || pattern == null) return false;
        return coreMatch(str,pattern,0,0);
    }
    private boolean coreMatch(char[] str,char[] pattern, int s, int p) {
        if (s == str.length && p == pattern.length) return true;
        if (s < str.length && p == pattern.length) return false;
            if (p < pattern.length -1 && pattern[p+1] == '*') {
                if (s < str.length && (pattern[p] == str[s] || pattern[p] == '.')) {//匹配到了*前的字符
                    return coreMatch(str,pattern,s,p+2) ||
                            coreMatch(str,pattern,s+1,p);
                }else {   //没匹配到
                    return coreMatch(str,pattern,s,p+2);
                }
            }else if (s < str.length && (pattern[p] == str[s] || pattern[p] == '.'))
                return coreMatch(str,pattern,s+1,p+1);
        return false;
    }
}
