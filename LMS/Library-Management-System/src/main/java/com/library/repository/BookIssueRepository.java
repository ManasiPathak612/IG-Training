package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.controller.BookIssueController;
import com.library.model.BookIssue;

public interface BookIssueRepository extends JpaRepository<BookIssue, Long> {

}
