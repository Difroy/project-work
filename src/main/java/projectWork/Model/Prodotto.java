package projectWork.Model;

import java.time.LocalDate;

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
@Table(name = "prodotti")
public class Prodotto {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "nome_prodotto")
	private String nomeProdotto;
	
	@Column
	private String descrizione;
	
	@Column(name = "prezzo")
	private double prezzo;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id_categoria", referencedColumnName = "id")
	private Categoria categoria;
	
	}
