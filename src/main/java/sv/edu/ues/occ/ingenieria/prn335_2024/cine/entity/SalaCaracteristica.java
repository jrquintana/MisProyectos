package sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sala_caracteristica", schema = "public")
public class SalaCaracteristica {
    @Id
    @Column(name = "id_sala_caracteristica", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_sala")
    private TipoSala idTipoSala;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sala")
    private Sala idSala;

    @Lob
    @Column(name = "valor")
    private String valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoSala getIdTipoSala() {
        return idTipoSala;
    }

    public void setIdTipoSala(TipoSala idTipoSala) {
        this.idTipoSala = idTipoSala;
    }

    public Sala getIdSala() {
        return idSala;
    }

    public void setIdSala(Sala idSala) {
        this.idSala = idSala;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

}