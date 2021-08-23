package com.shrestha.chat.dal;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class User {	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int id;
	private String userName;

}
