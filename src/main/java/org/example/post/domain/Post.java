package org.example.post.domain;

import org.example.common.domain.PositiveIntegerCounter;
import org.example.post.domain.post.content.PostContent;
import org.example.user.domain.User;

public class Post {
    private final Long id;
    private final User author;
    private final PostContent content;
    private final PositiveIntegerCounter likeCount;
    private PostPublicationState state;

    public Post(Long id, User author, PostContent content, PositiveIntegerCounter likeCount) {
        if(author == null)
            throw new IllegalArgumentException();

        this.id = id;
        this.author = author;
        this.content = content;
        this.likeCount = new PositiveIntegerCounter();
        this.state = PostPublicationState.PUBLIC;
    }

    public void like(User user){
        if(this.author.equals(user))
            throw new IllegalArgumentException();

        likeCount.increase();
    }

    public void unlike(){
        likeCount.decrease();
    }

    public void updatePost(User user, String updateContent, PostPublicationState state){
        if(!this.author.equals(user))
            throw new IllegalArgumentException();

        this.state = state;
        this.content.updateContent(updateContent);
    }
}
