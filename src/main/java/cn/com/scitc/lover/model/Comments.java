package cn.com.scitc.lover.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Comments {
    private int commentId;
    private String usersUsername;
    private String musicMusicname;
    private String text;
    private String time;
    @Transient
    private Users users;
    @Transient
    public Users getUsers() {
        return users;
    }
    @Transient
    public void setUsers(Users users) {
        this.users = users;
    }



    @Id
    @Column(name = "commentId", nullable = false)
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "users_username", nullable = false, length = 20)
    public String getUsersUsername() {
        return usersUsername;
    }

    public void setUsersUsername(String usersUsername) {
        this.usersUsername = usersUsername;
    }

    @Basic
    @Column(name = "music_musicname", nullable = false, length = 20)
    public String getMusicMusicname() {
        return musicMusicname;
    }

    public void setMusicMusicname(String musicMusicname) {
        this.musicMusicname = musicMusicname;
    }

    @Basic
    @Column(name = "text", nullable = false, length = 255)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "time", nullable = true, length = 30)
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments comments = (Comments) o;
        return commentId == comments.commentId &&
                Objects.equals(usersUsername, comments.usersUsername) &&
                Objects.equals(musicMusicname, comments.musicMusicname) &&
                Objects.equals(text, comments.text) &&
                Objects.equals(time, comments.time) &&
                Objects.equals(users,comments.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, usersUsername, musicMusicname, text, time,users);
    }
}
