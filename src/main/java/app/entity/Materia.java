package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Materia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id; 
	private String nome;
	private String descricao;
	private String base64;
	
	@OneToMany(mappedBy = "materia", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("materia")
	private List<SubMateria> submateria;
}
