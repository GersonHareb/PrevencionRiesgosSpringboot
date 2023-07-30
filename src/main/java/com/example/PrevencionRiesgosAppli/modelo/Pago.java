package com.example.PrevencionRiesgosAppli.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne // Relación muchos a uno, ya que muchos pagos pueden pertenecer a un cliente
    @JoinColumn(name = "usuario_id") // Nombre de la columna que guarda la relación con el cliente
    private Cliente cliente;
    @Column
    private int monto;
    @Column
    private LocalDate fechaPago;

    public Pago() {
    }

    public Pago(int id, Cliente cliente, int monto, LocalDate fechaPago) {
        this.id = id;
        this.cliente = cliente;
        this.monto = monto;
        this.fechaPago = fechaPago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }
}
