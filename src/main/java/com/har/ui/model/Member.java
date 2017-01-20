/**
 * 
 */
package com.har.ui.model;

import java.util.Date;

/**
 * @author HSandadi
 *
 */
public class Member extends Person{

	 
	public Member(String prefix, String firstName, String middleName, String lastName, String suffix, Date dateOfBirth,
			String gender,LoginDTO dto) {
		super(prefix, firstName, middleName, lastName, suffix, dateOfBirth, gender);
		this.dto=dto;
	}
	private LoginDTO dto;
	public LoginDTO getDto() {
		return dto;
	}
	public void setDto(LoginDTO dto) {
		this.dto = dto;
	}

}
