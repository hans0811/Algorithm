package func.theory;

/**
 * @author hans
 */
public class Company implements Cloneable {

    private static final long serialVersion = 1L;

    private String name;

    private String address;

    public Company(String name, String address){
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                " " + serialVersion + '\'' +
                '}';
    }
}
