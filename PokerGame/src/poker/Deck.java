package poker;

import java.util.Collections;
import java.util.Stack;
/**
 *
 * @author c16309
 */
public class Deck extends Stack<Card>{
    Deck(){
        
    }
    
    //シャッフル
    void shuffle(){
        Collections.shuffle(this);
    }
}
