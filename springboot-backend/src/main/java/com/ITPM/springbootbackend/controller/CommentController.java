package com.ITPM.springbootbackend.controller;

import com.ITPM.springbootbackend.model.CommentExaminer;
import com.ITPM.springbootbackend.model.CommentSupervisor;
import com.ITPM.springbootbackend.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CommentController {

    CommentService commentService;

    @PostMapping("/examiner/comments")
    public CommentExaminer createCommentEx(){
        return commentService.createCommentEx();
    }

    @PostMapping("/supervisor/comments")
    public CommentSupervisor createCommentSup(){
        return commentService.createCommentSup();
    }

    @GetMapping("/{group-id}/examiner/comments")
    public CommentExaminer getExCOmmentByGroupId(@PathVariable("group-id") String groupId){

        return commentService.getExCommentsByGroupId(groupId);
    }

    @GetMapping("/{group-id}/supervisor/comments")
    public CommentSupervisor getSupCommentsByGroupId(@PathVariable("group-id") String groupId){
        return commentService.getSupCommentsByGroupId(groupId);
    }

}
