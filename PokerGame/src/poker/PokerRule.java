package poker;

import java.util.Scanner;

/**
 *
 * @author c16309
 */
public class PokerRule {
    
    
    int rank(Card[] c){
        int count[] = {0,0,0,0,0};
        int straight[] = {0,0,0,0};
        int min=-1;
        int x=-1;
        for(int i=0;i<4;i++){
            for(int j=1+i;j<5;j++){
                if(c[i].getNumber() == c[j].getNumber()){
                    //スリーカードを判断
                    //ワンペアが出来たときに前回出来たワンペアの添字iを比較して一致したならスリーカード、一致しなければワンペアかツーペア
                    if(i==x){
                        count[1] += 1;
                        count[0]--;
                    }
                    count[0]++;
                    x = i;
                }
            }
            if(c[i].getNumber() < min)
                min = c[i].getNumber();
        }
        //フラッシュを調べるために全部の手札の絵柄を比較
        if(c[0].getSuit() == c[1].getSuit() && c[1].getSuit() == c[2].getSuit() && c[2].getSuit()== c[3].getSuit() && c[3].getSuit()== c[4].getSuit())
            count[4] = 1;
        
        //ストレートを判断
        //最小数字から１〜４を足したのと比較して一致していれば配列に入れ配列の数値が全て１ならストレート
        for(int i=0;i<5;i++){
            if(min+1 == c[i].getNumber())
                straight[0] += 1;
            if(min+2 == c[i].getNumber())
                straight[1] += 1;
            if(min+3 == c[i].getNumber())
                straight[2] += 1;
            if(min+4 == c[i].getNumber())
                straight[3] += 1;     
        }
        if(straight[0] == 1 && straight[1] == 1 && straight[2] == 1 && straight[3] == 1)
            count[2] = 1;
        
        
        
        
        if(count[2] == 1 && count[4] == 1){
            System.out.println("ストレートフラッシュ");
            return 8;
        }
        else if(count[1] == 2){
            System.out.println("フォーカード");
            return 7;
        }
        else if(count[1] == 1 && count[0] == 1){
            System.out.println("フルハウス");
            return 6;
        }
        else if(count[4] == 1){
            System.out.println("フラッシュ");
            return 5;
        }
        else if(count[2] == 1){
            System.out.println("ストレート");
            return 4;
        }
        else if(count[1] == 1){
            System.out.println("スリーカード");
            return 3;
        }
        else if(count[0] == 2 && count[4] <= 1){    
            System.out.println("ツーペア");
            return 2;
        }
        else if(count[0] == 1 && count[4] == 0){
            System.out.println("ワンペア");
            return 1;
        }
        else{
            System.out.println("ハイカード");
            return 0;
        }
    }
    
    
    
    
}
