import java.util.Scanner;
import java.util.Random;
import java.lang.StringBuilder;

public class DndDice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a dice role (#d#):");

        String diceRoll = scanner.nextLine();

        System.out.println(diceAmount(diceRoll));
    }

    private static String diceAmount(String diceRoll) throws IllegalArgumentException {
        String [] rolls = diceRoll.split("d");

        if (rolls.length != 2) {
            throw new IllegalArgumentException("Format dice roll i.e. 3d5. Given argument: " + diceRoll);
        }

        int numDiceRolls;
        int diceSize;

        try {
            numDiceRolls = Integer.parseInt(rolls[0]);
            diceSize = Integer.parseInt(rolls[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Format dice roll i.e. 3d5. Given argument: " + diceRoll);
        }

        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        int totalRoll = 0;
        for (int i = 0; i < numDiceRolls; i++) {
            int randRoll = random.nextInt(diceSize) + 1;
            stringBuilder.append(randRoll).append(" ");
            totalRoll += randRoll;
        }

        stringBuilder.insert(0, "" + totalRoll + ": ");

        return stringBuilder.toString();
    }
}