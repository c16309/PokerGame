package poker;

/**
 *
 * @author c16309
 */
public class Cards {
    final static Deck deck = new Deck();
    
    static{
        for(int i=0;i<4;i++){
            for(int j=1;j<=13;j++){
                deck.add(new Card(i,j));
            }
        }
    }
    
    static Deck newCards(){
        return deck;
    }
}
