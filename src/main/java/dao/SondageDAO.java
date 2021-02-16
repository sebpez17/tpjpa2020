package dao;

import java.util.LinkedList;
import java.util.List;

import domain.Sondage;
import jpa.EntityManagerHelper;

import javax.persistence.EntityTransaction;

public class SondageDAO extends GenericDaoJpaImpl<Sondage, Long>{


    public static void rentrerNouvelleDonnees(String titre, String lieu){
        EntityTransaction tx = EntityManagerHelper.getEntityManager().getTransaction();
        tx.begin();
        try {
            Sondage s = new Sondage();
            s.setTitre(titre);
            s.setLieu(lieu);
            EntityManagerHelper.getEntityManager().persist(s);

            //

        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();

    }

    public static List<Sondage> getSondages(){
        // EntityManagerHelper.getEntityManager().createNativeQuery("select * from ");

        String query = "select s from Sondage s";
        final List titre = EntityManagerHelper.getEntityManager().
                createQuery(query).getResultList();
        List<Sondage> list = new LinkedList<>();
        for (Object item : titre) {
            if(item instanceof Sondage){
                list.add((Sondage) item);
            }
        }
        return list;
    }

    public static List<Sondage> getSondageByTitre(String recherche){
        // EntityManagerHelper.getEntityManager().createNativeQuery("select * from ");

        String query = "select s from Sondage s where s.titre = :titre";
        final List titre = EntityManagerHelper.getEntityManager().
                createQuery(query).setParameter("titre", recherche).getResultList();
        List<Sondage> list = new LinkedList<>();
        for (Object item : titre) {
            if(item instanceof Sondage){
                list.add((Sondage) item);
            }
        }
        return list;
    }

    public static Sondage getSondageById(Long id){
        // EntityManagerHelper.getEntityManager().createNativeQuery("select * from ");

        String query = "select s from Sondage s where s.id = :id";
        final List byId = EntityManagerHelper.getEntityManager().
                createQuery(query).setParameter("id", id).getResultList();
        Sondage result = null;
        for (Object item : byId) {
            if(item instanceof Sondage){
                result = (Sondage) item;
            }
        }
        return result;
    }

}