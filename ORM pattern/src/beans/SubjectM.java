package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SubjectM {
    @Id
    @Column(name="sid")
    int sid;
    String sName;

    @ManyToOne
    FacultyM facultyM;

    public FacultyM getFacultyM() {
        return facultyM;
    }

    public void setFacultyM(FacultyM facultyM) {
        this.facultyM = facultyM;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public SubjectM(int sid, String sName,FacultyM facultyM) {
        this.sid = sid;
        this.sName = sName;
        this.facultyM =facultyM;
    }
}
