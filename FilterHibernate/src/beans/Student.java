package beans;

public class Student {
    private int sturollno;
    private String stuname;
    private String stumail;
    private Double stumarks;

    public Student(int sturollno, String stuname, String stumail, Double stumarks) {
        this.sturollno = sturollno;
        this.stuname = stuname;
        this.stumail = stumail;
        this.stumarks = stumarks;
    }

    public Student() {
    }

    public int getSturollno() {
        return sturollno;
    }

    public void setSturollno(int sturollno) {
        this.sturollno = sturollno;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStumail() {
        return stumail;
    }

    public void setStumail(String stumail) {
        this.stumail = stumail;
    }

    public Double getStumarks() {
        return stumarks;
    }

    public void setStumarks(Double stumarks) {
        this.stumarks = stumarks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sturollno=" + sturollno +
                ", stuname='" + stuname + '\'' +
                ", stumail='" + stumail + '\'' +
                ", stumarks=" + stumarks +
                '}';
    }
}
