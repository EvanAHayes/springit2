package com.ehayes.springit2.Service;

import com.ehayes.springit2.SpringitRepository.CommentRepositiory;
import com.ehayes.springit2.Springitmodel.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepositiory commentRepositiory;

    public CommentService(CommentRepositiory commentRepositiory) {
        this.commentRepositiory = commentRepositiory;
    }

    public Comment save(Comment comment){
        return commentRepositiory.save(comment);

    }


}
