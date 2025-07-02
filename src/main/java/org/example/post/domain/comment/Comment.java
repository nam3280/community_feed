package org.example.post.domain.comment;

import org.example.common.domain.PositiveIntegerCounter;
import org.example.post.domain.Post;
import org.example.post.domain.common.Content;
import org.example.user.domain.User;

public class Comment {
    private final Long id;
    private final Post post;
    private final User author;
    private final Content content;
    private final PositiveIntegerCounter likeCounter;

    public Comment(Long id, Post post, User author, Content content, PositiveIntegerCounter likeCounter) {
        if(author == null)
            throw new IllegalArgumentException();

        if(post == null)
            throw new IllegalArgumentException();

        if(content == null)
            throw new IllegalArgumentException();

        this.id = id;
        this.post = post;
        this.author = author;
        this.content = content;
        this.likeCounter = new PositiveIntegerCounter();
    }

    public void like(User user){
        if(this.author.equals(user))
            throw new IllegalArgumentException();

        likeCounter.increase();
    }

    public void unlike(){
        likeCounter.decrease();
    }

    public void updateComment(User user, String updateContent){
        if(!this.author.equals(user))
            throw new IllegalArgumentException();

        this.content.updateContent(updateContent);
    }
}
