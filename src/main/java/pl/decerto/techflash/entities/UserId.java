package pl.decerto.techflash.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserId implements Serializable {

	@Id
	@Column(name = "FIRST_NAME")
	private String firstName;

	@Id
	@Column(name = "LAST_NAME")
	private String lastName;

	public UserId() {}
}
