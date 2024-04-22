package com.ITPM.springbootbackend.service.impl;

import com.ITPM.springbootbackend.model.CommentExaminer;
import com.ITPM.springbootbackend.model.CommentSupervisor;
import com.ITPM.springbootbackend.model.Marks;
import com.ITPM.springbootbackend.repository.MarksRepository;
import com.ITPM.springbootbackend.service.MarksService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MarksServiceImpl implements MarksService {

    private final MarksRepository repository;

    @Override
    public Marks addMarks() {

           Marks marks = new Marks();
           marks.setGroupId("IT001");
           marks.setStudentId("001");
           marks.setStudentName("anjana");
           marks.setProposal(20);
           marks.setProgress1(49);
           marks.setProgress2(34);
           marks.setFinalPresentation(56);
           marks.setStatusDoc(78);
           marks.setLogBook(56);
           marks.setProposalDocument(47);
           marks.setStatusDoc2(44);
           marks.setFinalThesis(43);
           marks.setTotalMarks(89);
           marks.setPassFailStatus("pass");

            CommentExaminer commentExaminer = new CommentExaminer();
            commentExaminer.setGroupId(marks.getGroupId());
            commentExaminer.setProposal("good one");
            commentExaminer.setProgress1("nice");
            commentExaminer.setProgress2("nice work");
            commentExaminer.setFinalPresentation("wonderfull");
            marks.getCommentExaminers().add(commentExaminer);
            commentExaminer.setMarks(marks);

        CommentSupervisor commentSupervisor = new CommentSupervisor();
        commentSupervisor.setGroupId(marks.getGroupId());
        commentSupervisor.setStatusDoc1("super");
        commentSupervisor.setLogBook("excellent");
        commentSupervisor.setProposalDoc("nice try");
        commentSupervisor.setStatusDoc2("wow");
        commentSupervisor.setFinalThesis("good job");
        marks.getCommentSupervisors().add(commentSupervisor);
        commentSupervisor.setMarks(marks);


           return repository.save(marks);

    }

    @Override
    public List<Marks> getMarksByGroupId(String groupId) {
        return repository.findByGroupId(groupId);
    }
}