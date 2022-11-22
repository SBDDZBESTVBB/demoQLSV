import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class NhanVien implements Comparable<NhanVien> {
    static int genId = 1;
    private int id;
    private String name;
    private double salary;
    private String gender;
    private LocalDate birthday;

    public NhanVien() {
    }

    public NhanVien(int id, String name, double salary, String gender, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.birthday = birthday;
    }

    public void inputInfo() {
        Scanner scanner = new Scanner(System.in);
        if (id <= 0) {
            this.id = NhanVien.genId;
            NhanVien.genId++;
        }
        System.out.println("Input name: ");
        this.name = scanner.nextLine();
        do {
            try {
                System.out.println("Input salary: ");
                Double salary = Double.parseDouble(scanner.nextLine());
                if (salary <= 0) throw new RuntimeException();
                this.salary = salary;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Nhap so vao");
            } catch (RuntimeException e) {
                System.out.println(" nhap luong lon hon 0");
            }
        } while (true);
while (true){
    try{
        System.out.println("Input gender: ");
        String gioitinh = scanner.nextLine();
        if(!gioitinh.equals("nam") && !gioitinh.equals("nu")) throw new RuntimeException();
        this.gender = gioitinh;
        break;}
    catch (RuntimeException e){
        System.out.println("Nhap cho dung");
    }
}

        int day, month, year;
        while (true) {
            do {
                try {
                    System.out.println("Input day of birth: ");
                    day = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Nhap so di");
                }
            } while (true);

            do {
                try {
                    System.out.println("Input month of birth: ");
                    month = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("nhap so di");
                }
            } while (true);

            do {
                try {
                    System.out.println("Input year of birth: ");
                    year = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Nhap so di");
                }
            } while (true);
            try {
                this.birthday = LocalDate.of(year, month, day);
                break;
            } catch (DateTimeException e) {
                System.out.println(" nhap lai");
            }
        }
    }

        public int getId () {
            return id;
        }

        public void setId ( int id){
            this.id = id;
        }

        public String getName () {
            return name;
        }

        public void setName (String name){
            this.name = name;
        }

        public double getSalary () {
            return salary;
        }

        public void setSalary ( double salary){
            this.salary = salary;
        }

        public String getGender () {
            return gender;
        }

        public void setGender (String gender){
            this.gender = gender;
        }

        public LocalDate getBirthday () {
            return birthday;
        }

        public void setBirthday (LocalDate birthday){
            this.birthday = birthday;
        }

        @Override
        public String toString () {
            return "Name: " + name + ", birthday: " + birthday + ", salary" + salary;
        }

        @Override
        public int compareTo (NhanVien nhanVien){
            if (this.salary > nhanVien.salary) {
                return 1;
            } else if (this.salary < nhanVien.salary) {
                return -1;
            } else {
                return 0;
            }
//        return this.salary == nhanVien.salary ? 0 : -1;
        }

        //    public static void main(String[] args) {
//        LocalDate test = LocalDate.of(2022, 10, 15);
//        System.out.println(test.getMonthValue());
//    }
    }
