package com.example.safaeats.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "restaurante", schema = "safaeats", catalog = "postgres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"productos"})
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "max_comensales")
    private Integer maxComensales;

    @Column(name = "fecha_fundacion")
    private LocalDate fechaFundacion;

    @OneToMany(mappedBy = "restaurante" , fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Producto> productos;





}
