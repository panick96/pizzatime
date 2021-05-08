import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        InputService inputObj = new InputService();
        Logic logicObj = new Logic();
        inputObj.promptStore(in);
        inputObj.promptRank(in);

        logicObj.importArrays(inputObj.getStores(), inputObj.getRanks(), inputObj.getCats());
        logicObj.promptImportantCats(in);
        logicObj.calculateScores();
        int [] arrOfScores = logicObj.getScores();
        String [] arrOfStores = inputObj.getStores();
        

        in.close();
        for(int i=0; i < arrOfScores.length; i++){
            System.out.println("Store #" + (i+1) + ": " + arrOfStores[i] + " --- Score: " + arrOfScores[i] + "pts.");
        }
    }
}