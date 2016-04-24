package pl.decerto.techflash.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CompanyAccount {

	@Id
	@GeneratedValue
	@Column(name = "COMPANY_ID")
	private Long companyId;

	@Column(name = "COMPANY_NAME")
	private String companyName;

	@Column(name = "NIP")
	private String nip;

	@Column(name = "REGON")
	private String regon;

}
