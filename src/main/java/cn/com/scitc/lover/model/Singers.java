package cn.com.scitc.lover.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Singers {
    private int singerId;
    private String singername;
    private String gender;
    private String singerimg;
    private String catename;
    private String initial;
    private String introduce;

    @Id
    @Column(name = "singerId", nullable = false)
    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    @Basic
    @Column(name = "singername", nullable = false, length = 20)
    public String getSingername() {
        return singername;
    }

    public void setSingername(String singername) {
        this.singername = singername;
    }

    @Basic
    @Column(name = "gender", nullable = true, length = 2)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "singerimg", nullable = true, length = 255)
    public String getSingerimg() {
        return singerimg;
    }

    public void setSingerimg(String singerimg) {
        this.singerimg = singerimg;
    }

    @Basic
    @Column(name = "catename", nullable = true, length = 255)
    public String getCatename() {
        return catename;
    }

    public void setCatename(String catename) {
        this.catename = catename;
    }

    @Basic
    @Column(name = "initial", nullable = true, length = 2)
    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    @Basic
    @Column(name = "introduce", nullable = true, length = 255)
    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Singers singers = (Singers) o;
        return singerId == singers.singerId &&
                Objects.equals(singername, singers.singername) &&
                Objects.equals(gender, singers.gender) &&
                Objects.equals(singerimg, singers.singerimg) &&
                Objects.equals(catename, singers.catename) &&
                Objects.equals(initial, singers.initial) &&
                Objects.equals(introduce, singers.introduce);
    }

    @Override
    public int hashCode() {
        return Objects.hash(singerId, singername, gender, singerimg, catename, initial, introduce);
    }
}
