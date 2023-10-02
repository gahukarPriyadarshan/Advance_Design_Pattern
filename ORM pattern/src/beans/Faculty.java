package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Faculty {
    @Id
    @Column(name="fid")
    int fid;
    String fName;
    @OneToOne
    Subject subject;

    public Faculty(int fid, String fName, Subject subject) {
        this.fid = fid;
        this.fName = fName;
        this.subject = subject;
    }

    public Faculty() {
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
