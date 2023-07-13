package amazingnumbers;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	 public static void main(String[] args) {
	        final String appName = "Welcome to Amazing Numbers!\n";
	        System.out.println(appName);
	        Model.printInstruction();

	        Scanner scanner = new Scanner(System.in);
	        long number = 1;
	        int len = 0;
	        final String[] properties = {"even", "odd", "buzz", "duck", "palindromic", "gapful", "spy", "square", "sunny", "jumping"};

	        do {
	            System.out.print("\nEnter a request: ");
	            String decision = scanner.nextLine().toLowerCase();
	            String[] choiceDetermination = decision.split(" ");
	            String[] propertiesToSeek = new String[1];
	            boolean isNatural = true;
	            boolean propertyChecked = true;

	            if (decision.isEmpty()) {
	                Model.printInstruction();
	                continue;
	            }

	            if ((int)decision.charAt(0) > 57 || (int)decision.charAt(0) < 48) {
	                System.out.println("\nThe first parameter should be a natural number or zero.");
	                continue;
	            }

	            if (choiceDetermination.length > 2) {
	                propertiesToSeek = new String[choiceDetermination.length - 2];
	            }

	            int amountOfCorrectProperties = 0;
	            boolean propertyIncorrect = false;
	            switch (choiceDetermination.length) {
	                case 1 -> {
	                    number = Long.parseLong(choiceDetermination[0]);
	                    len = 0;
	                }
	                case 2 -> {
	                    number = Long.parseLong(choiceDetermination[0]);
	                    len = Integer.parseInt(choiceDetermination[1]);
	                    propertiesToSeek[0] = "";
	                }
	                default -> {
	                    number = Long.parseLong(choiceDetermination[0]);
	                    len = Integer.parseInt(choiceDetermination[1]);
	                    System.arraycopy(choiceDetermination, 2, propertiesToSeek, 0, propertiesToSeek.length);
	                    for (String value : propertiesToSeek) {
	                        amountOfCorrectProperties = 0;
	                        for (String s : properties) {
	                            if (value.equals(s)) {
	                                isNatural = true;
	                                propertyChecked = true;
	                                break;
	                            } else {
	                                isNatural = false;
	                                propertyChecked = false;
	                                amountOfCorrectProperties++;
	                            }
	                        }
	                        if (amountOfCorrectProperties == properties.length) {
	                            propertyIncorrect = true;
	                            break;
	                        }
	                    }
	                }
	            }

	            if (!propertyChecked || propertyIncorrect) {
	                Model.printPropertiesError(properties, propertiesToSeek);
	                continue;
	            }

	            if (!Property.checkOpposedProperty(Arrays.toString(propertiesToSeek)))
	                continue;

	            if (number < 0L || len < 0) {
	                System.out.println("\nThe first parameter should be a natural number or zero.");
	                System.out.println("The second parameter should be a natural number.");
	                isNatural = false;
	            }

	            if (isNatural && number != 0L && len != 0) {
	                Number numberProperty = new Number(number, len, propertiesToSeek);
	                numberProperty.getProperties();
	            } else if (isNatural && number != 0L) {
	                Number numberProperty = new Number(number);
	                numberProperty.getProperties();
	            }

	        } while (number != 0);

	        scanner.close();
	        System.out.println("\nGoodbye!");
	    }
}
