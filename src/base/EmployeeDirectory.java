package base;

import exceptions.EmployeeAlAddedException;
import exceptions.EmployeeIsNotException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeDirectory implements Iterable<Employee>{
    private List<Employee> employees;


    public EmployeeDirectory(EmployeeDirectory directory) {
        this.employees = List.copyOf(directory.getDirectory());
    }

    public EmployeeDirectory(List<Employee> employees) {
        this.employees = new ArrayList<>();
        for (Employee e:employees) {
            this.employees.add(e);
        }
    }
    public EmployeeDirectory() {
        this(new ArrayList<>());
    }

    public List<Employee> getDirectory() {
        return employees;
    }

    public Employee getEmployee(int id) throws EmployeeIsNotException {
        for (Employee e:employees) {
            if(e.getId() == id){
                return e;
            }
        }
        throw new EmployeeIsNotException(
                String.format("ОШИБКА! Сотрудник с id:%d в справочнике отсутствует.",id));
    }

    public void showEmployeesPhone(String name) {
        boolean f = true;
        for (Employee e:employees) {
            if(e.getName().equals(name)){
                f = false;
                System.out.printf("Employ id: %d, name: %s, phone: %s\n", e.getId(), name, e.getPhone());
            }
        }
        if(f) {
            System.out.printf("Сотрудника с именем \"%s\" нету в справочнике.\n", name);
        }
        System.out.println();
    }

    public void showEmployeeBySeniority(int seniority) {
        boolean f = true;
        for (Employee e:employees) {
            if(e.getSeniority() == seniority){
                f = false;
                System.out.printf("Employ id: %d, name: %s, seniority: %d\n", e.getId(), e.getName(), seniority);
            }
        }
        if(f) {
            System.out.printf("Сотрудника со стажем \"%d\" нету в справочнике.\n", seniority);
        }
        System.out.println();
    }

    public void add(Employee employee) throws EmployeeAlAddedException {
        for (Employee e:employees) {
            if(e.equals(employee)){
                throw new EmployeeAlAddedException(
                        String.format("ОШИБКА! Сотрудник с id:%d уже добавлен в справочник.",
                                employee.getId()));
            }
        }
        employees.add(employee);

   }

    @Override
    public Iterator<Employee> iterator() {
        return employees.iterator();
    }
}
