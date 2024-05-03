package projectWork.model;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prodotti")
public class Prodotto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//oggetto di tipo sottocategoria, in acquisto va classe di tipo prodotto
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id_sottocategoria", referencedColumnName = "id")
	private Sottocategoria sottocategoria;
	
	@Column
	private String nome;
	
	@Column
	private String descrizione;
	
	@Column
	private double prezzo;
	
	@Column
	private String immagine;
	
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinTable (
			name = "ordini",
			joinColumns = @JoinColumn(name = "id_prodotto", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "id_acquisto", referencedColumnName = "id")
			)
	private List<Prodotto> prodotti = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sottocategoria getSottocategoria() {
		return sottocategoria;
	}

	public void setSottocategoria(Sottocategoria sottocategoria) {
		this.sottocategoria = sottocategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
	
	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}
	}
