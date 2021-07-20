public class Menu {
    private Menu() {
    }

    private static final String MENU_STRING = "\nMenu: ";

    public static void basicMenu(){
        String menu = MENU_STRING +
                "\n   1 - Basic level students options" +
                "\n   2 - Superior level students options" +
                "\n   3 - Services options" +
                "\n   4 - Show Revenue by type" +
                "\n   5 - Show All revenue" +
                "\n   0 - Exit";
        System.out.println(menu);
    }

    public static void advancedMenu(){
        String advancedMenu = MENU_STRING +
                "\n   1 - Register new" +
                "\n   2 - Update existing" +
                "\n   3 - Delete existing" +
                "\n   4 - Show all" +
                "\n   5 - Show specific" +
                "\n   0 - Return";
        System.out.println(advancedMenu);
    }

    public static void advancedMenuForBasicStudents(){
        String advancedMenu = MENU_STRING +
                "\n   1 - Register new" +
                "\n   2 - Update existing" +
                "\n   3 - Delete existing" +
                "\n   4 - Show all" +
                "\n   5 - Show specific" +
                "\n   6 - Update Monthly Payment" +
                "\n   0 - Return";
        System.out.println(advancedMenu);
    }

    public static void separator(){
        System.out.println("\n---------------\n");
    }

    public static void specificRevenueMenu(){
        String specificRevenueMenu = MENU_STRING +
                "\n   1 - Basic level students revenue" +
                "\n   2 - Services revenue" +
                "\n   3 - Superior level students revenue";
        System.out.println(specificRevenueMenu);
    }
}


