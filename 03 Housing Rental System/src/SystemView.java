/*
1. Displaying the interface
2. Receive user's input
3. Calling HouseService to complete various operations on house information.
 */
public class SystemView {
    private boolean loop = true;
    private char key = ' ';
    private SystemService systemService = new SystemService(5);

    //add house listing for 1. New listing
    public void addHouse() {
        System.out.println("********Add House Listing********");
        System.out.print("name ");
        String name = Tools.readString(10); //maximum length: 10
        System.out.print("city ");
        String city = Tools.readString(10); //maximum length: 10
        System.out.print("rent ");
        int rent = Tools.readInt();
        System.out.print("status ");
        String status = Tools.readString(10); //maximum length: 10
        HousingDomain newHouse = new HousingDomain(0, name, city, rent, status);
        if (systemService.add(newHouse)) {
            System.out.println("*****Add listing successfully*****");
        } else {
            System.out.println("*****Failed to add listing*****");
        }
    }

    //2. Search for house
    public void searchHouse() {
        System.out.println("********House Searching********");
        System.out.print("Please type in the listing Id: ");
        int searchID =  Tools.readInt();
        HousingDomain house = systemService.houseInfo(searchID);
        if (house != null) {
            System.out.println(house);
        } else {
            System.out.println("********Id is not available********");
        }
    }

    //delete house listing for 3. Delete housing information
    public void deleteHouse() {
        System.out.println("********Delete house listing********");
        System.out.print("Please type id to delete(type -1 to exit): ");
        int delID = Tools.readInt();
        if (delID == -1) {
            System.out.println("********Leaving delete menu********");
            return;
        }

        char choice = Tools.readConfirmSelection();
        if (choice == 'Y') { //uppercased in readConfirmSelection()
            if (systemService.del(delID)) {
                System.out.println("********Delete successfully********");
            } else {
                System.out.println("********Id not available********");
            }
        } else {
            System.out.println("********Leaving delete menu********");
        }
    }

    //4. Update housing information
    public void updateHouse() {
        System.out.println("********Update house listing********");
        System.out.print("Please type id to update(type -1 to exit): ");
        int updateID = Tools.readInt();
        if (updateID == -1) {
            System.out.println("********Leaving update menu********");
            return;
        }
        HousingDomain house = systemService.update(updateID);
        if (house == null) {
            System.out.println("********Id is not available********");
            return;
        }
        System.out.println("Note: use Enter to skip the update");
        System.out.print("name (" + house.getName() +"): ");
        String name = Tools.readString(10, "");
        if (!"".equals(name)) {
            house.setName(name);
        }

        System.out.print("city (" + house.getCity() +"): ");
        String city = Tools.readString(10, "");
        if (!"".equals(city)) {
            house.setCity(city);
        }

        System.out.print("rent (" + house.getRent() +"): ");
        int rent = Tools.readInt(-1);
        if (rent != -1) {
            house.setRent(rent);
        }

        System.out.print("status (" + house.getStatus() +"): ");
        String status = Tools.readString(10, "");
        if (!"".equals(status)) {
            house.setStatus(status);
        }

        System.out.println("********Update successfully********");
    }

    //show house listings for 5. Housing list
    public void listHouse() {
        System.out.println("********House Listings********");
        System.out.println("ID\t\tOwner\t\tCity\t\tRent\t\tStatus");
        HousingDomain[] houses = systemService.list();
        for(int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;
            }
            System.out.println(houses[i]); // toString() is called here automatically
        }
    }

    //6. Exit
    public void exit() {
        char choice = Tools.readConfirmSelection();
        if (choice == 'Y') {
            loop = false;
        }
    }

    //display main menu and provide choices
    public void mainMenu() {
        do {
            System.out.println("********Housing Rental System Menu********");
            System.out.println("1. New listing");
            System.out.println("2. Search for housing");
            System.out.println("3. Delete housing information");
            System.out.println("4. Update housing information");
            System.out.println("5. Housing list");
            System.out.println("6. Exit");
            System.out.print("Please enter your choice: ");
            key = Tools.readChar();
            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    searchHouse();
                    break;
                case '3':
                    deleteHouse();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    listHouse();
                    break;
                case '6':
                    exit();
            }
        } while (loop);
    }
}
