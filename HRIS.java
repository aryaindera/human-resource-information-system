import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.DecimalFormat;
public class HRIS {
    private List<Employee> employees;
    private List<Department> departments;

    public HRIS() {
        employees = new ArrayList<>();
        departments = new ArrayList<>();
        initializeDepartments();
    }

    private void initializeDepartments() {
        departments.add(new FinanceDepartment(190000)); // Hourly rate for finance department
        departments.add(new MarketingDepartment(180000)); // Hourly rate for marketing department
        departments.add(new OperatingDepartment(200000)); // Hourly rate for operating department
    }

    public void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nMasukkan ID Employee: ");
        String id = scanner.next();
        System.out.print("Masukkan nama Employee: ");
        String name = scanner.next();
        System.out.print("Pilih Department (Keuangan, Pemasaran, Operasional): ");
        String department = scanner.next();

        // Check if the department is valid
        Department selectedDepartment = null;
        for (Department dep : departments) {
            if (dep.getDepartmentName().equalsIgnoreCase(department)) {
                selectedDepartment = dep;
                break;
            }
        }

        if (selectedDepartment != null) {
            System.out.println("Jenis Employee :");
            System.out.println("1. Full-time Employee");
            System.out.println("2. Contract Employee");
            System.out.print("Masukkan jenis employee : ");
            int employeeType = scanner.nextInt();

            switch (employeeType) {
                case 1:
                    System.out.print("Jumlah pendapatan: ");
                    double salary = scanner.nextDouble();
                    Employee fullTimeEmployee = new FullTimeEmployee(id, name, selectedDepartment, salary);
                    employees.add(fullTimeEmployee);
                    break;
                case 2:
                    System.out.print("Jumlah Jam Kerja: ");
                    int hoursWorked = scanner.nextInt();
                    Employee contractEmployee = new ContractEmployee(id, name, selectedDepartment, hoursWorked);
                    employees.add(contractEmployee);
                    break;
                default:
                    System.out.println("Jenis Employee tidak valid.");
            }

            System.out.println("Employee berhasil ditambahkan.");
        } else {
            System.out.println("Department tidak valid.");
        }
    }

    public void removeEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan ID Employee yang akan dihapus : ");
        String removeId = scanner.next();
        Employee employeeToRemove = null;
        for (Employee employee : employees) {
            if (employee.getId().equals(removeId)) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employees.remove(employeeToRemove);
            System.out.println("Employee Dengan ID " + removeId + " berhasil dihapus.");
        } else {
            System.out.println("Employee Dengan ID " + removeId + " tidak ditemukan.");
        }
    }

    public void displayEmployees() {
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("\nDaftar Employee :");
        for (Employee employee : employees) {
            System.out.println("--------------------");
            System.out.println(employee);
            System.out.println("Pendapatan: Rp" + df.format(employee.calculateSalary()));
            System.out.println("--------------------");
        }
    }

    public void processPayroll() {
        System.out.println("Memproses pendapatan:");
        for (Employee employee : employees) {
            System.out.println("--------------------");
            System.out.println(employee);
            double payroll = employee.getDepartment().calculatePayroll(employee);
            System.out.println("Pendapatan: Rp" + payroll);
            System.out.println("--------------------");
        }
    }

    public static void main(String[] args) {
        HRIS hris = new HRIS();
        Scanner scanner = new Scanner(System.in);
        int Pilihan;

        do {
            System.out.println("\nHUMAN RESOURCE INFORMATION SYSTEMS:");
            System.out.println("===================================");
            System.out.println("1. Tambah Employee");
            System.out.println("2. Hapus Employee");
            System.out.println("3. Tampilkan Employees");
            System.out.println("0. Keluar");
            System.out.print("Masukkan Pilihan: ");
            Pilihan = scanner.nextInt();

            switch (Pilihan) {
                case 1:
                    hris.addEmployee();
                    break;
                case 2:
                    hris.removeEmployee();
                    break;
                case 3:
                    hris.displayEmployees();
                    break;
                case 0:
                    System.out.println("Keluar...");
                    break;
                default:
                    System.out.println("Pilihan Anda Tidak Valid1.");
            }
        } while (Pilihan != 0);
    }
}
