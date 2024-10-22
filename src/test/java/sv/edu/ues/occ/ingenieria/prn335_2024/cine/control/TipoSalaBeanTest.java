package sv.edu.ues.occ.ingenieria.prn335_2024.cine.control;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoSala;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class TipoSalaBeanTest {

    protected List<TipoSala> findResult;

    public TipoSalaBeanTest() {
        findResult = Arrays.asList(new TipoSala[]{new TipoSala(1), new TipoSala(2), new TipoSala(3)});
    }

    @Test
    void create(){
        System.out.println("TipoSalaBeanTest create");
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        TipoSala nuevo = new TipoSala();
        TipoSalaBean cut = new TipoSalaBean();
        assertThrows(IllegalArgumentException.class,()->{
            cut.create(null);
        } );
        assertThrows(IllegalStateException.class,()->{
           cut.create(nuevo);
        });

        cut.em = mockEM;
        cut.create(nuevo);
        //fail("Not yet implemented");
    }

    @Test
    void findById() {
        System.out.println("TipoSalaBeanTest.findById");
        final Integer idEsperado = 1;
        TipoSala esperado = new TipoSala(idEsperado);
        TipoSalaBean cut = new TipoSalaBean();

        assertThrows(IllegalStateException.class, () -> {
            cut.findById(idEsperado);
        });

        EntityManager mock = Mockito.mock(EntityManager.class);
        //Suplatar el metodo del entityManager con mokito
        Mockito.when(mock.find(TipoSala.class,idEsperado)).thenReturn(esperado);
        cut.em=mock;
        TipoSala resultado = cut.findById(idEsperado);
        assertNotNull(resultado);
        assertEquals(esperado,resultado);
        assertThrows(IllegalArgumentException.class, () -> {
                cut.findById(null);
        });

        //fail("Not yet implemented");
    }

    @Test
    void findRange() {
        System.out.println("TipoSalaBeanTest.findRange");
        int first = 0;
        int max = 1000;
        TipoSalaBean cut = new TipoSalaBean();
        assertThrows(IllegalArgumentException.class, () -> {
            cut.findRange(-1, 10);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            cut.findRange(10, -1);
        });
        assertThrows(IllegalStateException.class, () -> {
            cut.findRange(first, max);
        });
        CriteriaBuilder cbMock = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery<TipoSala> cqMock = Mockito.mock(CriteriaQuery.class);
        Root rootMock = Mockito.mock(Root.class);
        Mockito.when(cqMock.from(TipoSala.class)).thenReturn(rootMock);
        EntityManager emMock = Mockito.mock(EntityManager.class);
        TypedQuery tqMock = Mockito.mock(TypedQuery.class);
        Mockito.when(tqMock.getResultList()).thenReturn(findResult);
        Mockito.when(emMock.createQuery(cqMock)).thenReturn(tqMock);
        Mockito.when(cbMock.createQuery(TipoSala.class)).thenReturn(cqMock);
        Mockito.when(emMock.getCriteriaBuilder()).thenReturn(cbMock);
        cut.em = emMock;
        List<TipoSala> encontrados = cut.findRange(first, max);
        assertNotNull(encontrados);
        assertEquals(findResult.size(), encontrados.size());
    }



}