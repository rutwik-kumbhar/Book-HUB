package com.example.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User  {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(nullable =  false)
	private String firstName;
	
	@Column(nullable =  false)
	private String lastName;
	
	@Column(nullable = false , unique =  true)
	private String email;
	
	

	@Column(nullable = false , unique =  true)
	private String mobileNumber;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(nullable =  false)
	private String password;
	
	private String role;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@CreationTimestamp
	@Column(updatable =  false)
	private LocalDateTime createdAt;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@UpdateTimestamp
	@Column(insertable =  false)
	private LocalDateTime lastModifiedDate;
	
	@JsonIgnore
	@OneToOne()
	@JoinColumn(name = "cartId")
	private Cart cart;
	
	
	

}
