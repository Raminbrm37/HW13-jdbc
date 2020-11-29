package model;

public class stu_mas {
    private int SID_m;
    private int MID_m;

    public int getSID_m() {
        return SID_m;
    }

    public void setSID_m(int SID_m) {
        this.SID_m = SID_m;
    }

    public int getMID_m() {
        return MID_m;
    }

    public void setMID_m(int MID_m) {
        this.MID_m = MID_m;
    }

    @Override
    public String toString() {
        return "stu_mas{" +
                "SID_m=" + SID_m +
                ", MID_m=" + MID_m +
                '}';
    }
}
