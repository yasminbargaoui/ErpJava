package tn.esprit.models;

import java.sql.Date;

public class Internship {
    private int id ,departement_id ;
    private String title,description,technology,typeinternship,state,period;
    private Date  startdate;

    public Internship(int departement_id, String title, String description, String technology,
                      String typeinternship, String state, String period, Date startdate)
    {
        this.departement_id = departement_id;

        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }

        if (description.length() >10) {
            throw new IllegalArgumentException("description cannot be null or empty.");
        }
        if (technology== null || technology.isEmpty()) {
            throw new IllegalArgumentException("Technology cannot be null or empty.");
        }
        if (typeinternship== null || typeinternship.isEmpty()) {
            throw new IllegalArgumentException("type of stage cannot be null or empty.");
        }
        if (state== null || state.isEmpty()) {
            throw new IllegalArgumentException("state of internship cannot be null or empty.");
        }
        if (period== null || period.isEmpty()) {
            throw new IllegalArgumentException("period of internship cannot be null or empty.");
        }
        this.startdate = startdate;
        this.title = title;
        this.description = description;
        this.technology = technology;
        this.typeinternship = typeinternship;
        this.state = state;
        this.period = period;


    }

    public Internship() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartement_id() {
        return departement_id;
    }

    public void setDepartement_id(int departement_id) {
        this.departement_id = departement_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getTypeinternship() {
        return typeinternship;
    }

    public void setTypeinternship(String typeinternship) {
        this.typeinternship = typeinternship;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }



    @Override
    public String toString() {
        return "Internship{" +
                "id=" + id +
                ", departement_id=" + departement_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", technology='" + technology + '\'' +
                ", typeinternship='" + typeinternship + '\'' +
                ", state='" + state + '\'' +
                ", period='" + period + '\'' +
                ", startdate=" + startdate +
                '}';
    }
}
