package util;

import model.Master;
import model.Students;
import model.stu_mas;
import service.MasterService;
import service.StuMasService;
import service.StudentService;

import java.util.List;
import java.util.Scanner;

public class ShowMenu {
    Scanner scanner = new Scanner(System.in);
    Students students = new Students();
    Master master = new Master();
    stu_mas stuMas = new stu_mas();
    StuMasService stuMasService = new StuMasService();
    StudentService studentService = new StudentService();
    MasterService masterService = new MasterService();


    public void info() {


        System.out.println("HI Welcome TO DBSM JavaUniversity" +
                "\n 1 : Insert new  Student for StudentTable " +
                "\n 2 : Deleted Student from StudentTable " +
                "\n 3 : Display Student Information" +
                "\n 4 : Insert new  Master for MasterTable " +
                "\n 5 : Deleted Master from MasterTable" +
                "\n 6 : Display Master Information" +
                "\n 7 : Insert sample for MasterStudent Table" +
                "\n 8 : Deleted sample from MasterStudent Table" +
                "\n 9 : Display MasterStudent Information" +
                "\n10 : view Students For Specified Master" +
                "\n11 : Exit");

    }

    public void choosingInfo(int input) {


        if (input == 1) {
            System.out.println("plz enter Student ID");
            students.setSID(scanner.nextInt());
            System.out.println("enter Student First Name");
            students.setSFname(scanner.next());
            System.out.println("enter Student Last Name");
            students.setSLname(scanner.next());
            studentService.saveStu(students);
        } else if (input == 2) {
            System.out.println("plz enter StudentID");
            studentService.delet(scanner.nextInt());
        } else if (input == 3) {
            List<Students> students1 = studentService.loadStu();
            for (Students model : students1) {
                System.out.println(model);
            }
        } else if (input == 4) {
            System.out.println("plz enter Master ID");
            master.setMID(scanner.nextInt());
            System.out.println("enter Masteer First Name");
            master.setMFname(scanner.next());
            System.out.println("enter Master Last Name");
            master.setMLname(scanner.next());
            masterService.saveMas(master);
        } else if (input == 5) {
            System.out.println("plz enter MasterID");
            masterService.deletedMas(scanner.nextInt());
        } else if (input == 6) {
            List<Master> masters = masterService.loadAllMas();
            for (Master model : masters) {
                System.out.println(model);
            }
        } else if (input == 7) {
            stuMas.setSID_m(14);
            stuMas.setMID_m(45);
            stuMasService.save(stuMas);
        } else if (input == 8) {
            int temp = dispStuForMaster();
            System.out.println("PLz choosing StudentID");
            stuMasService.delete(scanner.nextInt(), temp);
        } else if (input == 9) {
            List<stu_mas> stuMasLis = stuMasService.loadAll();
            for (stu_mas model : stuMasLis) {
                System.out.println(model);
            }
        } else if (input == 10) {
            dispStuForMaster();
        } else if (input == 11) {


        }

    }

    public int dispStuForMaster() {
        System.out.println("plz enter Master ID");
        int temp = scanner.nextInt();
        List<Students> students2 = stuMasService.listOfStuForMaster(temp);
        for (Students model : students2) {
            System.out.println(model);
        }
        return temp;
    }
}


