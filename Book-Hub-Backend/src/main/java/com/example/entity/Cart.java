package com.example.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer totalPrice = 0;

	private Integer totalDiscountedPrice = 0;
	
	
	private Set<Integer> productIds = new HashSet<>();
	
	private  Integer cartQaunatity = productIds.size(); 
	
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "userId")
	private User user;

}
