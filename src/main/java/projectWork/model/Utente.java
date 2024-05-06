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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "utenti")
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_profilo", referencedColumnName = "id")
	@Valid
	private Profilo profilo;

	@Column
	@Pattern(regexp = "[a-zA-Z0-9._-]{1,50}", message = "Caratteri non ammessi")
	private String username;

	@Column
	private String email;

	@Column
	@Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,50}", message = "Password troppo debole, deve contenere almeno un carattere Maiuscolo, minuscolo, un numero ed un carattere speciale")
	private String password;

	@Column
	private String avatar;

	public List<Acquisto> getAcquisti() {
		return acquisti;
	}

	public void setAcquisti(List<Acquisto> acquisti) {
		this.acquisti = acquisti;
	}

	@OneToMany(mappedBy = "utente",
			cascade = CascadeType.REMOVE,
			fetch = FetchType.EAGER,
			orphanRemoval = true)
	private List<Acquisto> acquisti = new ArrayList<>();


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Profilo getProfilo() {
		return profilo;
	}

	public void setProfilo(Profilo profilo) {
		this.profilo = profilo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}