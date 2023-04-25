import java.time.LocalTime;

public class Planned_meeting {
    public LocalTime start;
    public LocalTime end;

    public Planned_meeting(LocalTime start, LocalTime end){
        this.start=start;
        this.end=end;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }
}
