package com.spring_mvc.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@Column(name = "CPF_Cliente")
	private String cpf;
	@Column(nullable = false, name = "Nome_Cliente")
	private String nome;
	@Column(nullable = false, name = "Email_Cliente")
	private String email;
	@Column(nullable = false, name = "Telefone_Cliente")
	private String telefone;
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Contato> contatos = new ArrayList<>();
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Reserva> reservas = new ArrayList<>();

	public Cliente() {

	}

	public Cliente(String nome, String email, String telefone, List<Contato> contatos, List<Reserva> reservas) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.contatos = contatos;
		this.reservas = reservas;
	}

	public Cliente(String cpf, String nome, String email, String telefone, List<Contato> contatos,
			List<Reserva> reservas) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.contatos = contatos;
		this.reservas = reservas;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public void addContato(Contato contato) {
		contatos.add(contato);
		contato.setCliente(this);
	}

	public void removerContato(Contato contato) {
		contatos.remove(contato);
		contato.setCliente(null);
	}

	public void addReserva(Reserva reserva) {
		reservas.add(reserva);
		reserva.setCliente(this);
	}

	public void removerReserva(Reserva reserva) {
		reservas.remove(reserva);
		reserva.setCliente(null);
	}

	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", contatos="
				+ contatos + ", reservas=" + reservas + "]";
	}

}
