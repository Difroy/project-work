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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorie")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String tipo;
	
	@Column
	private String icona;
	
	@OneToMany (
			mappedBy = "categoria",
		    cascade = CascadeType.REMOVE,
	        fetch = FetchType.EAGER,
	        orphanRemoval = true
			)
	private List<Sottocategoria> sottocategorie = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getIcona() {
		return icona;
	}

	public void setIcona(String icona) {
		this.icona = icona;
	}

	public List<Sottocategoria> getSottocategorie() {
		return sottocategorie;
	}

	public void setSottocategorie(List<Sottocategoria> sottocategorie) {
		this.sottocategorie = sottocategorie;
	}

	
}