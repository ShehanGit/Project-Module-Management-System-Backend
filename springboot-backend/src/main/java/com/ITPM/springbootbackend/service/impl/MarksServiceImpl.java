package com.ITPM.springbootbackend.service.impl;

import com.ITPM.springbootbackend.model.CommentExaminer;
import com.ITPM.springbootbackend.model.CommentSupervisor;
import com.ITPM.springbootbackend.model.Marks;
import com.ITPM.springbootbackend.repository.MarksRepository;
import com.ITPM.springbootbackend.service.MarksService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MarksServiceImpl implements MarksService {

    private final MarksRepository repository;

    @Override
    public Marks addMarks() {

        Marks marks = new Marks();
        marks.setGroupId("IT001");
        marks.setStudentId("004");
        marks.setStudentName("saman");
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
        marks.setPassFailStatus("fail");


        return repository.save(marks);
    }

    @Override
    public List<Marks> getMarksByGroupId(String groupId) {

        return repository.findByGroupId(groupId);
    }

    @Override
    public Marks updateMarksByGroupId(String groupId ,String studentId,  Marks updatedMarks) {

        Optional<Marks> existingMarks = repository.findByGroupIdAndStudentId(groupId, studentId);

        if (existingMarks.isPresent()) {
            Marks marks = existingMarks.get();
            marks.setProposal(updatedMarks.getProposal());
            marks.setProgress1(updatedMarks.getProgress1());
            marks.setProgress2(updatedMarks.getProgress2());
            marks.setFinalPresentation(updatedMarks.getFinalPresentation());
            marks.setStatusDoc(updatedMarks.getStatusDoc());
            marks.setLogBook(updatedMarks.getLogBook());
            marks.setProposalDocument(updatedMarks.getProposalDocument());
            marks.setStatusDoc2(updatedMarks.getStatusDoc2());
            marks.setFinalThesis(updatedMarks.getFinalThesis());
            marks.setTotalMarks(updatedMarks.getTotalMarks());

            return repository.save(marks);
        }

        return null;
    }
}