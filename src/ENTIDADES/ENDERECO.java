package ENTIDADES;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ENDERECO")
public class ENDERECO {

		
		@Id
		@Column(name = "RUA", nullable = false)
		private String rua;
		
		@Column (name = "NUMERO", nullable = false)
		private int numero;
		
		@Column (name = "COMPLEMENTO", nullable = false)
		private int complemento;
		
		@Column (name = "ID_ENDERECO", nullable = false)
		private int id_endereco;

		public String getRua() {
			return rua;
		}

		public void setRua(String rua) {
			this.rua = rua;
		}

		public int getNumero() {
			return numero;
		}

		public void setNumero(int numero) {
			this.numero = numero;
		}

		public int getComplemento() {
			return complemento;
		}

		public void setComplemento(int complemento) {
			this.complemento = complemento;
		}

		public int getId_endereco() {
			return id_endereco;
		}

		public void setId_endereco(int id_endereco) {
			this.id_endereco = id_endereco;
		}

		public List<ENDERECO> listarEndereco() {
			return null;
		}	
	}


