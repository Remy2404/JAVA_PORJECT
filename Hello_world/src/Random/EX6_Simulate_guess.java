package Random;
public class EX6_Simulate_guess {

    public static void main(String[] args) {
        int games = 100;
        int PersonAWins =0;
        int PersonBwins = 0;
        
        for(int i =0 ; i <=games ;i++ ){
            int personA =1+ (int)(Math.random()*3);
            int personB =1+ (int)(Math.random()*3);
            if (personA==personB) {
                PersonAWins++;
            }else{
                PersonBwins++;
            }
            
        }
       System.out.println("Out of "+games+ "games , person A wins: "+PersonAWins);
       System.out.println("Person B wins: "+PersonBwins);
       
    
    }
}