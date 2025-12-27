package model;

public class ProfileBean {

    private String name;
    private String stuID;
    private String program;
    private String email;
    private String hobbie;
    private String selfIntro;

    public ProfileBean() {}

    public String getName() {
        return name;
    }
    public String getStuID() {
        return stuID;
    }
    public String getProgram() {
        return program;
    }
    public String getEmail() {
        return email;
    }
    public String getHobbie() {
        return hobbie;
    }
    public String getSelfIntro() {
        return selfIntro;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setStuID(String stuID) {
        this.stuID = stuID;
    }
    public void setProgram(String program) {
        this.program = program;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setHobbie(String hobbie) {
        this.hobbie = hobbie;
    }
    public void setSelfIntro(String selfIntro) {
        this.selfIntro = selfIntro;
    }
}
