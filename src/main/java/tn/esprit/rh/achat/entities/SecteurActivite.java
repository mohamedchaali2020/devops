package tn.esprit.rh.achat.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SecteurActivite implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSecteurActivite;
	private String codeSecteurActivite;
	private String libelleSecteurActivite;
	@ManyToMany(mappedBy="secteurActivites")
	@JsonIgnore
	private Set<Fournisseur> fournisseurs;
	public List<SecteurActivite> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public void save(SecteurActivite sa) {
		// TODO Auto-generated method stub
		
	}
	public Object findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
