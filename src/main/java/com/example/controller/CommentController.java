package com.example.controller;

import com.example.domain.Comment;
import com.example.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping() // http://localhost:8080/comments  + POST + JSON
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment){
      Comment comment1 =  commentService.saveComment(comment);
      return ResponseEntity.ok(comment1);
    }

    @GetMapping("{commentId}")
    public ResponseEntity<Comment> getById(@PathVariable UUID commentId ) {
        Comment comment = commentService.getById(commentId);
        return ResponseEntity.ok(comment);
    }

    @DeleteMapping("{commentId}")
    public ResponseEntity<String> deleteById(@PathVariable UUID commentId){
        commentService.deleteById(commentId);
        String message = "comment is deleted successfully";
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(message);
    }

    @GetMapping()
    public ResponseEntity<List<Comment>> getAll(){
        return ResponseEntity.ok(commentService.getAll());
    }
}
