public abstract class Department {
    private String departmentName;
    private double hourlyRate;

    public Department(String departmentName, double hourlyRate) {
        this.departmentName = departmentName;
        this.hourlyRate = hourlyRate;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public abstract double calculatePayroll(Employee employee);
}
