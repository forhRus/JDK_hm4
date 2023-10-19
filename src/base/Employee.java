package base;

public class Employee implements Comparable<Employee>{
    private int id, seniority;
    private String phone, name;

    public Employee(int id,  String name, String phone, int seniority) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Employee employee = (Employee) o;

        return id == employee.getId();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", seniority=" + seniority +
                '}';
    }
}
