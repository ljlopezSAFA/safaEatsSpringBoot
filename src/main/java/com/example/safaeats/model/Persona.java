package com.example.safaeats.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "persona", schema = "safaeats")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"pedidosRealizados","pedidosRepartidos"})
public class Persona {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name ="fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<Pedido> pedidosRealizados;

    @OneToMany(mappedBy = "repartidor", fetch = FetchType.LAZY)
    private Set<Pedido> pedidosRepartidos;



}
