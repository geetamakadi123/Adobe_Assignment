package com.adobe.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

		
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "userId",nullable = false)
	private User user_id;

		
	@Size(min = 1, max = 300, message = "{validation.name.size}")
	private String content;


	@CreationTimestamp
	private LocalDateTime created_at;


	@UpdateTimestamp
	private LocalDateTime updated_at;

		
	
	private int likes;


	
}
