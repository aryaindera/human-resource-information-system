public class ContractEmployee extends Employee {
    private int hoursWorked;

    public ContractEmployee(String id, String name, Department department, int hoursWorked) {
        super(id, name, department);
        this.hoursWorked = hoursWorked;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public double calculateSalary() {
        double hourlyRate = getDepartment().getHourlyRate();
        return hoursWorked * hourlyRate;
    }

    @Override
    public String toString() {
        return super.toString() + "\nJenis Employee: Contract\nJumlah Jam Kerja: " + hoursWorked;
    }
}
