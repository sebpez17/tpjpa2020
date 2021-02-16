
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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Tables;

@Entity
@Table(name = "SONDAGES")
@XmlRootElement(name = "sondage")
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

    @XmlElement(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @XmlElementWrapper(name = "members")
    @XmlElement(name = "membre")
    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    @XmlElement(name = "host")
    public User getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(User organisateur) {
        this.organisateur = organisateur;
    }

    @XmlElementWrapper(name = "choices")
    @XmlElement(name = "choice")
    public List<Choix> getChoixpossible() {
        return choixpossible;
    }

    public void setChoixpossible(List<Choix> choixpossible) {
        this.choixpossible = choixpossible;
    }

    @XmlElement(name = "selectedChoice")
    public Choix getChoixSelectionne() {
        return choixSelectionne;
    }

    public void setChoixSelectionne(Choix choixSelectionne) {
        this.choixSelectionne = choixSelectionne;
    }

    @XmlElement(name = "title")
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @XmlElement(name = "location")
    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }



}