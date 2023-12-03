package mk.finki.ukim.diansproject.model;

public class CulturalPlace {
    private String name;
    private String category;
    private String phoneNumber;
    private String location;

    public CulturalPlace(String name, String category, String phoneNumber, String location) {
        this.name = name;
        this.category = category;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }

    public CulturalPlace(String name, String category, String location) {
        this.name = name;
        this.category = category;
        this.location = location;
        this.phoneNumber="";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "CulturalPlace{" +
                "name='" + name + '\'' +"\n"+
                ", category='" + category + '\'' +"\n"+
                ", phoneNumber='" + phoneNumber + '\'' +"\n"+
                ", location='" + location + '\'' +"\n"+
                '}';
    }
}
