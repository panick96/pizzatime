import java.util.Scanner;

public class InputService {
    //Instance variables
    int storeCount = 4;
    String [] arrayOfStores = {"Domino's", "Pizza Hut", "Little Caesars", "Papa John's"};
    String [] rankingCats = {"Crust", "Sauce", "Cheese", "Toppings", "Service"};
    int [][] arrayOfRanks = {{1,2,3},{4,5,6},{7,8,9}};

    public void promptStore(Scanner in) {
        //Gets input for the number of stores
        Scanner input = new Scanner(System.in);
        System.out.println("How many pizza places did you want to rank?\nPress 0 for the default stores. :");
        storeCount = input.nextInt();
        input.nextLine(); //This needs to be here to get rid of the \n that the nextInt() can't get rid of.

        //creates an array for the number of stores
        if (storeCount == (int) 0) {
            storeCount = 4;       
        } else {
            arrayOfStores = new String[storeCount];

            //loops through the number of stores you want to rank and allows you to name the stores
            for(int i = 0; i < storeCount; i++) {
                System.out.println("Store #" + (i+1));
                String storeName = input.nextLine();                               
                arrayOfStores[i] = storeName;
            storeCount = arrayOfStores.length;
        } 
    }     
    }  
    public void promptRank(Scanner in) {
        //Call the scanner class for inputs
        Scanner input = new Scanner(System.in);

        //Resize the arrayOfRanks
        arrayOfRanks = new int[storeCount][rankingCats.length];
        for(int i = 0; i < storeCount; i++){
            System.out.println("\n" + arrayOfStores[i]);
            for(int j = 0; j < rankingCats.length; j++){
                
                //Gets input for 2d array.
                System.out.println("Rank the " + rankingCats[j] + " from " + arrayOfStores[i]);
                int rank = 0;
                rank = input.nextInt();
                arrayOfRanks[i][j] = rank;
                input.nextLine();
            }
        }
    }
    public String [] getStores() {
        return arrayOfStores;
    }
    public String [] getCats() {
        return rankingCats;
    }
    public int [][] getRanks() {
        return arrayOfRanks;
    }
}
        
    
    