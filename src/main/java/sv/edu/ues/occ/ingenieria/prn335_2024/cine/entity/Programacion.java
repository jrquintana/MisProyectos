package sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Entity
@Table(name = "programacion", schema = "public")
public class Programacion implements Serializable {
    @Id
    @Column(name = "id_programacion", nullable = false)
    private Long idProgramacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sala")
    private Sala idSala;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pelicula")
    private Pelicula idPelicula;

    @Column(name = "desde")
    private OffsetDateTime desde;

    @Column(name = "hasta")
    private OffsetDateTime hasta;

    @Lob
    @Column(name = "comentarios")
    private String comentarios;

    public Long getIdProgramacion() {
        return idProgramacion;
    }

    public void setIdProgramacion(Long id) {
        this.idProgramacion = id;
    }

    public Sala getIdSala() {
        return idSala;
    }

    public void setIdSala(Sala idSala) {
        this.idSala = idSala;
    }

    public Pelicula getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Pelicula idPelicula) {
        this.idPelicula = idPelicula;
    }

    public OffsetDateTime getDesde() {
        return desde;
    }

    public void setDesde(OffsetDateTime desde) {
        this.desde = desde;
    }

    public OffsetDateTime getHasta() {
        return hasta;
    }

    public void setHasta(OffsetDateTime hasta) {
        this.hasta = hasta;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

}