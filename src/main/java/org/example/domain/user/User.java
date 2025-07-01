package org.example.domain.user;

import org.example.common.PositiveIntegerCounter;

import java.util.Objects;

public class User {
    private final Long id;
    private final UserInfo info;
    private final PositiveIntegerCounter followingCounter;
    private final PositiveIntegerCounter followerCounter;

    public User(Long id, UserInfo userInfo) {
        this.id = id;
        this.info = userInfo;
        this.followingCounter = new PositiveIntegerCounter();
        this.followerCounter = new PositiveIntegerCounter();
    }

    public void follow(User targetUser){
        if(targetUser.equals(this))
            throw new IllegalArgumentException();

        followingCounter.increase();
        increaseFollowerCount();
    }

    public void unFollow(User targetUser){
        if(targetUser.equals(this))
            throw new IllegalArgumentException();

        followingCounter.decrease();
        decreaseFollowerCount();
    }

    private void increaseFollowerCount(){
        followerCounter.increase();
    }

    private void decreaseFollowerCount(){
        followerCounter.decrease();
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

    public Long getId() {
        return id;
    }
}
