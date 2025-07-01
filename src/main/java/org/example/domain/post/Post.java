package org.example.domain.post;

import org.example.common.PositiveIntegerCounter;
import org.example.domain.post.content.PostContent;
import org.example.domain.user.User;

public class Post {
    private final Long id;
    private final User author;
    private final PostContent content;
    private final PositiveIntegerCounter likeCount;

    public Post(Long id, User author, PostContent content, PositiveIntegerCounter likeCount) {
        if(author == null)
            throw new IllegalArgumentException();

        this.id = id;
        this.author = author;
        this.content = content;
        this.likeCount = new PositiveIntegerCounter();
    }

    public void like(User user){
        if(this.author.equals(user))
            throw new IllegalArgumentException();

        likeCount.increase();
    }

    public void unlike(){
        likeCount.decrease();
    }
}
