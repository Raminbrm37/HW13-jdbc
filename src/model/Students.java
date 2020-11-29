package model;

public class Students {
    private int SID;
    private String SFname;
    private String SLname;

    public int getSID() {
        return SID;
    }

    public void setSID(int SID) {
        this.SID = SID;
    }

    public String getSFname() {
        return SFname;
    }

    public void setSFname(String SFname) {
        this.SFname = SFname;
    }

    public String getSLname() {
        return SLname;
    }

    public void setSLname(String SLname) {
        this.SLname = SLname;
    }

    @Override
    public String toString() {
        return "Students{" +
                "SID=" + SID +
                ", SFname='" + SFname + '\'' +
                ", SLname='" + SLname + '\'' +
                '}';
    }
}
