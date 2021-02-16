package jpa;

import b.b.M;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Survey {
    private long id;
    private String name;
    private String briefing;
    private int duration;

    private User user;
    private Meeting meeting;
    private List<Member> members = new ArrayList<>();

    public Survey(){
        super();
    }

    public Survey(User user, String name){
        this.user = user;
        this.name = name;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBriefing() {
        return briefing;
    }

    public void setBriefing(String briefing) {
        this.briefing = briefing;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }



    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "survey", cascade = CascadeType.PERSIST)
    public List<Member> getMembers(){
        return members;
    }

    public void setMembers(List<Member> members){
        this.members = members;
    }

    @OneToOne
    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    @Override
    public String toString() {
        return String.format("Survey [id=%d, user=%s, name=%s, briefing=%s, duration=%d, members=%s]",
                this.id, this.user, this.name, this.briefing, this.duration, this.members);
    }

}
