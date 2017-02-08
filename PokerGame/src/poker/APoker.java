package poker;
import java.util.Scanner;

/**
 *
 * @author c16309
 */
public class APoker {
    static Deck cards;  //トレンプ
    //static Table table; //テーブル
    static PokerRule pokerRule; //役判定
    static Player humanPlayer;  //プレイヤー
    static Player computerPlayer;
    
    
    
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        
        
        System.out.println("ポーカーゲームを始めます！！");
        
        humanPlayer = new Player("プレイヤー",100,0);
        computerPlayer = new Player("コンピュータ",100,0);
        pokerRule = new PokerRule();
        int humanRank,computerRank;
        
        cards = Cards.newCards();   //新しいトランプを準備
        cards.shuffle();            //トランプをシャッフル
        dealCards();                //プレーヤーにカードを配る

        humanPlayer.displayHand();  //手札表示


        //手札判定
        System.out.println("手札交換をしますか(y/n)?"); String change = stdIn.next();
        if(change.equals("y")) changeHand();

        
        

        System.out.print("プレイヤーの手札：");
        humanPlayer.displayHand();
        //手札判定
        humanRank = pokerRule.rank(humanPlayer.tehuda);
        System.out.print("コンピュータの手札：");
        computerPlayer.displayHand();
        //手札判定
        computerRank = pokerRule.rank(computerPlayer.tehuda);
        
        System.out.println();
        judge(humanRank,computerRank);

    }
    
    //カードを配る
    static void dealCards(){
        for(int i=0;i<5;i++){
            humanPlayer.drawIn(cards.pop());
            computerPlayer.drawIn(cards.pop());
        }
    }
    
    static void changeHand(){
        Scanner stdIn = new Scanner(System.in);
        int change;
        
        do{    
            System.out.println("手札を交換する場所を指定してください（終了/0）");
            change = stdIn.nextInt();
            if(change != 0)
                humanPlayer.changeHand(cards.pop(),change-1);
        }while(change != 0);
    }
    
    //役の重みで判定
    static void judge(int player,int computer){
        if(player == computer){
            System.out.println("引き分け");
        }else if(player > computer){
            System.out.println("プレイヤーの勝ち");
        }else{
            System.out.println("コンピュータの勝ち");
        }
        
    }
}
