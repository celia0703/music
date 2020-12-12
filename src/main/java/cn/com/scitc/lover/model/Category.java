package cn.com.scitc.lover.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Category {
    private int categoryId;
    private String categoryname;
    private String introduce;
    private String usersUsername;
    private String musicMusicname;

    @Id
    @Column(name = "categoryId", nullable = false)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "categoryname", nullable = true, length = 20)
    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    @Basic
    @Column(name = "introduce", nullable = true, length = 255)
    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
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
    @Column(name = "music_musicname", nullable = true, length = 20)
    public String getMusicMusicname() {
        return musicMusicname;
    }

    public void setMusicMusicname(String musicMusicname) {
        this.musicMusicname = musicMusicname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return categoryId == category.categoryId &&
                Objects.equals(categoryname, category.categoryname) &&
                Objects.equals(introduce, category.introduce) &&
                Objects.equals(usersUsername, category.usersUsername) &&
                Objects.equals(musicMusicname, category.musicMusicname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, categoryname, introduce, usersUsername, musicMusicname);
    }
}
