package LPoker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Card{
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
//        return "Card{" +
//                "rank='" + rank + '\'' +
//                ", suit='" + suit + '\'' +
//                '}';
        return "[" + this.suit + this.rank + "]";
    }
}

public class Poker {
    public static void main(String[] args) {
        // 1. 创建牌
        List<Card> poker = buyPoker();
        // System.out.println(poker);
        // 2. 洗牌 直接使用 Collections.shuffle 把 List 中的元素随机打乱
        //     shuffle 自己实现：从后往前遍历 List, 取出当前元素，
        //     再生成一个随机位置，将当前元素和随机元素交换
        Collections.shuffle(poker);
        // 3. 发牌 假设有三个人 每人发五张
        //    每个玩家就是一个 List 可把每个人的牌放到 List 中
        //    可以把这多喝玩家信息放到一个 List 中
        List<List<Card>> players = new ArrayList<>();
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        // 给三个玩家发牌 每人五张
        // i 是牌的编号 j 是玩家编号
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                List<Card> player = players.get(j);
                // remove 表示删除 List 中指定下标元素
                // remove 返回值表示删除的这个元素内容
                player.add(poker.remove(0));
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("玩家" + i + ": " + players.get(i));
        }
    }

    private static List<Card> buyPoker() {
        List<Card> poker = new ArrayList<>();

        String[] suits = {"♥", "♠", "♣", "♦"};

        for (int i = 0; i < 4; i++) {
            for (int j = 2; j <= 10; j++) {
                // poker.add("" + j, suits[i]);
                poker.add(new Card(String.valueOf(j), suits[i]));
            }
            poker.add(new Card("J", suits[i]));
            poker.add(new Card("Q", suits[i]));
            poker.add(new Card("K", suits[i]));
            poker.add(new Card("A", suits[i]));
        }
        return poker;
    }
}
