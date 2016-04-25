package pl.decerto.techflash.entities;

import lombok.Data;

@Data
public class Credential {

	private Long credentialId;

	private HotelAccount account;

	private String username;

	private String password;

}
