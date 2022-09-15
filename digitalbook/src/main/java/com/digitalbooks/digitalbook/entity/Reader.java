package com.digitalbooks.digitalbook.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class Reader {

	@Id
	@NotBlank(message = "emailId cannot be blank#######")
	private String emailId;

	@NotBlank(message = "name cannot be blank#######")
	private String name;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Reader(@NotBlank(message = "emailId cannot be blank#######") String emailId,
			@NotBlank(message = "name cannot be blank#######") String name) {
		super();
		this.emailId = emailId;
		this.name = name;
	}

	public Reader() {
		super();
	}

	@Override
	public String toString() {
		return "Reader [emailId=" + emailId + ", name=" + name + "]";
	}

}
