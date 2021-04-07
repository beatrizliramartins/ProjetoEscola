package ENTIDADES;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "financeiro")
public class FINANCEIRO { 
	
	@Id
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "ID_PAI", nullable = false)
	private int id_pai;
	
	@Column(name = "STATUS_PAGAMENTO", nullable = false)
	private String status_pagamento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId_pai() {
		return id_pai;
	}

	public void setId_pai(int id_pai) {
		this.id_pai = id_pai;
	}

	public String getStatus_pagamento() {
		return status_pagamento;
	}

	public void setStatus_pagamento(String status_pagamento) {
		this.status_pagamento = status_pagamento;
	}

}