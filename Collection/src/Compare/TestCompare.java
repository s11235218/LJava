package Compare;

import java.util.Comparator;

class Card implements Comparable<Card> {
    public String rank;
    public String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object obj) {
        // 按值比较 this 和 obj
        // 1. 自己和自己比较
        if (this == obj) {
            return true;
        }
        // 2. obj 为 null 结果为 false
        if (obj == null) {
            return false;
        }
        // 3. obj 这个类型不是当前 Card 类型
        if (!(obj instanceof Card)) {
            return false;
        }
        // 4. 比较真正的内容
        Card other = (Card)obj;
        return this.rank.equals(other.rank) && this.suit.equals(other.suit);
    }

    @Override
    public int compareTo(Card o) {
        // this < o  return < 0
        // this > o  return > 0
        // this == o  return 0
        if (o == null) {
            // 一般认为 null 的值比较小
            return 1;
        }
        // 点数取值：2-10，J, Q, K, A
        int rank1 = this.getValue();
        int rank2 = o.getValue();
        return rank1 - rank2;
    }

    public int getValue() {
        int value = 0;
        if ("J".equals(rank)) {
            value = 11;
        } else if ("Q".equals(rank)) {
            value = 12;
        } else if ("K".equals(rank)) {
            value = 13;
        }else if ("A".equals(rank)) {
            value = 14;
        } else {
            value = Integer.parseInt(rank);
        }
        return value;
    }
}

class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        int value1 = o1.getValue();
        int value2 = o2.getValue();
        return value1 - value2;
    }
}

public class TestCompare {
    public static void main(String[] args) {
        Card p = new Card("3", "♠");
        Card q = new Card("A", "♥");
        Card o = p;

//        System.out.println(p == o);
//        System.out.println(p == q);
//
//        System.out.println();
//
//        System.out.println(p.equals(o));
//        System.out.println(p.equals(q));

//        System.out.println(p.compareTo(q));
//        System.out.println(p.compareTo(o));

        CardComparator cardComparator = new CardComparator();
        System.out.println(cardComparator.compare(p, q));
    }
}
