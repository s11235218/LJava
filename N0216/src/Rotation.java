public class Rotation {
    public static int[] rotate(int[] array, int k) {
        int length = array.length;
        int[] newArray = new int[length];
        for(int i = 0; i < length; i++) {
            int newPosition = (i + k) % length;
            newArray[newPosition] = array[i];
        }
        return newArray;
    }

}

