package org.example;

import org.example.controller.StudentDOA;
import org.example.model.Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static StudentDOA studentDOA=new StudentDOA();
    public static void menumain()
    {
        System.out.println("_____ Quan Ly Sinh Vien _____");
        System.out.println("1. Danh Sach Sinh Vien");
        System.out.println("2. Them Sinh Vien Moi");
        System.out.println("3. Xoa Mot Sinh Vien");
        System.out.println("4. Cap nhat thong tin sinh vien");
        System.out.println("5. Tim ra mot sinh vien theo ten hoac ma(gan dung)");
        System.out.println("6. sap xem sinh vien theo diem so GPA tang dan");
        System.out.println("7. In ra tat ca sinh vien o Ha noi co GPA tren 2.5");
        System.out.println("8. sap xep xinh vien tho ho ten,");
        System.out.println("0. thoat");
    }
    public static void option1()
    {
        List<Students> studentsList=new ArrayList<>();
        System.out.printf("%-20s %-20s %-20s %-20s", "ma sinh vien", "ten sinh vien", "gioi tinh", "dia chi");
        for (Students st:studentDOA.getAll1()) {
            System.out.println();
            String gioitinh;
            if(st.getGender()==1)
            {
                gioitinh="nu";
            }
            else
            {
                gioitinh="nam";
            }
            System.out.printf("%-20s %-20s %-20s %-20s\n", (st.getId()), st.getFull_name(),gioitinh,st.getAddress());
        }
    }
    public static void option2(Scanner sc)
    {
        StudentDOA addStudent= new StudentDOA();
        Students s= new Students();
        System.out.print("ma sinh vien \t");
        s.setId(sc.nextLine());
        System.out.print("ten sinh vien \t");
        s.setFull_name(sc.nextLine());
        System.out.print("ten gioi tinh (0 nam, 1 nu) \t");
        s.setGender(Integer.parseInt(sc.nextLine()));
        System.out.print("nhap vao ngay thang nam sinh \t");
        s.setNgaysinh(sc.nextLine());
        System.out.print("nhap vao phone number \t");
        s.setPhone(sc.nextLine());
        System.out.print("nhap vao email\t");
        s.setEmail(sc.nextLine());
        System.out.print("nhap vao dia chi\t");
        s.setAddress(sc.nextLine());
        System.out.print("nhap vao diem \t");
        s.setMarks(sc.nextDouble());

        addStudent.insertStudent(s);
        sc.nextLine();

    }
    public static void option3(Scanner sc)
    {
        List<Students> studentsList=new ArrayList<>();
        System.out.println("nhap ma nhan vien muon xoa");
        String id=sc.nextLine();
        studentDOA.delete(id);
    }
    public static void option4(Scanner sc)
    {
        StudentDOA updateStudent= new StudentDOA();
        Students s= new Students();
        System.out.println("nhap vao ma sinh vien");
        String ma=sc.nextLine();
        System.out.print("ten sinh vien \t");
        s.setFull_name(sc.nextLine());
        System.out.print("ten gioi tinh (0 nam, 1 nu) \t");
        s.setGender(Integer.parseInt(sc.nextLine()));
        System.out.print("nhap vao ngay thang nam sinh \t");
        s.setNgaysinh(sc.nextLine());
        System.out.print("nhap vao phone number \t");
        s.setPhone(sc.nextLine());
        System.out.print("nhap vao email\t");
        s.setEmail(sc.nextLine());
        System.out.print("nhap vao dia chi\t");
        s.setAddress(sc.nextLine());
        System.out.print("nhap vao diem \t");
        s.setMarks(sc.nextDouble());
        updateStudent.update(s,ma);
        sc.nextLine();
    }
    public static void option5(Scanner sc)
    {
        System.out.println("nhap vao tu khoa can tim kiem");
        String search=sc.nextLine();
        List<Students> studentsList=new ArrayList<>();

        studentDOA.getAll1().stream()
                .filter(h -> h.getFull_name().equalsIgnoreCase(search) || h.getId().equalsIgnoreCase(search))
                .sorted()
                .forEach(h -> System.out.println(h));
    }
    public static  void option6()
    {

    }
    public static  void option7()
    {

    }
    public static void main(String[] args) {




        Scanner sc= new Scanner(System.in);
        int option = -1;
        do {
            menumain();
            System.out.println("nhap lua chon cua ban");
            try{
                option = Integer.parseInt(sc.nextLine());
            }catch (Exception e)
            {
                System.out.println("nhap sai dinh dang");
                continue;
            }
            switch (option){
                case 1:
                    option1();
                    break;
                case 2:
                    option2(sc);
                    break;
                case 3:
                    option3(sc);
                    break;
                case 4:
                    option4(sc);
                    break;
                case 5:
                    option5(sc);
                    break;
            }
        }while (option !=0);
    }
}