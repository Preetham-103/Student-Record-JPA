package com.cts.entity;

import lombok.Data;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import jakarta.persistence.*;

@Data
@Entity
@Table(name="std30")
public class Students {
	
	@Id
	private int studentId;
	private String title;
	private String lastName;
	private String firstName;
	private String Gender;
}
