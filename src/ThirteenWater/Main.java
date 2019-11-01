package ThirteenWater;




import java.util.ArrayList;
import java.util.List;
import java.util.Random;




public class Main{

    public static void main(String[] args) {

       

        List<Card> allCards = new ArrayList<>();

        Random random = new Random();

        for (int i = 1;i <= 4; i++){

            for (int j = 1; j <= 13; j++){

                allCards.add(new Card(j,i));

            }

        }



        for (int i = 0; i < 10; i++){

            List<Card> tempCards = new ArrayList<>();

            List<Card> cards = new ArrayList<>();

            tempCards.addAll(allCards);
            String cardStr="";

            for (int j = 0; j < 13; j++){

                Card card = tempCards.get(random.nextInt(52 - j));

                cards.add(card);

                tempCards.remove(card);

            }

           /* String cardStr = "";

            for (int j = 0; j < 13; j++){

                Card card = cards.get(j);

                cardStr += card.toString();

                if (j < 12)

                    cardStr += " ";

            }*/
         System.out.println(cards);
         Player p=new Player();
         p.change(cards);
         String cFir="",cMid="",cTai="";
         for(int k=0;k<p.choice.head.size();k++)
         {
        	 Card c = p.choice.head.get(k);
        	 cFir += c.toString();
        	 if(k<p.choice.head.size()-1)
        	 {
        		 cFir +=" ";
        	 }
        	
         }
         for(int k=0;k<p.choice.mid.size();k++)
         {
        	 Card c = p.choice.mid.get(k);
        	 cMid += c.toString();
        	 if(k<p.choice.mid.size()-1)
        	 {
        		 cMid +=" ";
        	 }
        	
         } 
         for(int k=0;k<p.choice.end.size();k++)
         {
        	 Card c = p.choice.end.get(k);
        	 cTai += c.toString();
        	 if(k<p.choice.end.size()-1)
        	 {
        		 cTai +=" ";
        	 }
        	
         }
        if(p.choice.head.size()<1)
         {
        	 for(int m=0;m<p.choice.mid.size();m++)
        	 {
        		 for(int n=0;n<cards.size();n++)
        		 {
        			 if(p.choice.mid.get(m)==cards.get(n))
        			 {
        				 cards.remove(n);
        				 continue;
        			 }
        		 }
        	 }
        	 for(int m=0;m<p.choice.end.size();m++)
        	 {
        		 for(int n=0;n<cards.size();n++)
        		 {
        			 if(p.choice.end.get(m)==cards.get(n))
        			 {
        				 cards.remove(n);
        				 continue;
        			 }
        		 }
        	 }
        	 for (int j = 0; j < cards.size(); j++)
        	 {

                 Card cardc = cards.get(j);

                 cardStr += cardc.toString();

                 if (j < cards.size()-1)

                     cardStr += " ";

             }
         }
        if(p.choice.head.size()<1)
        {
        	System.out.println(cardStr);
        }
        else
        {
        	System.out.println(cFir);
        }
         System.out.println(cMid);//中墩
         System.out.println(cTai);//尾墩

           

           // System.out.println(cardStr);

      

        }

    
    }

}
