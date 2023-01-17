import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import Model.AttendanceJournal;
import Model.AttendanceService;
import Model.Student;

public class Presenter {

    public void printStudents(AttendanceService service, int limit) {
        for (AttendanceJournal studentJournal : service.getAttendanceService()) {
            float days = 0;
            float visits = 0;
            LinkedHashMap<String, Boolean> journal = studentJournal.getJournal();
            for (Map.Entry<String, Boolean> entry : journal.entrySet()) {
                days++;
                if (entry.getValue()) {
                    visits++;
                }
            }
            int percentage = Math.round(visits / days * 100);
            if (percentage < limit) {
                StringBuffer sb = new StringBuffer();
                sb.append(studentJournal.getStudent().toString());
                sb.append(": " + percentage + "%");
                System.out.println(sb.toString());
            }
        }

    }

    public void printAllSortedStudents(AttendanceService service) {
        LinkedList<Student> list = new LinkedList<>();
        LinkedList<Integer> percentageList = new LinkedList<>();
        for (AttendanceJournal studentJournal : service.getAttendanceService()) {
            float days = 0;
            float visits = 0;
            LinkedHashMap<String, Boolean> journal = studentJournal.getJournal();
            for (Map.Entry<String, Boolean> entry : journal.entrySet()) {
                days++;
                if (entry.getValue()) {
                    visits++;
                }
            }
            int percentage = Math.round(visits / days * 100);
            if (list.isEmpty()) {
                list.add(studentJournal.getStudent());
                percentageList.add(percentage);
            } else {
                for (int index = 0; index < percentageList.size(); index++) {
                    if (percentageList.get(index) < percentage) {
                        percentageList.add(index, percentage);
                        list.add(index, studentJournal.getStudent());
                        break;
                    }
                    if (index == percentageList.size() - 1 && percentageList.get(index) > percentage) {
                        percentageList.add(index + 1, percentage);
                        list.add(index + 1, studentJournal.getStudent());
                        break;
                    }
                }
            }

        }
        for (int index = 0; index < list.size(); index++) {
            StringBuffer sb = new StringBuffer();
            sb.append(list.get(index).toString() + ": " + percentageList.get(index) + "%");
            System.out.println(sb);
        }

    }

}
