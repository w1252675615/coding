package offer.ReplaceSpace_05;

/*
    空格变成%20
    法1，先扩展长度，两个标记倒着来，标记重合表示前面的不用改了。
    法2，暴力new一个StringBuilder，直接遍历一次。
 */

public class ReplaceSpace {
    public String replaceSpace1(StringBuffer str) {
        if (str == null) throw new IllegalArgumentException("Wrong String");
        int spaceNumber = 0;
        for (int i = 0; i < str.length();++i) {
            if (str.charAt(i) == ' ') ++spaceNumber;
        }
        int oldIndex = str.length() - 1;
        int newLength = str.length() + 2 * spaceNumber;
        int newIndex  = newLength -1;
        str.setLength(newLength);
        while (oldIndex >= 0 && oldIndex < newIndex) {
            if (str.charAt(oldIndex) == ' ') {
                str.setCharAt(newIndex--,'0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');
            }else {
                str.setCharAt(newIndex--,str.charAt(oldIndex));
            }
            --oldIndex;
        }
        return str.toString();
    }
    public String replaceSpace2(StringBuffer str) {
        if (str == null) throw new IllegalArgumentException("Wrong String");
        StringBuilder str2 = new StringBuilder();
        for (int i = 0; i < str.length(); ++i) {
            if(str.charAt(i) == ' ') {
                str2.append("%20");
            }else str2.append(str.charAt(i));
        }
        return str2.toString();
    }

    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        StringBuffer str = new StringBuffer(" wo shi 王领");
        System.out.println(replaceSpace.replaceSpace2(str));
        System.out.println(str);
        System.out.println(replaceSpace.replaceSpace1(str));
    }
}
