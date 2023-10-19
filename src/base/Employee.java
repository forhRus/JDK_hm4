package base;

public class Employee implements Comparable<Employee>{
    private int id, seniority;
    private String phone, name;

    public Employee(int id, int seniority, String phone, String name) {
        this.id = id;
        this.seniority = seniority;
        this.phone = phone;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getSeniority() {
        return seniority;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public int compareTo(Employee o) {
        return name.compareTo(o.getName());
    }
}
