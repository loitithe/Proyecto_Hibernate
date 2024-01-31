package com.example.Entidades;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "datos_profesionales")
@Entity
public class Datos_Profesionales implements Serializable {

    @Column(name = "sueldo_bruto")
    private double sueldo_bruto;

    @Column(name = "categoria")
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Id
    @OneToOne
    @JoinColumn(name = "dni", columnDefinition = "char(9)")
    private Empleado empleado;

    public Datos_Profesionales(double sueldo_bruto, Categoria categoria, Empleado empleado) {

        this.sueldo_bruto = sueldo_bruto;
        this.categoria = categoria;
        this.empleado = empleado;
    }

    public double getSueldo_bruto() {
        return sueldo_bruto;
    }

    public void setSueldo_bruto(double sueldo_bruto) {
        this.sueldo_bruto = sueldo_bruto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
