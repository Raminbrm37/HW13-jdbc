package model;

public class Master {
    private int MID;
    private String MFname;
    private String MLname;

    public int getMID() {
        return MID;
    }

    public void setMID(int MID) {
        this.MID = MID;
    }

    public String getMFname() {
        return MFname;
    }

    public void setMFname(String MFname) {
        this.MFname = MFname;
    }

    public String getMLname() {
        return MLname;
    }

    public void setMLname(String MLname) {
        this.MLname = MLname;
    }

    @Override
    public String toString() {
        return "Master{" +
                "MID=" + MID +
                ", MFname='" + MFname + '\'' +
                ", MLname='" + MLname + '\'' +
                '}';
    }
}
