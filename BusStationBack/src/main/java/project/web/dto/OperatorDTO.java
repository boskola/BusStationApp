package project.web.dto;

import javax.validation.constraints.NotBlank;

public class OperatorDTO {
	
private Long id;
	
	@NotBlank(message = "Name of operator is missing!")
	private String name;
	
	@NotBlank(message = "Adress of operator is missing!")
	private String adress;
	
	@NotBlank(message = "VAT of operator is missing!")
	private String VAT;
	
	public OperatorDTO() {}

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

	public String getVAT() {
		return VAT;
	}

	public void setVAT(String vAT) {
		VAT = vAT;
	}

}
