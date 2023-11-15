import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.controllers.PisteRestController;
import tn.esprit.spring.entities.Piste;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PisteRestControllerTest {

    @Autowired
    private PisteRestController pisteRestController;

    @Test
    public void testAddPiste() {
        // Créez un objet Piste factice pour les tests
        Piste piste = new Piste();
        piste.setNamePiste("Ma piste de test"); // Correction du nom du champ

        // Appelez la méthode du contrôleur que vous voulez tester
        Piste result = pisteRestController.addPiste(piste);

        // Effectuez des assertions pour vérifier que le résultat est conforme aux attentes
        assertNotNull(result);
        assertEquals("Ma piste de test", result.getNamePiste());
    }

    @Test
    public void testGetAllPistes() {
        // Créez une liste factice de pistes pour les tests
        Piste piste1 = new Piste();
        piste1.setNamePiste("Piste 1");
        Piste piste2 = new Piste();
        piste2.setNamePiste("Piste 2");
        List<Piste> pistes = new ArrayList<>();
        pistes.add(piste1);
        pistes.add(piste2);

        // Appelez la méthode du contrôleur que vous voulez tester
        List<Piste> result = pisteRestController.getAllPistes();

        // Effectuez des assertions pour vérifier que le résultat est conforme aux attentes
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Piste 1", result.get(0).getNamePiste());
        assertEquals("Piste 2", result.get(1).getNamePiste());
    }

    @Test
    public void testGetById() {
        // Créez un objet Piste factice pour les tests
        Piste piste = new Piste();
        piste.setNamePiste("Ma piste de test");
        Long pisteId = 1L;

        // Appelez la méthode du contrôleur que vous voulez tester
        Piste result = pisteRestController.getById(pisteId);

        // Effectuez des assertions pour vérifier que le résultat est conforme aux attentes
        assertNotNull(result);
        assertEquals(pisteId, result.getNumPiste()); // Correction du nom du champ
        assertEquals("Ma piste de test", result.getNamePiste());
    }

    @Test
    public void testDeleteById() {
        // Identifiant de la piste à supprimer
        Long pisteId = 1L;

        // Appelez la méthode du contrôleur que vous voulez tester
        pisteRestController.deleteById(pisteId);

        // Vous pouvez ajouter des assertions supplémentaires pour vérifier la suppression, par exemple
        Piste deletedPiste = pisteRestController.getById(pisteId);
        assertNull(deletedPiste);
    }
}
