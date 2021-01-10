package unit013;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

/**
 *  使用集合实现斗地主游戏的部分功能，要求如下：
 *  （1）首先准备 54 张扑克牌并打乱顺序。
 *  （2）由三个玩家交替摸牌，每人 17 张扑克牌，最后三张留作底牌。
 *  （3）查看三个玩家手中的扑克牌和底牌。
 *  （4）其中玩家手中的扑克牌需要按照大小顺序打印，规则如下：
 *     手中扑克牌从大到小的摆放顺序：大王,小王,2,A,K,Q,J,10,9,8,7,6,5,4,3
 */

public class Demo5 {
    // 扑克牌
    private Map<Integer, String> pokerMap = new HashMap<>();
    // 扑克牌索引
    private ArrayList<Integer> pokerIdxList = new ArrayList<>();
    // 玩家1扑克牌索引
    private ArrayList<Integer> player1PokerIdxList = new ArrayList<>();
    // 玩家2扑克牌索引
    private ArrayList<Integer> player2PokerIdxList = new ArrayList<>();
    // 玩家3扑克牌索引
    private ArrayList<Integer> player3PokerIdxList = new ArrayList<>();
    // 底牌索引
    private ArrayList<Integer> holePokerIdxList = new ArrayList<>();

    private static int PLAYER_POKER_COUNT = 17;

    public Demo5(){

    }

    /**
     * 组合54张扑克牌
     */
    public void combinePokers(){
        // 无花色
        pokerMap.put(0, "大王");
        pokerIdxList.add(0);
        pokerMap.put(1, "小王");
        pokerIdxList.add(1);

        // 有花色
        String[] pokerColorArr = {"♤", "♣", "♡", "♢"};
        String[] pokerNoArr = {"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};
        int startIdx = 1;
        for(String pokerNo: pokerNoArr){
            for(String pokerColor: pokerColorArr){
                startIdx++;
                pokerMap.put(startIdx, pokerColor + pokerNo);
                pokerIdxList.add(startIdx);
            }
        }
        // 打乱索引
        Collections.shuffle(pokerIdxList);
    }

    /**
     * 发牌
     */
    public void dealPokers(){
        for(int i=0; i<pokerIdxList.size(); i++){
            int pokerIndex = pokerIdxList.get(i);
            // 底牌
            if(i >= PLAYER_POKER_COUNT * 3){
                holePokerIdxList.add(pokerIndex);
            }else{
                // 三个玩家
                if(i%3 == 0){
                    player1PokerIdxList.add(pokerIndex);
                }else if(i%3 == 1){
                    player2PokerIdxList.add(pokerIndex);
                }else if(i%3 == 2){
                    player3PokerIdxList.add(pokerIndex);
                }
            }
        }
        Collections.sort(player1PokerIdxList);
        Collections.sort(player2PokerIdxList);
        Collections.sort(player3PokerIdxList);
        Collections.sort(holePokerIdxList);
    }

    /**
     * 根据索引获取扑克牌
     * @param idList    扑克牌索引
     * @return ArrayList<String>
     */
    public ArrayList<String> getPokerList(ArrayList<Integer> idList){
        ArrayList<String> pokerList = new ArrayList<>();
        for(Integer id: idList){
            pokerList.add(this.pokerMap.get(id));
        }
        return pokerList;
    }

    /**
     * 展示下发的扑克牌
     */
    public void showPokers(){
        System.out.println("扑克牌下发后");
        ArrayList<String> player1Pokers = this.getPokerList(this.player1PokerIdxList);
        System.out.println("玩家1手中的扑克牌" + player1Pokers);
        ArrayList<String> player2Pokers = this.getPokerList(this.player2PokerIdxList);
        System.out.println("玩家2手中的扑克牌" + player2Pokers);
        ArrayList<String> player3Pokers = this.getPokerList(this.player3PokerIdxList);
        System.out.println("玩家3手中的扑克牌" + player3Pokers);
        ArrayList<String> holePokers = this.getPokerList(this.holePokerIdxList);
        System.out.println("底牌" + holePokers);
    }

}
