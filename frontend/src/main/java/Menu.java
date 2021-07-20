public class Menu {
    private Menu() {
    }

    public static void basicMenu(){
        String menu = "\nMenu: " +
                "\n   1 - Basic level students options" +
                "\n   2 - Superior level students options" +
                "\n   3 - Services options" +
                "\n   4 - All revenue" +
                "\n   0 - Exit";
        System.out.println(menu);;
    }

    public static void advancedMenu(){
        String advancedMenu = "\nMenu: " +
                "\n   1 - Register new" +
                "\n   2 - Update existing" +
                "\n   3 - Delete existing" +
                "\n   4 - Show all" +
                "\n   5 - Show specific" +
                "\n   0 - Return";
        System.out.println(advancedMenu);
    }

    public static void separator(){
        System.out.println("\n---------------\n");
    }
}


