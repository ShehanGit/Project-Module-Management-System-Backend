package com.ITPM.springbootbackend.service.impl;

import com.ITPM.springbootbackend.model.CommentExaminer;
import com.ITPM.springbootbackend.model.CommentSupervisor;
import com.ITPM.springbootbackend.repository.ExaminerCommentRepo;
import com.ITPM.springbootbackend.repository.SupervisorCommentRepository;
import com.ITPM.springbootbackend.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    ExaminerCommentRepo examinerCommentRepo;
    SupervisorCommentRepository supervisorCommentRepository;

    @Override
    public CommentExaminer createCommentEx() {

        CommentExaminer commentExaminer = new CommentExaminer();
        commentExaminer.setGroupId("IT001");
        commentExaminer.setProposal("good work");
        commentExaminer.setProgress1("beautiful");
        commentExaminer.setProgress2("great work");
        commentExaminer.setFinalPresentation("nice");


       return examinerCommentRepo.save(commentExaminer);

    }

    @Override
    public CommentSupervisor createCommentSup() {

        CommentSupervisor commentSupervisor = new CommentSupervisor();

        commentSupervisor.setGroupId("IT001");
        commentSupervisor.setStatusDoc1("wow");
        commentSupervisor.setLogBook("nice work");
        commentSupervisor.setProposalDoc("good");
        commentSupervisor.setStatusDoc2("great");
        commentSupervisor.setFinalThesis("superb");

        return supervisorCommentRepository.save(commentSupervisor);
    }

    @Override
    public CommentExaminer getExCommentsByGroupId(String groupId) {

        CommentExaminer commentExaminer = examinerCommentRepo.findCommentExaminerByGroupId(groupId);

        if (commentExaminer == null){
            return null;
        }

        return commentExaminer;
    }

    @Override
    public CommentSupervisor getSupCommentsByGroupId(String groupId) {

        CommentSupervisor commentSupervisor = supervisorCommentRepository.findCommentSupervisorByGroupId(groupId);

        if (commentSupervisor == null){
            return null;
        }

        return commentSupervisor;

    }
}
