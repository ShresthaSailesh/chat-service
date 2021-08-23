package com.shrestha.chat.dal;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;


@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat {					

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String chatFrom;
	@Type(type="text")
	private String message;
	private String timeStamp;
}
