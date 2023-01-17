package Model;

import java.util.LinkedHashMap;
import java.util.Map;

public class AttendanceJournal {
    protected Student student;
    protected LinkedHashMap<String, Boolean> journal;

    public AttendanceJournal(Student student, LinkedHashMap<String, Boolean> journal) {
        this.student = student;
        this.journal = journal;
    }

    public Student getStudent() {
        return student;
    }

    public LinkedHashMap<String, Boolean> getJournal() {
        return journal;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Boolean> entry : journal.entrySet()) {
            sb.append("     " + entry.getKey() + " - " + entry.getValue() + "\n");
        }
        return student + "\n" + sb.toString();
    }

}
