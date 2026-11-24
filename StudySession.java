import java.time.LocalDate;

public class StudySession {

    private String subject;
    private LocalDate date;
    private int duration;

    public StudySession(String subject, LocalDate date, int duration) {
        this.subject = subject;
        this.date = date;
        this.duration = duration;
    }

    public String getSubject() {
        return subject;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getDuration() {
        return duration;
    }
}
