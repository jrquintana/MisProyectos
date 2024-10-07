package sv.edu.ues.occ.ingenieria.prn335_2024.cine.control;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoSala;

import java.io.Serializable;
import java.util.List;

@Stateless
@LocalBean

public class TipoSalaBean implements Serializable {
    @PersistenceContext(unitName = "CinePU")
    EntityManager em;

    public TipoSala findByIde(final Integer idTipoSala){
       return em.find(TipoSala.class, idTipoSala);
    }
}
