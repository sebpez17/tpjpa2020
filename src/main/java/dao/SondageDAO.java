package dao;

import java.util.LinkedList;
import java.util.List;

import domain.Sondage;
import jpa.EntityManagerHelper;

public class SondageDAO extends GenericDaoJpaImpl<Sondage, Long>{


    List<Sondage> rechercheSondageByTitre(String recherche){
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

}