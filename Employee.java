public abstract class Employee {
    private String id;
    private String name;
    private Department department;

    public Employee(String id, String name, Department department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "ID Employee: " + id + "\nNama Employee : " + name + "\nDepartment: " + department.getDepartmentName();
    }
}
