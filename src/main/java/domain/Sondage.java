
package domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Tables;



@Entity
@Table(name = "SONDAGES")
public class Sondage {


    @Id
    @GeneratedValue
    long id;

    String titre;
    String lieu;


    @ManyToMany
    List<User> participants;

    @ManyToOne
    User organisateur;

    @OneToMany(mappedBy = "s")
    List<Choix> choixpossible;

    @OneToOne
    Choix choixSelectionne;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public User getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(User organisateur) {
        this.organisateur = organisateur;
    }

    public List<Choix> getChoixpossible() {
        return choixpossible;
    }

    public void setChoixpossible(List<Choix> choixpossible) {
        this.choixpossible = choixpossible;
    }

    public Choix getChoixSelectionne() {
        return choixSelectionne;
    }

    public void setChoixSelectionne(Choix choixSelectionne) {
        this.choixSelectionne = choixSelectionne;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }



}