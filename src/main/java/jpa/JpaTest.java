
package jpa;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityTransaction;

import domain.Sondage;

public class JpaTest {

    /**
     * @param args
     */
    public static void main(String[] args) {


        JpaTest t = new JpaTest();
        t.rentrerNouvelleDonnees();
        for (Sondage item: t.rechercheSondageByTitre("cours secuWeb")) {
            System.out.printf("Item : %s",item);
        }
        EntityManagerHelper.getEntityManager().close();
    }



    void rentrerNouvelleDonnees(){
        EntityTransaction tx = EntityManagerHelper.getEntityManager().getTransaction();
        tx.begin();
        try {
            Sondage s = new Sondage();
            s.setTitre("cours secuWeb");
            s.setLieu("zoom");
            EntityManagerHelper.getEntityManager().persist(s);

            //

        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();

    }

    List<Sondage> rechercheSondageByTitre(String titrevar){
        // EntityManagerHelper.getEntityManager().createNativeQuery("select * from ");

        String query = "select s from Sondage s where s.titre = :titre";
        final List titre = EntityManagerHelper.getEntityManager().
                createQuery(query).setParameter("titre", titrevar).getResultList();
        List<Sondage> list = new LinkedList<>();
        for (Object item : titre) {
            if(item instanceof Sondage){
                list.add((Sondage) item);
            }
        }
        return list;
    }
}