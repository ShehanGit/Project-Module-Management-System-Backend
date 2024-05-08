package com.ITPM.springbootbackend.repository;

import com.ITPM.springbootbackend.model.CommentSupervisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupervisorCommentRepository extends JpaRepository<CommentSupervisor , Long> {

    CommentSupervisor findCommentSupervisorByGroupId(String groupId);
}
