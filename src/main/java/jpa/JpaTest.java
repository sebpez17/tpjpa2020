
package jpa;

import dao.SondageDAO;
import domain.Sondage;

public class JpaTest {

    /**
     * @param args
     */
    public static void main(String[] args) {


        JpaTest t = new JpaTest();
        SondageDAO.rentrerNouvelleDonnees("Cours secweb", "zoom");
        for (Sondage item: SondageDAO.getSondageByTitre("Cours secweb")) {
            System.out.printf("Item : %s",item);
        }
        EntityManagerHelper.getEntityManager().close();
    }

}