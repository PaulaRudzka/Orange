import java.util.List;

public class Calendar {
    public Working_hours workinghours;
    public List plannedmeetings;

    public Calendar(Working_hours workinghours, List plannedmeetings){
        this.workinghours=workinghours;
        this.plannedmeetings=plannedmeetings;
    }
    public Working_hours getWorkingHours() {
        return workinghours;
    }

    public List getPlannedMeetings() {
        return plannedmeetings;
    }



}
