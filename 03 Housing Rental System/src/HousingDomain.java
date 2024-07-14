public class HousingDomain {
    private int id;
    private String name;
    private String city;
    private int rent;
    private String status;

    public HousingDomain() {
    }

    public HousingDomain(int id, String name, String city, int rent, String status) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.rent = rent;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  id + "\t\t" + name  + "\t\t" + city +
                "\t\t" + rent  + "\t\t" + status;
    }
}
