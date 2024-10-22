package sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "sala", schema = "public")
@NamedQueries({
        @NamedQuery(name = "Sala.findByIdTipoSala",
                query ="SELECT s FROM SalaCaracteristica sc  JOIN sc.idSala s WHERE SC.idTipoSala.idTipoSala = :idTipoSala GROUP BY s.idSala ORDER BY s.nombre ASC")
})

public class Sala{
    @Id
    @Column(name = "id_sala", nullable = false)
    private Integer idSala;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sucursal")
    private Sucursal idSucursal;

    @Size(max = 155)
    @Column(name = "nombre", length = 155)
    private String nombre;

    @Column(name = "activo")
    private Boolean activo;

    @Lob
    @Column(name = "observaciones")
    private String observaciones;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "idSala")
    public List<Asiento> asientoList;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "idSala")
    public List<SalaCaracteristica> salaCaracteristicas;

    public Sala(Integer idSala) {
        this.idSala = idSala;
    }
    public Sala() {

    }

    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer id) {
        this.idSala = id;
    }

    public Sucursal getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Sucursal idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<SalaCaracteristica> getSalaCaracteristicas() {
        return salaCaracteristicas;
    }

    public void setSalaCaracteristicas(List<SalaCaracteristica> salaCaracteristicas) {
        this.salaCaracteristicas = salaCaracteristicas;
    }
}