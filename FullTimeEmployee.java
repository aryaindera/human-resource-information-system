public class FullTimeEmployee extends Employee {
    private double salary;

    public FullTimeEmployee(String id, String name, Department department, double salary) {
        super(id, name, department);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + "\nJenis Employee : Full-time";
    }
}
