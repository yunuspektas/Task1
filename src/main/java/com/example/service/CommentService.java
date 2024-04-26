package com.example.service;

import com.example.domain.Comment;
import com.example.exceptions.ResourceNotFoundException;
import com.example.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public Comment saveComment(Comment comment) {

        return commentRepository.save(comment);
    }

    public Comment getById(UUID commentId) {

        return commentRepository.findById(commentId).orElseThrow(()->
                new ResourceNotFoundException("Comment not fount with id : " + commentId));
    }

    public List<Comment> getAll() {

        return commentRepository.findAll(Sort.by(Sort.Direction.DESC, "time"));

    }

    public void deleteById(UUID commentId) {

        Comment comment = getById(commentId);
        commentRepository.delete(comment);
    }
}
