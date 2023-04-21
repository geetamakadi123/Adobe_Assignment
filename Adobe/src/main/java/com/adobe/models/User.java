package com.adobe.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@NotBlank
	@Size(min = 1, max = 150, message = "{validation.name.size}")
	private String name;


	@NotBlank
	@Email()
	private String email;

	
	@Size(min = 1, max = 200, message = "{validation.name.size}")
	private String bioString;

	@CreationTimestamp
	private LocalDateTime created_at;

	
	@UpdateTimestamp
	private LocalDateTime updated_at;
	
	
}
