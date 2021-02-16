package jpa;

import jnr.ffi.annotations.In;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Member {
    private long id;
    private String givenName;
    private String surname;
    private String email;
    private Instant answerDate;
    private String foodAllergies;
    private String foodPreferences;
    private Survey survey;

    public Member(){
    }

    public Member(Survey survey, String givenName, String surname, String email, Instant answerDate) {
        this.givenName = givenName;
        this.surname = surname;
        this.email = email;
        this.answerDate = answerDate;
        this.survey = survey;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
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

    public Instant getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(Instant answerDate) {
        this.answerDate = answerDate;
    }

    public String getFoodAllergies() {
        return foodAllergies;
    }

    public void setFoodAllergies(String foodAllergies) {
        this.foodAllergies = foodAllergies;
    }

    public String getFoodPreferences() {
        return foodPreferences;
    }

    public void setFoodPreferences(String foodPreferences) {
        this.foodPreferences = foodPreferences;
    }

    @ManyToOne
    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    @Override
    public String toString(){
        return String.format(
                "[givenName=%s, surname=%s, email=%s, answerDate=%s, foodAllergies=%s, foodPreferences=%s]",
                this.givenName, this.surname, this.email, this.answerDate.toString(), this.foodAllergies,
                this.foodPreferences);
    }
}
