import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
public class Main {


    public static void main(String[] args) {


        Calendar calendar1 = new Calendar(new Working_hours(LocalTime.of(9, 0), LocalTime.of(19, 55)),
                List.of(new Planned_meeting(LocalTime.of(9, 0), LocalTime.of(10, 30)),
                        new Planned_meeting(LocalTime.of(12, 0), LocalTime.of(13, 00)),
                        new Planned_meeting(LocalTime.of(16, 0), LocalTime.of(18, 00)))
        );

        Calendar calendar2 = new Calendar(new Working_hours(LocalTime.of(10, 0), LocalTime.of(18, 30)),
                List.of(new Planned_meeting(LocalTime.of(10, 0), LocalTime.of(11, 30)),
                        new Planned_meeting(LocalTime.of(12, 30), LocalTime.of(14, 30)),
                        new Planned_meeting(LocalTime.of(14, 30), LocalTime.of(15, 00)),
                        new Planned_meeting(LocalTime.of(16, 00), LocalTime.of(17, 00)))
        );

        List<Calendar> calendars = List.of(calendar1, calendar2);
        Duration meetingDuration = Duration.ofMinutes(30);

        Find_slot findSlot = new Find_slot();
        List<Find_slot.TimeSlot> freeSlots = findSlot.Find_slot(calendars, meetingDuration);

        if (freeSlots.size() == 0) {
            System.out.println("No free slots available");
        } else {
            System.out.println("Free slots:");
            for (Find_slot.TimeSlot slot : freeSlots) {
                System.out.println(slot.getStart() + " - " + slot.getEnd());
            }
        }
    }
}
