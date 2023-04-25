import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Find_slot {

    public List<TimeSlot> Find_slot (List<Calendar> calendars, Duration meetingDuration) {
        List<TimeSlot> freeSlots = new ArrayList<>();


        Working_hours workingHours1 = calendars.get(0).getWorkingHours();
        Working_hours workingHours2 = calendars.get(1).getWorkingHours();
        LocalTime startWorking = workingHours1.getStart().isAfter(workingHours2.getStart()) ? workingHours1.getStart() : workingHours2.getStart();
        LocalTime endWorking = workingHours1.getEnd().isBefore(workingHours2.getEnd()) ? workingHours1.getEnd() : workingHours2.getEnd();

        List<Planned_meeting> plannedMeetings = new ArrayList<>();
        plannedMeetings.addAll(calendars.get(0).getPlannedMeetings());
        plannedMeetings.addAll(calendars.get(1).getPlannedMeetings());
        Meeting_compare meetingCompare = new Meeting_compare();
        plannedMeetings.sort(meetingCompare);

        LocalTime current = startWorking;
        for (Planned_meeting meeting : plannedMeetings) {
            if (meeting.getStart().isAfter(current) && Duration.between(current, meeting.getStart()).compareTo(meetingDuration) >= 0) {
                freeSlots.add(new TimeSlot(current, meeting.getStart()));
            }
            current = meeting.getEnd();
        }
        if (endWorking.isAfter(current) && Duration.between(current, endWorking).compareTo(meetingDuration) >= 0) {
            freeSlots.add(new TimeSlot(current, endWorking));
        }



        return freeSlots;
    }

    static class TimeSlot {
        private final LocalTime start;
        private final LocalTime end;

        public TimeSlot(LocalTime start, LocalTime end) {
            this.start = start;
            this.end = end;
        }

        public LocalTime getStart() {
            return start;
        }

        public LocalTime getEnd() {
            return end;
        }


    }
}
