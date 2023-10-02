package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class FacultyM {
    @Id
    @Column(name="fid")
    private int id;

    private String name;

    @OneToMany(mappedBy = "facultyM")
    private List<SubjectM> subjects;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubjectM> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectM> subjects) {
        this.subjects = subjects;
    }

    public FacultyM(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
