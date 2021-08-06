package newCode;

public class dfs1 {
    private static int n = 3;	//	三张牌
    private static int[] box = new int[4];
    private static int[] used = new int[4];	//	标记数组

    //	step 表示现在站在第几个盒子面前
    private static void dfs(int step){
        //	表示前面 n 个盒子已经放好扑克牌
        if(step == n+1) {
            //	此时牌已经全部放进去了
            for(int i=1;i<=n;i++) {
                System.out.print(box[i]);
            }
            System.out.println();
            return;	//	返回到上一个 dfs 函数
        }

        for(int i=1;i<=n;i++) {
            //	判断扑克牌是否还在手上
            if(used[i]==0) {
                box[step] = i; //	将 i 号扑克牌放到第 step 个盒子中
                used[i] = 1;	//	表示扑克牌已经不在手中了
                //	第 step 个盒子已经放好牌，走到下一个盒子前
                dfs(step+1);	//	递归
                used[i]=0;	//	收回已经放置的 i 号牌，进行下一步摆放

            }
        }
        return;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        dfs(1);	//	站在第一个盒子前
    }
}
