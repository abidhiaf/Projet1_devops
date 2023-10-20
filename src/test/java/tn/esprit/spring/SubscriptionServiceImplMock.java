package tn.esprit.spring.services;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.time.LocalDate; // Assurez-vous d'importer LocalDate si ce n'est pas déjà fait

public class SubscriptionServiceTest {
    @InjectMocks
    SubscriptionServicesImpl subscriptionService;

    @Mock
    ISubscriptionRepository subscriptionRepository;

    @Mock
    ISkierRepository skierRepository;

    @Test
    public void testAddSubscription() {
        // Initialisez un objet Subscription pour le test
        Subscription subscription = new Subscription();
        subscription.setStartDate(LocalDate.now());
        subscription.setTypeSub(TypeSubscription.ANNUAL);

        // Définissez le comportement attendu lors de l'appel à la méthode repository
        Mockito.when(subscriptionRepository.save(Mockito.any(Subscription.class))).thenReturn(subscription);

        // Appelez la méthode que vous testez
        Subscription result = subscriptionService.addSubscription(subscription);

        // Effectuez des assertions pour vérifier le résultat
        Assertions.assertNotNull(result);
        // Vous pouvez ajouter d'autres assertions en fonction de votre logique métier.
    }
}
