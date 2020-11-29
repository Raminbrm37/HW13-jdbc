import model.Master;
import model.Students;
import model.stu_mas;
import service.MasterService;
import service.StudentService;
import service.StuMasService;
import util.ShowMenu;

import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        ShowMenu showMenu=new ShowMenu();
        while (true) {
            showMenu.info();
            showMenu.choosingInfo(scanner.nextInt());
        }

    }
}
