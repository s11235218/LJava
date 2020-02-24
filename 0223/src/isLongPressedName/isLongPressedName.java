package isLongPressedName;

public class isLongPressedName {
    public static boolean isLongPressedName(String name, String typed) {
        int len1 = name.length();
        int len2 = typed.length();
        //如果后输入的名字比name短，说明输入错误
        if (len1 > len2) {
            return false;
        }
        //循环判断两字符串
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            //当两字符串对应位第一次相等时，移动到下一位
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
                //当不相等时，如果输入的typed前一位与后一位相等时，进入循环j++，如果不相等，说明输入错误
            } else {
                if (j > 0 && typed.charAt(j - 1) == typed.charAt(j)) {
                    j++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String name = "pyplrz";
        String typed = "ppyypllr";
        System.out.println(isLongPressedName(name, typed));
    }
}
