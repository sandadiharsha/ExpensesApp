/**
 * 
 */
package com.har.ui.model;

import java.util.Date;

/**
 * @author HSandadi
 *
 */
public class Person {

	public Person(String prefix, String firstName, String middleName, String lastName, String suffix, Date dateOfBirth,
			String gender) {
		super();
		this.prefix = prefix;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.suffix = suffix;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}

	private String prefix;
	private String firstName;
	private String middleName;
	private String lastName;
	private String suffix;
	private Date dateOfBirth;
	private String gender;

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
