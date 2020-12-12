package cn.com.scitc.lover.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Recommend {
    private int recommendId;
    private String recname;
    private String recimg;

    @Id
    @Column(name = "recommendId", nullable = false)
    public int getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(int recommendId) {
        this.recommendId = recommendId;
    }

    @Basic
    @Column(name = "recname", nullable = true, length = 20)
    public String getRecname() {
        return recname;
    }

    public void setRecname(String recname) {
        this.recname = recname;
    }

    @Basic
    @Column(name = "recimg", nullable = true, length = 255)
    public String getRecimg() {
        return recimg;
    }

    public void setRecimg(String recimg) {
        this.recimg = recimg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recommend recommend = (Recommend) o;
        return recommendId == recommend.recommendId &&
                Objects.equals(recname, recommend.recname) &&
                Objects.equals(recimg, recommend.recimg);
    }

    @Override
    public String toString() {
        return "Recommend{" +
                "recommendId=" + recommendId +
                ", recname='" + recname + '\'' +
                ", recimg='" + recimg + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(recommendId, recname, recimg);
    }
}
