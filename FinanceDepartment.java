public class FinanceDepartment extends Department {
    public FinanceDepartment(double hourlyRate) {
        super("Keuangan", hourlyRate);
    }

    @Override
    public double calculatePayroll(Employee employee) {
        double hourlyRate = getHourlyRate();
        if (employee instanceof ContractEmployee) {
            int hoursWorked = ((ContractEmployee) employee).getHoursWorked();
            return hoursWorked * hourlyRate;
        } else {
            return employee.calculateSalary();
        }
    }
}
