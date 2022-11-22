//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyNhanVien {
    public List<NhanVien> dsNhanVien = new ArrayList();
    public Scanner scanner;

    public QuanLyNhanVien() {
        this.scanner = new Scanner(System.in);
    }

    public void show() {
        System.out.println("Danh sach " + this.dsNhanVien.size() + " nhan vien:");

        for (int i = 0; i < this.dsNhanVien.size(); ++i) {
            System.out.println(this.dsNhanVien.get(i));
        }

    }

    public void add() {
        NhanVien newNhanVien = new NhanVien();
        newNhanVien.inputInfo();
        this.dsNhanVien.add(newNhanVien);
    }

    public int findIndexById(int id) {
        for (int i = 0; i < this.dsNhanVien.size(); ++i) {
            if (((NhanVien) this.dsNhanVien.get(i)).getId() == id) {
                return i;
            }
        }

        return -1;
    }

    public void edit() {
        int id;
        do {
            try {
                System.out.println("Nhap id can sua: ");
                id = Integer.parseInt(this.scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("nhap so");
            }
        } while (true);
        int index = this.findIndexById(id);
        if (index == -1) {
            System.out.println("Khong tim thay!");
        } else {
            ((NhanVien) this.dsNhanVien.get(index)).inputInfo();
        }

    }

    public void deleteById() {
        int id;
        do {
            try {
                System.out.println("Nhap id can sua: ");
                id = Integer.parseInt(this.scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("nhap so");
            }
        } while (true);
        int index = this.findIndexById(id);
        if (index == -1) {
            System.out.println("Khong tim thay!");
        } else {
            this.dsNhanVien.remove(index);
        }

    }

    public ArrayList<NhanVien> findByName(String name) {
        ArrayList<NhanVien> list = new ArrayList();

        for (int i = 0; i < this.dsNhanVien.size(); ++i) {
            if (((NhanVien) this.dsNhanVien.get(i)).getName().equals(name)) {
                list.add((NhanVien) this.dsNhanVien.get(i));
            }
        }

        return list;
    }

    public void sortBySalary() {
        this.dsNhanVien.sort(NhanVien::compareTo);
    }

    public void top3Salary() {
        if (this.dsNhanVien.size() < 3) {
            System.out.println("?");
        } else {
            this.sortBySalary();
            System.out.println(((NhanVien) this.dsNhanVien.get(0)).toString());
            System.out.println(((NhanVien) this.dsNhanVien.get(1)).toString());
            System.out.println(((NhanVien) this.dsNhanVien.get(2)).toString());
        }
    }

    private void birthdayInMurrentMonth(int month) {
        for (int i = 0; i < this.dsNhanVien.size(); ++i) {
            if (((NhanVien) this.dsNhanVien.get(i)).getBirthday().getMonthValue() == month) {
                System.out.println(((NhanVien) this.dsNhanVien.get(i)).toString());
            }
        }

    }

    public static void main(String[] args) {
        String menu = "1.Show\n2.Add new\n3.Delete by id\n4.Edit by id\n5.Find by name\n6.Top 3 salary\n7.Output birthday in current month\n8.Exit\nInput your choice here:";
        Scanner scanner = new Scanner(System.in);
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        int choice;

        while (true) {
            do {
                try {
                    System.out.println(menu);
                    int num = Integer.parseInt(scanner.nextLine());
                    if (num < 1 || num > 8) throw new RuntimeException();
                    choice = num;
                    break;
                } catch (NumberFormatException e) {
                    System.out.println(" nhap so");
                } catch (RuntimeException e) {
                    System.out.println(" nhap trong khoang 1 den 8");
                }
            }
            while (true);
            switch (choice) {
                case 1:
                    quanLyNhanVien.show();
                    break;
                case 2:
                    quanLyNhanVien.add();
                    break;
                case 3:
                    quanLyNhanVien.deleteById();
                    break;
                case 4:
                    quanLyNhanVien.edit();
                    break;
                case 5:
                    System.out.println(quanLyNhanVien.findByName("sy"));
                    break;
                case 6:
                    quanLyNhanVien.top3Salary();
                    break;
                case 7:
                    quanLyNhanVien.birthdayInMurrentMonth(LocalDate.now().getMonthValue());
                    break;
                case 8:
                    System.exit(0);
            }
        }
    }
}


