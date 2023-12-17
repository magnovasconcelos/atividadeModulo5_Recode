package com.spring_mvc.model;

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
@Table(name = "contato")
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_Contato")
	private Long idContato;
	@Column(nullable = false, name = "Assunto")
	private String assunto;
	@Column(nullable = false, name = "Mensagem")
	private String mensagem;
	@ManyToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "fk_Cliente_CPF_Cliente")
	private Cliente cliente;

public Contato() {
		
	}
	public Contato(String assunto, String mensagem, Cliente cliente) {
		this.assunto = assunto;
		this.mensagem = mensagem;
		this.cliente = cliente;
	}
	
	public Contato(Long idContato, String assunto, String mensagem, Cliente cliente) {
		this.idContato = idContato;
		this.assunto = assunto;
		this.mensagem = mensagem;
		this.cliente = cliente;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Long getIdContato() {
		return idContato;
	}
	public void setIdContato(Long idContato) {
		this.idContato = idContato;
	}
	@Override
	public String toString() {
		return "Contato [idContato=" + idContato + ", assunto=" + assunto + ", mensagem=" + mensagem + ", cliente="
				+ cliente.getCpf() + "]";
	}
	

}
