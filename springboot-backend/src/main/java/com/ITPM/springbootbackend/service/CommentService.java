package com.ITPM.springbootbackend.service;

import com.ITPM.springbootbackend.model.CommentExaminer;
import com.ITPM.springbootbackend.model.CommentSupervisor;

public interface CommentService {

    CommentExaminer createCommentEx();

    CommentSupervisor createCommentSup();

    CommentExaminer getExCommentsByGroupId(String groupId);

    CommentSupervisor getSupCommentsByGroupId(String groupId);
}
