package project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "operator")
public class Operator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String name;			
	
	@Column
	private String adress;
	
	@Column(nullable = false, unique = true)
	private String vat;
	
	@OneToMany(mappedBy = "operator", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Line> lines = new ArrayList<>();
	
	public Operator() {}

	public Operator(Long id, String name, String adress, String vat) {
		super();
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.vat = vat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getVat() {
		return vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}

	public List<Line> getLines() {
		return lines;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}
	
	public void addLine(Line line) {
		this.lines.add(line);
		if(!equals(line.getOperator())) {
			line.setOperator(this);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operator other = (Operator) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Operator [id=" + id + ", name=" + name + ", adress=" + adress + ", vat=" + vat + "]";
	}
	

}
