package com.library.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
@Table(name="book_issued_transaction")
public class BookIssuedTransaction {
	@Id
	@GeneratedValue
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookId", referencedColumnName = "bookId")
	private Book book;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "issuedTo", referencedColumnName = "userId")
	private User userId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "issuedBy",referencedColumnName = "userId")
	private User userType;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "createdBy",referencedColumnName = "userId")
	private User createdBy;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "modifiedBy", referencedColumnName = "userId")
	private User modifiedBy;
	}

