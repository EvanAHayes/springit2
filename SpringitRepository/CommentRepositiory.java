package com.ehayes.springit2.SpringitRepository;

import com.ehayes.springit2.Springitmodel.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepositiory extends JpaRepository<Comment, Long> {

}
