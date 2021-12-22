import java.io.Serializable;

public class DateTime implements Serializable{

    private String date;
    private String stime;

    public DateTime() {
        super();
    }

    public DateTime(String date, String stime) {
        this.date = date;
        this.stime = stime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    @Override
    public String toString() {
        return "DateTime{" +
                "date='" + date + '\'' +
                ", stime='" + stime + '\'' +
                '}';
    }
}
