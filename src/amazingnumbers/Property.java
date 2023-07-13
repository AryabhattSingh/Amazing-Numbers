package amazingnumbers;

public class Property {

	protected static boolean checkOpposedProperty(String properties) {
        if (properties.contains("even") && properties.contains("odd")) {
            System.out.println("The request contains mutually exclusive properties: [odd, even]");
            System.out.println("There are no numbers with these properties.");
            return false;
        } else if (properties.contains("spy") && properties.contains("duck")) {
            System.out.println("The request contains mutually exclusive properties: [spy, duck]");
            System.out.println("There are no numbers with these properties.");
            return false;
        } else if (properties.contains("sunny") && properties.contains("square")) {
            System.out.println("The request contains mutually exclusive properties: [sunny, square]");
            System.out.println("There are no numbers with these properties.");
            return false;
        }
        return true; 
    }
}
