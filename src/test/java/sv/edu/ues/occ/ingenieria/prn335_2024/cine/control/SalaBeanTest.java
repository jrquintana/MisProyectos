package sv.edu.ues.occ.ingenieria.prn335_2024.cine.control;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoSala;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class SalaBeanTest {

    @Test
    public void findById(){
        System.out.println("SalaBeanTest.findById");
        List<TipoSala> buscados = Arrays.asList(new TipoSala[]{new TipoSala(1), new TipoSala(2), new TipoSala(3), new TipoSala(4), new TipoSala(5)});
        Query mockQuery = Mockito.mock(Query.class);
        Mockito.when(mockQuery.getResultList()).thenReturn(buscados);

        EntityManager mockEM = Mockito.mock(EntityManager.class);
        Mockito.when(mockEM.createNamedQuery("Sala.findByIdTipoSala")).thenReturn(mockQuery);

        SalaBean cut = new SalaBean();
        cut.em =mockEM;

        List<TipoSala> encontrados = cut.findByIdTipoSala(1,1,1);


        assertEquals(buscados.size(),encontrados.size());

        fail("Esto no funciona");

    }
}
