package com.library.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="book_issue_table")
public class BookIssue {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long transactionId;
	
	private String transactionStatus;
	
	private String remarks;
	

	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date bookIssueDate;
	
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date bookReturnDate;
	
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date actualBookReturnDate;
	
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date createdOn;
	
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date modifiedOn;

	@ManyToOne
	@JoinColumn(name = "bookId", referencedColumnName = "bookId")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name = "issuedTo", referencedColumnName = "userId")
	private User issuedTo;
	
	@ManyToOne
	@JoinColumn(name = "issuedBy",referencedColumnName = "userId")
	private User issuedBy;
	
	@ManyToOne
	@JoinColumn(name = "createdBy",referencedColumnName = "userId")
	private User createdBy;
	
	
	@ManyToOne
	@JoinColumn(name = "modifiedBy", referencedColumnName = "userId")
	private User modifiedBy;

}
