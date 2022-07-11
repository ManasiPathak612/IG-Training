package com.library.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name ="book_table")
public class Book {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long bookId;
	private String bookName;
	private String bookAuthor;
	private String bookPublication;
	private int numberOfPages;
	private double bookPrice;
	private int noOfCopies;

	
	
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date createdOn;
	
	
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date modifiedOn;
	
	@ManyToOne
	@JoinColumn(name = "createdBy", referencedColumnName = "userId")
	private User createdBy;
	
	@ManyToOne
	@JoinColumn(name = "modifiedBy", referencedColumnName = "userId")
	private User modifiedBy;	
} 
