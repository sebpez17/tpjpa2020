package jpa;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    private long id;
    private String givenName;
    private String surname;
    private String email;
    private List<Survey> surveys;

    public User(){
    }

    public User(String givenName, String surname, String email){
        this.givenName = givenName;
        this.surname = surname;
        this.email = email;
    }

    @Id
    @GeneratedValue
    public Long getId(){
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL)
    public List<Survey> getSurveys() {
        return surveys;
    }

    public void setSurveys(List<Survey> surveys) {
        this.surveys = surveys;
    }

    @Override
    public String toString() {
        return String.format("User [id=%d, givenName=%s, surname=%s, email=%s, surveys=%s]", this.id,
                this.givenName, this.surname, this.email, this.surveys);
    }
}
