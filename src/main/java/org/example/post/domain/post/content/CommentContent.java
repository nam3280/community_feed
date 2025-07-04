package org.example.post.domain.post.content;

import org.example.post.domain.common.Content;

public class CommentContent extends Content {
    private static final int MAX_POST_LENGTH = 100;

    public CommentContent(String contentText) {
        super(contentText);
    }

    @Override
    protected void checkText(String contentText) {
        if(contentText == null || contentText.isEmpty())
            throw new IllegalArgumentException();

        if(contentText.length() > MAX_POST_LENGTH)
            throw new IllegalArgumentException();
    }
}
