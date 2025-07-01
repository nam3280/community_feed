package org.example.user.domain;

import java.util.Objects;

public class User {
    private final Long id;
    private final UserInfo info;
    private final UserRelationCounter followingCounter;
    private final UserRelationCounter followerCounter;

    public User(Long id, UserInfo userInfo) {
        this.id = id;
        this.info = userInfo;
        this.followingCounter = new UserRelationCounter();
        this.followerCounter = new UserRelationCounter();
    }

    public void follow(User targetUser){
        if(targetUser.equals(this))
            throw new IllegalArgumentException();

        followingCounter.increase();
        targetUser.followerCounter.increase();
    }

    public void unFollow(User targetUser){
        if(targetUser.equals(this))
            throw new IllegalArgumentException();

        followingCounter.decrease();
        targetUser.followerCounter.decrease();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
