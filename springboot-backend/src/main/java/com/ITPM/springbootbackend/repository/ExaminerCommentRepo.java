package com.ITPM.springbootbackend.repository;

import com.ITPM.springbootbackend.model.CommentExaminer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminerCommentRepo extends JpaRepository<CommentExaminer , Long> {

    CommentExaminer findCommentExaminerByGroupId(String groupId);
}
