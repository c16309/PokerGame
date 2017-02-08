package poker;

/**
 *
 * @author c16309
 */
public class Player {
    
    private String name;
    private int coin;
    private int i=0;
    public Card[] tehuda = new Card[5];
    
    Player(String name,int coin,int i){
        this.name = name;
        this.coin = coin;
        this.i = i; 
        this.tehuda = tehuda;
    }
    
    
    //displayHand();
    void displayHand(){
        for(int j=0;j<5;j++){
            System.out.print(tehuda[j]);
            if(j<4)
                System.out.print(",");
        }
        System.out.println();
        
    }
    
    //drawIn(cards.pop());
    public void drawIn(Card c){
        
        tehuda[i] = c;
        i++;
    }

    public void changeHand(Card c,int change) {
        tehuda[change] = c;
    }
    
    public Card[] getTehuda(){ return tehuda; }
    
    //public void hand(){
       // System.out.println(10); 
    //}
    
    public void handRefresh(){
        i=0;
    }
}
