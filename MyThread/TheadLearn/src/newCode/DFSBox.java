package newCode;

import java.util.Scanner;

public class DFSBox {

    public static void main(String[] args) {

        System.out.println("请输入纸牌数：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] box = new int[n+1];
        int[] used = new int[n+1];
        DFS(box, used, 1);
    }

    public static void DFS(int[] box, int[] used, int idx){
        // 边界
        if (idx == box.length) {
            for (int i = 1; i < box.length; i++) {
                System.out.print(box[i]);
            }
            System.out.println();
            return;
        }

        // 处理当前盒子
        for (int i = 1; i <= box.length-1; i++) {
            //判断当前牌是否用过
            if (used[i] == 0){
                // 当前没有使用的牌放入当前盒子
                box[idx] = i;
                used[i] = 1;

                // 处理下一个盒子
                DFS(box, used, idx + 1);
                // 回收当前使用的牌
                used[i] = 0;
            }
        }
    }
}
