package tn.esprit.rh.achat;




import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Builder;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Builder
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class OperateurServiceImplTest {
    @Mock
    OperateurRepository Repo;

    @InjectMocks
    
    OperateurServiceImpl Service;
    Operateur operateur = Operateur.builder().nom("nom").prenom("ba").build();
    List<Operateur> listOperateurs = new ArrayList<Operateur>() {
        {
            add(Operateur.builder().nom("nom").prenom("ba").build());
            add(Operateur.builder().nom("nom222").prenom("ba222").build());
        }
    };

    @Test
    void testRetrieveStock() {
        Mockito.when(Repo.findById(Mockito.anyLong())).thenReturn(Optional.of(operateur));
        @SuppressWarnings("removal")
        Operateur s1 = Service.retrieveOperateur(new Long(2));
        Assertions.assertNotNull(s1);
    }

    @Test
    void testAllRetrieveStock() {
        Mockito.when(Repo.findAll()).thenReturn(listOperateurs);
        List<Operateur> IOperateur = Service.retrieveAllOperateurs();
        Assertions.assertNotNull(IOperateur);
    }

    @Test
    void testAddstock() {
        Mockito.when(Repo.save(operateur)).thenReturn(operateur);
        Operateur s1 = Service.addOperateur(operateur);
        Assertions.assertNotNull(s1);

    }

    @Test
    void testUpdatestock() {
    	operateur.setNom("yosri");
        Mockito.when(Repo.save(operateur)).thenReturn(operateur);
        Operateur s1 = Service.updateOperateur(operateur);
        Assertions.assertEquals(operateur, s1);

    }

    @Test
    void testDeletestock() {
        Service.deleteOperateur(operateur.getIdOperateur());
        Mockito.verify(Repo, Mockito.times(1)).deleteById(operateur.getIdOperateur());
    }


}