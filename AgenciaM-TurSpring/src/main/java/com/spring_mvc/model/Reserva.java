package com.spring_mvc.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Numero_Reserva")
	private Long numeroReserva;
	@Column(nullable = false, name = "Data_Reserva")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataReserva;
	@Column(nullable = false, name = "Valor_Reserva")
	private double valorReserva;
	@Column(nullable = false, name = "Forma_Pagamento")
	private String formaPagamento;
	@ManyToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "fk_Cliente_CPF_Cliente")
	private Cliente cliente;
	@ManyToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "fk_Destino_Id_Destino")
	private Destino destino;

	public Reserva() {

	}

	public Reserva(Long numeroReserva, LocalDate dataReserva, double valorReserva, String formaPagamento) {
		this.numeroReserva = numeroReserva;
		this.dataReserva = dataReserva;
		this.valorReserva = valorReserva;
		this.formaPagamento = formaPagamento;
	}

	public Reserva(LocalDate dataReserva, double valorReserva, String formaPagamento, Cliente cliente,
			Destino destino) {
		this.dataReserva = dataReserva;
		this.valorReserva = valorReserva;
		this.formaPagamento = formaPagamento;
		this.cliente = cliente;
		this.destino = destino;
	}

	public Reserva(Long numeroReserva, LocalDate dataReserva, double valorReserva, String formaPagamento,
			Cliente cliente, Destino destino) {
		this.numeroReserva = numeroReserva;
		this.dataReserva = dataReserva;
		this.valorReserva = valorReserva;
		this.formaPagamento = formaPagamento;
		this.cliente = cliente;
		this.destino = destino;
	}

	public Long getNumeroReserva() {
		return numeroReserva;
	}

	public void setNumeroReserva(Long numeroReserva) {
		this.numeroReserva = numeroReserva;
	}

	public LocalDate getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(LocalDate dataReserva) {
		this.dataReserva = dataReserva;
	}

	public double getValorReserva() {
		return valorReserva;
	}

	public void setValorReserva(double valorReserva) {
		this.valorReserva = valorReserva;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	@Override
	public String toString() {
		return "Reserva [numeroReserva=" + numeroReserva + ", dataReserva=" + dataReserva + ", valorReserva="
				+ valorReserva + ", formaPagamento=" + formaPagamento + ", cliente=" + cliente.getCpf() + ", destino="
				+ destino.getId() + "]";
	}

}
