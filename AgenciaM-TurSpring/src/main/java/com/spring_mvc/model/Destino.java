package com.spring_mvc.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "destino")
public class Destino {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_Destino")
	private Long idDestino;
	@Column(nullable = false, name = "Nome_Destino")
	private String nomeDestino;
	@Column(nullable = false, name = "Preco_Destino")
	private double precoDestino;
	@Column(name = "Imagem", columnDefinition = "longblob")
	private byte[] imagem;
	@OneToMany(mappedBy = "destino", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Reserva> reservas = new ArrayList<>();

	public Destino() {

	}

	public Destino(String nomeDestino, double precoDestino, byte[] imagem, List<Reserva> reservas) {
		this.nomeDestino = nomeDestino;
		this.precoDestino = precoDestino;
		this.imagem = imagem;
		this.reservas = reservas;
	}

	public Destino(Long idDestino, String nomeDestino, double precoDestino, byte[] imagem, List<Reserva> reservas) {
		this.idDestino = idDestino;
		this.nomeDestino = nomeDestino;
		this.precoDestino = precoDestino;
		this.imagem = imagem;
		this.reservas = reservas;
	}

	public Long getId() {
		return idDestino;
	}

	public void setId(Long id) {
		this.idDestino = id;
	}

	public String getNomeDestino() {
		return nomeDestino;
	}

	public void setNomeDestino(String nomeDestino) {
		this.nomeDestino = nomeDestino;
	}

	public double getPrecoDestino() {
		return precoDestino;
	}

	public void setPrecoDestino(double precoDestino) {
		this.precoDestino = precoDestino;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	
	public void addReserva(Reserva reserva) {
		reservas.add(reserva);
		reserva.setDestino(this);
	}

	public void removerReserva(Reserva reserva) {
		reservas.remove(reserva);
		reserva.setDestino(null);
	}

	@Override
	public String toString() {
		return "Destino [idDestino=" + idDestino + ", nomeDestino=" + nomeDestino + ", precoDestino=" + precoDestino
				+ ", imagem=" + Arrays.toString(imagem) + ", reservas=" + reservas + "]";
	}

}
