package canConstruct;

public class canConstruct {
    public static boolean canConstruct(String ransomNote, String magazine){
        int[] num = new int[26];
        for(int i = 0; i < magazine.length(); i++){
            num[magazine.charAt(i) - 'a']++;
        }
        for(int i = 0; i < ransomNote.length(); i++){
            num[ransomNote.charAt(i) - 'a']--;
            if(num[ransomNote.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
    }
}
