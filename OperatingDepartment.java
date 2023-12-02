public class OperatingDepartment extends Department {
    public OperatingDepartment(double hourlyRate) {
        super("Operasional", hourlyRate);
    }

    @Override
    public double calculatePayroll(Employee employee) {
        double hourlyRate = getHourlyRate();
        if (employee instanceof ContractEmployee) {
            int hoursWorked = ((ContractEmployee) employee).getHoursWorked();
            return hoursWorked * hourlyRate;
        } else {
            return (employee.calculateSalary());
        }
    }
}
