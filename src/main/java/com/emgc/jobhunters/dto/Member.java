package com.emgc.jobhunters.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	@NotNull @NotEmpty @NotBlank
	private String id;

	@NotNull @NotEmpty @NotBlank
	private String password;

	@NotNull @NotEmpty @NotBlank @Email
	private String email;
}
