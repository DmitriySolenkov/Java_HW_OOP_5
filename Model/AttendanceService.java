package Model;

import java.util.ArrayList;

public class AttendanceService {
    public ArrayList<AttendanceJournal> attendanceService;

    public AttendanceService(ArrayList<AttendanceJournal> attendanceService) {
        this.attendanceService = attendanceService;
    }

    public ArrayList<AttendanceJournal> getAttendanceService() {
        return attendanceService;
    }

}
