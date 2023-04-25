import java.time.LocalTime;

public class Working_hours {
    public LocalTime start;
    public LocalTime end;

    public Working_hours(LocalTime start, LocalTime end){
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
