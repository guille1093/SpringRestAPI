package com.API.REST.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
public class Cliente {
    @Id
    @Column(name = "dni_cliente", length = 10, nullable = false, unique = true)
    private String dni;
    @Column(name = "nombre_cliente", length = 50, nullable = false)
    private String nombre;
    @Column(name = "apellido_cliente", length = 50, nullable = false)
    private String apellido;
    @Column(name = "sexo_cliente", length = 10, nullable = false)
    private String sexo;
    @Column(name = "fecha_nacimiento_cliente", nullable = false)
    private LocalDate fechaNacimiento;
    @Column(name = "fecha_ingreso_cliente", nullable = false)
    private LocalDate fechaIngreso;
    @Column(name = "peso_cliente", nullable = false)
    private double peso;
    @Column(name = "estatura_cliente", nullable = false)
    private double estatura;
}
