public class MarketingDepartment extends Department {
    public MarketingDepartment(double hourlyRate) {
        super("Pemasaran", hourlyRate);
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
