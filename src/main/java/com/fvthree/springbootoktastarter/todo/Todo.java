package com.fvthree.springbootoktastarter.todo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="todo")
public class Todo implements Serializable {
	
	private static final long serialVersionUID = 7770518410379985952L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="description", nullable=false)
	private String description;
	
	@CreationTimestamp
	@Column(nullable=false)
	private Date createdDate;
}
