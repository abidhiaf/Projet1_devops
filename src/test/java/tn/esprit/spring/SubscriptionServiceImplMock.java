package tn.esprit.spring.services;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyLong;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class SubscriptionServiceTest {
    @InjectMocks
    private SubscriptionServicesImpl subscriptionService;

    @Mock
    private ISubscriptionRepository subscriptionRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveSubscription() {
        // Créez un objet Subscription fictif pour simuler une récupération réussie
        Subscription subscription = new Subscription();
        subscription.setNumSub(1L);
        when(subscriptionRepository.findById(anyLong())).thenReturn(Optional.of(subscription));

        // Appelez la méthode du service
        Subscription retrievedSubscription = subscriptionService.retrieveSubscriptionById(1L);

        // Vérifiez que la souscription récupérée n'est pas nulle
        Assertions.assertNotNull(retrievedSubscription);

        // Assurez-vous que le numéro de souscription récupéré correspond à celui de l'objet fictif créé
        Assertions.assertEquals(1L, retrievedSubscription.getNumSub());
    }
}
