package newCode;

import java.util.HashSet;
import java.util.Set;

public class wordBreak {

    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<String>();
        hashSet.add("leet");
        hashSet.add("code");

        System.out.println(wordBreak1("leetcode", hashSet));;
    }

    public static boolean wordBreak(String s, Set<String> dict) {
        if (s.length() == 0)
            return false;
        boolean[] canBreak = new boolean[s.length() + 1];
        for (int i = 0; i <= s.length(); ++i) {
            // 整体[i, 1]
            if (dict.contains(s.substring(0, i))){
                canBreak[i] = true;
                continue;
            }
            for (int j = i - 1; j > 0; --j) {
                // j<i && F(j) && [j+1, i]
                if (canBreak[j] && dict.contains(s.substring(j, i))){
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }

    public static boolean wordBreak1(String s, Set<String> dict) {
        boolean[] canBreak = new boolean[s.length() + 1];
        // F(0):true
        canBreak[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                // j<i && F(j) && [j+1, i]
                if (canBreak[j] && dict.contains(s.substring(j, i))){
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }
}
