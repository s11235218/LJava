package lengthTest;

public class lengthOFLastWord {
    public static int lengthOFLastWord(String s){
        int right = s.length() - 1;
        int count = 0;
        while(right >= 0){
            if(s.charAt(right) != ' '){
                count++;
            }else if(count > 0){
                return count;
            }
            right--;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(lengthOFLastWord("h "));
    }
}
