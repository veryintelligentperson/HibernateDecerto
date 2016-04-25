package pl.decerto.techflash.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import pl.decerto.techflash.utils.CompanyType;

@Data
@Entity
@Table(name = "COMPANY_ACCOUNT")
public class CompanyAccount {

	@Id
	@GeneratedValue
	@Column(name = "COMPANY_ID")
	private Long companyId;

	@Column(name = "COMPANY_NAME")
	private String companyName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "COMPANY_USERS", joinColumns =@JoinColumn(name = "COMPANY_ID"),
	inverseJoinColumns = {@JoinColumn(name = "LAST_NAME"), @JoinColumn(name = "FIRST_NAME")})
	private List<User> users;

	@Column(name = "COLUMN_TYPE")
	@Enumerated(EnumType.STRING)
	private CompanyType companyType;

	@Column(name = "NIP")
	private String nip;

	@Column(name = "REGON")
	private String regon;

}
