import java.util.Comparator;

public class Meeting_compare implements Comparator<Planned_meeting> {
    public int compare(Planned_meeting m1, Planned_meeting m2) {
        return m1.getStart().compareTo(m2.getStart());
    }

    @Override
    public Comparator<Planned_meeting> reversed() {
        return Comparator.super.reversed();
    }

}
