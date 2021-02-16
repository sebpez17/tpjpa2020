package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager){
		this.manager = manager;
	}
	/**
	 * @param args unused
	 */
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		JpaTest test = new JpaTest(manager);
		EntityTransaction tx = manager.getTransaction();
		tx.begin();


		try {

			test.creatSurvey();
			test.listSurveys();

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}

	public void creatSurvey(){
		User user = new User( "Doe", "Jhon", "j.doe@e.mail");
		manager.persist(user);

		Survey survey = new Survey(user, "Le Test");
		survey.setDuration(90);
		survey.setBriefing("Just a little test for testing.");
		manager.persist(survey);

		Member member =new Member(survey, "dompierre", "éric",
					"e.domp@e.mail", Instant.parse("2021-02-10T10:00:00Z"));
		manager.persist(member);


		Meeting meeting = new Meeting(Instant.parse("2021-02-10T10:00:00Z"), "123a",
				"URI://service.fr/");
		survey.setMeeting(meeting);

		manager.persist(meeting);
		manager.persist(survey);

	}

	public void listSurveys(){
		List surveys = manager.createQuery("SELECT s FROM Survey s").getResultList();
		System.out.printf("Numb of surveys: %d", surveys.size());
		for (Object next : surveys){
			System.out.printf("%s", next);
		}
	}

}
