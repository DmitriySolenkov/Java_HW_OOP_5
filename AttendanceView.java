import Model.AttendanceJournal;
import Model.AttendanceService;
import Model.Student;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class AttendanceView {
    public static void main(String[] args) {
        ArrayList<AttendanceJournal> attendanceJournal = new ArrayList<AttendanceJournal>(10);
        Student studnet1 = new Student("Andrew", "Ivanov", "M432", 20);
        LinkedHashMap<String, Boolean> journal1 = new LinkedHashMap<String, Boolean>();
        journal1.put("10.01.2023", true);
        journal1.put("11.01.2023", true);
        journal1.put("12.01.2023", false);
        journal1.put("13.01.2023", true);
        journal1.put("16.01.2023", false);
        journal1.put("17.01.2023", true);
        attendanceJournal.add(new AttendanceJournal(studnet1, journal1));

        Student studnet2 = new Student("Nina", "Dobrew", "M321", 19);
        LinkedHashMap<String, Boolean> journal2 = new LinkedHashMap<String, Boolean>();
        journal2.put("10.01.2023", false);
        journal2.put("11.01.2023", true);
        journal2.put("12.01.2023", true);
        journal2.put("13.01.2023", true);
        journal2.put("16.01.2023", true);
        journal2.put("17.01.2023", true);

        attendanceJournal.add(new AttendanceJournal(studnet2, journal2));

        Student studnet3 = new Student("Alexey", "Lehin", "M411", 20);
        LinkedHashMap<String, Boolean> journal3 = new LinkedHashMap<String, Boolean>();
        journal3.put("10.01.2023", false);
        journal3.put("11.01.2023", false);
        journal3.put("12.01.2023", false);
        journal3.put("13.01.2023", true);
        journal3.put("16.01.2023", false);
        journal3.put("17.01.2023", false);

        attendanceJournal.add(new AttendanceJournal(studnet3, journal3));

        Student student4 = new Student("Vladimir", "Janov", "C101", 18);
        LinkedHashMap<String, Boolean> journal4 = new LinkedHashMap<String, Boolean>();
        journal4.put("10.01.2023", false);
        journal4.put("11.01.2023", false);
        journal4.put("12.01.2023", false);
        journal4.put("13.01.2023", false);
        journal4.put("16.01.2023", false);
        journal4.put("17.01.2023", false);

        attendanceJournal.add(new AttendanceJournal(student4, journal4));

        Student student5 = new Student("Elena", "Shishkina", "B102", 18);
        LinkedHashMap<String, Boolean> journal5 = new LinkedHashMap<String, Boolean>();
        journal5.put("10.01.2023", true);
        journal5.put("11.01.2023", true);
        journal5.put("12.01.2023", true);
        journal5.put("13.01.2023", true);
        journal5.put("16.01.2023", true);
        journal5.put("17.01.2023", true);

        attendanceJournal.add(new AttendanceJournal(student5, journal5));

        AttendanceService attendanceService = new AttendanceService(attendanceJournal);
        Presenter presenter = new Presenter();
        // presenter.printStudents(attendanceService, 101);
        // System.out.println("----------");
        // presenter.printAllSortedStudents(attendanceService);
        // System.out.println("----------");
        // presenter.printStudents(attendanceService, 25);

        System.out.println("Журнал загружен");
        while (true) {
            Scanner scanner = new Scanner(System.in, "cp866");
            System.out.println("____________________________");
            System.out.println("Для просмотра журналов посещаемости студентов введите 1,");
            System.out.println("Для просмотра процента посещаемости введите 2,");
            System.out.println("Для сортировки студентов по посещаемости введите 3");
            System.out.println("Для отображения студентов с посещаемостью меньше 25% введите 4:");
            System.out.println("Для выхода из журнала введите 5");
            String mode = scanner.nextLine();
            if (mode.equals("1")) {
                for (AttendanceJournal journal : attendanceService.getAttendanceService()) {
                    System.out.println(journal);
                }
            } else if (mode.equals("2")) {
                presenter.printStudents(attendanceService, 101);
            } else if (mode.equals("3")) {
                presenter.printAllSortedStudents(attendanceService);
            } else if (mode.equals("4")) {
                presenter.printStudents(attendanceService, 25);
            } else if (mode.equals("5")) {
                scanner.close();
                break;
            } else {
                System.out.println("Команда не распознана!");
            }

        }
    }
}
