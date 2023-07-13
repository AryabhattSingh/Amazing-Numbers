package amazingnumbers;

import java.util.Arrays;

public class Model {
	protected static void printInstruction() {
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be printed;");
        System.out.println("- two natural numbers and a property to search for;");
        System.out.println("- two natural numbers and two properties to search for;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
    }

    protected static void printPropertiesError(String[] availableProperties, String[] properties) {
        StringBuilder errorLine = new StringBuilder("The property [");
        int amountOfWrongProperties = 0;
        for (String word : properties) {
            boolean check = false;
            for (String compareFromAvailable : availableProperties) {
                if (word.equals(compareFromAvailable)) {
                    check = true;
                    break;
                }
            }

            if (!check) {
                errorLine.append(word).append(",");
                amountOfWrongProperties++;
            }

        }

        if (amountOfWrongProperties > 1) {
            errorLine.replace(4, 12, "properties").deleteCharAt(errorLine.length() - 1).append("] are wrong.");
        } else {
            errorLine.deleteCharAt(errorLine.length() - 1).append("] is wrong.");
        }
        System.out.println(errorLine);
        System.out.println("Available properties: " + Arrays.toString(availableProperties));
    }

    protected static void printPropertiesBlock(Number number) {
        System.out.println("Properties of " + number.getNumber());
        System.out.println("        buzz: " + number.isBuzz());
        System.out.println("        duck: " + number.isDuck());
        System.out.println(" palindromic: " + number.isPalindromic());
        System.out.println("      gapful: " + number.isGapful());
        System.out.println("         spy: " + number.isSpy());
        System.out.println("      square: " + number.isSquare());
        System.out.println("       sunny: " + number.isSunny());
        System.out.println("     jumping: " + number.isJumping());
        System.out.println("        even: " + number.isEven());
        System.out.println("         odd: " + number.isOdd());
    }

    protected static String printPropertiesLine(Number number) {
        StringBuilder lineResult = new StringBuilder(number.getNumber() + " is ");
        if (number.isBuzz())
            lineResult.append(" buzz,");
        if (number.isDuck())
            lineResult.append(" duck,");
        if (number.isPalindromic())
            lineResult.append(" palindromic,");
        if (number.isGapful())
            lineResult.append(" gapful,");
        if (number.isSpy())
            lineResult.append(" spy,");
        if (number.isSquare())
            lineResult.append(" square,");
        if (number.isSunny())
            lineResult.append(" sunny,");
        if (number.isJumping())
            lineResult.append(" jumping, ");
        if (number.isEven())
            lineResult.append(" even,");
        if (number.isOdd())
            lineResult.append(" odd,");

        lineResult.deleteCharAt(lineResult.length() - 1);
        return lineResult.toString();
    }
}
