package projectWork.Model;

import java.time.LocalDate;
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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Entity
@Table(name = "profili")
public class Profilo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private String cognome;
	
	@Column
	private char genere;

	@Column(name = "data_di_nascita")
	private LocalDate dataDiNascita;
	
	@Column(name = "indirizzo_residenza")
	private String indirizzoResidenza;

	@Column
	private String telefono;
	
	/* @ManyToMany(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id_utente", referencedColumnName = "id")
	private Utente utente; 
	dubbio: penso che non serva a nulla questa parte? sotto commento pure gli annessi getter e setter
	*/
	
	@OneToOne(
			mappedBy = "profilo",
			cascade = CascadeType.REMOVE,
			fetch = FetchType.EAGER,
			orphanRemoval = true
			)
	private List<Utente> utenti = new ArrayList<>();

	public List<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public char getGenere() {
		return genere;
	}

	public void setGenere(char genere) {
		this.genere = genere;
	}
	
	
	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getIndirizzoResidenza() {
		return indirizzoResidenza;
	}

	public void setIndirizzoResidenza(String indirizzoResidenza) {
		this.indirizzoResidenza = indirizzoResidenza;
	}
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	/* public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	} */
	
}
