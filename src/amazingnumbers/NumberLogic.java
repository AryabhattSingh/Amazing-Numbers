package amazingnumbers;

public class NumberLogic {

	protected static boolean evenTest(long number) {
        return number % 2 == 0;
    }

    protected static boolean buzzTest(long number) {
        return number % 10 == 7 || number % 7 == 0;
    }

    protected static boolean duckTest(long number) {
        String numberInString = String.valueOf(number);
        return numberInString.contains("0");
    }

    protected static boolean palindromTest(long number) {
        String numberInString = String.valueOf(number);
        for (int i = 0; i < numberInString.length() - 1; i++) {
            if (!(numberInString.charAt(i) == numberInString.charAt(numberInString.length() - i - 1))) {
                return false;
            }
        }
        return true;
    }

    protected static boolean gapfulTest(long number) {
        if (number < 100) {
            return false;
        } else {
            String numberInString = String.valueOf(number);
            String chainOfDivisor = String.valueOf(numberInString.charAt(0)) + numberInString.charAt(numberInString.length() - 1);
            int divisor = Integer.parseInt(chainOfDivisor);
            return number % divisor == 0;
        }
    }

    protected static boolean spyTest(long number) {
        int productOfDigits = 1;
        int sumOfDigits = 0;
        while (number > 0) {
            productOfDigits *= number % 10;
            sumOfDigits += number % 10;
            number /= 10;
        }

        return sumOfDigits == productOfDigits;
    }

    protected static boolean squareTest(long number) {
        return Math.sqrt(number) - Math.floor(Math.sqrt(number)) == 0;
    }

    protected static boolean sunnyTest(long number) {
        return squareTest(number + 1);
    }

    protected static boolean jumpingTest(long number) {
        char[] digitsOfNumber = String.valueOf(number).toCharArray();
        for (int i = 0; i < digitsOfNumber.length - 1; i++) {
            boolean operation = Math.abs(Character.getNumericValue(digitsOfNumber[i]) -
                    Character.getNumericValue(digitsOfNumber[i + 1])) == 1;
            if (!operation) {
                return false;
            }
        }
        return true;
    }
}
