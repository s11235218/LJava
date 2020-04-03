package LPoker;

import java.util.ArrayList;
import java.util.List;

public class YangHui {
    public List<List<Integer>> generate(int numRows){
        // 1. 第一行固定一个 1
        // 2. 第二行固定两个 1
        // 3. 第 i 行，首尾元素都是1
        // 4. 第 i 行有 i 个元素
        // 5. [i, j] = [i - 1, j - 1] + [i - 1, j]
        if(numRows <= 0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        // 步骤一
        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if(numRows == 1){
            return result;
        }
        // 步骤二
        List<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if(numRows == 2){
            return result;
        }
        // 步骤三
        for (int row = 3; row < numRows; row++) {
            List<Integer> prevLine = result.get(row - 1 - 1);
            List<Integer> curLine = new ArrayList<>();
            curLine.add(1);
            // 第 row 行有 row 列 循环了 row - 2 次
            for (int col = 2; col < row; col++) {
                // col 是从 1 开始算的，转换成下标需要再 - 1
                int curNum = prevLine.get(col - 1 - 1) + prevLine.get(col - 1);
                curLine.add(curNum);
            }
            // 最后一个 1
            curLine.add(1);
            result.add(curLine);
        }
        return result;
    }
}
