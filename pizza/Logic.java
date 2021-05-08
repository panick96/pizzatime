import java.util.Scanner;

public class Logic {
    String [] arrayOfStores; 
    int [][] arrayOfRanks;
    String[] rankingCats;
    int[][] arrayOfWeightedRanks;
    int[] arrayOfScores;
    
    public void importArrays(String [] arrOfStores, int [][] arrOfRanks, String[] arrOfCats){
        arrayOfStores = arrOfStores;
        arrayOfRanks = arrOfRanks;
        rankingCats = arrOfCats;
    }
    public void promptImportantCats(Scanner in){
        //Calls a new scanner
        Scanner input = new Scanner(System.in);

        //Gets input for user's favorite category
        System.out.println("What is the most important category to you?");
        for (int i=0; i < rankingCats.length; i++ ){
            System.out.println((i+1) + ". " + rankingCats[i]);            
            }
        int bestCat = input.nextInt();
        input.nextLine();
        int bestCatIndex = bestCat - 1;
        
        //Gets input for user's least favorite category
        System.out.println("What is the least important category to you?");
        for (int i=0; i < rankingCats.length; i++ ){
            System.out.println((i+1) + ". " + rankingCats[i]);            
            }
        int worstCat = input.nextInt();
        input.nextLine();

        //Checks to see if worst category == best category
        boolean cheater = true;
        while (cheater){
            if ((int) bestCat == (int) worstCat){
                System.out.println("You cannot choose your best category as your worst category.");
                System.out.println("What is the least important category to you?");
                for (int i=0; i < rankingCats.length; i++ ){
                    System.out.println((i+1) + ". " + rankingCats[i]);            
                 }
                worstCat = input.nextInt();
                input.nextLine();
            } else {
                cheater = false;
            }
        }
        int worstCatIndex = worstCat - 1;
        arrayOfWeightedRanks = new int [arrayOfStores.length][rankingCats.length];
        for (int i=0; i < arrayOfStores.length; i++){
            for (int j=0; j < rankingCats.length; j++){
                if(j == (int) bestCatIndex){
                    arrayOfWeightedRanks[i][j] = (int)Math.ceil((arrayOfRanks[i][j]) * 1.5);
                }else if(j==(int) worstCatIndex) {
                    arrayOfWeightedRanks[i][j] = (int)Math.ceil((arrayOfRanks[i][j]) * 0.5);
                } else {
                    arrayOfWeightedRanks[i][j] = arrayOfRanks[i][j];
                }
            }
        }       
    }
    public int[][] getWeightedArray(){
        return arrayOfWeightedRanks;
    }
    public void calculateScores(){
        arrayOfScores = new int[arrayOfStores.length];
        int sum = 0;
        for(int i=0; i < arrayOfStores.length; i++){
            for(int j=0; j < rankingCats.length; j++){
                sum = sum + arrayOfWeightedRanks[i][j];
                if ((int)j == (rankingCats.length - 1)){
                    arrayOfScores[i] = sum / rankingCats.length;
                    sum = 0;
                }
            }
        }
    }
    public int[] getScores(){
        return arrayOfScores;
    }
}
