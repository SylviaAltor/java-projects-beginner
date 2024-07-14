/*
1. Define House[] ,save the House object
2. Provide supports for SystemView class
 */

public class SystemService {
    private static HousingDomain[] houses;
    private int houseNum = 1;
    private int idCounter = 1;

    //details for House array
    public SystemService(int size) {
        houses = new HousingDomain[size];
        //for testing
        houses[0] = new HousingDomain(1, "Sylvia", "Ottawa", 1900, "available");
    }

    public HousingDomain[] list() {
        return houses;
    }

    //add new listing for addHouse(), option 1
    public boolean add(HousingDomain newHouse) {
        if (houseNum == houses.length) {
            System.out.println("Reach the maximum number of listings. " +
                    "Can't add more.");
            return false;
        }
        houses[houseNum++] = newHouse;
        newHouse.setId(++idCounter);
        return true;
    }

    //provide searching function for searchHouse(), option 2
    public HousingDomain houseInfo(int searchID) {
        for (int i = 0; i < houseNum; i++) {
            if (searchID == houses[i].getId()) {
                return houses[i];
            }
        }
        return null;
    }

    //delete listing for deleteHouse(), option 3
    public boolean del(int delID) {
        int index = -1;
        for (int i = 0; i < houseNum; i++) {
            if (delID == houses[i].getId()) {
                index = i;
            }
        }
        if (index == -1) {
            return false;
        }
        for (int i = index; i < houseNum - 1; i++) {
            houses[i] = houses[i + 1];
        }
        houses[--houseNum] = null;
        return true;
    }

    //update listing for updateHouse(), option 4
    public HousingDomain update(int updateID) {
        for (int i = 0; i < houseNum; i++) {
            if (updateID == houses[i].getId()) {
                return houses[i];
            }
        }
        return null;
    }
}
