package cn.com.scitc.lover.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Album {
    private int albumId;
    private String albumname;
    private String albumimg;
    private Date albumtime;
    private String singerSingername;

    @Id
    @Column(name = "albumId", nullable = false)
    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    @Basic
    @Column(name = "albumname", nullable = false, length = 20)
    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    @Basic
    @Column(name = "albumimg", nullable = true, length = 255)
    public String getAlbumimg() {
        return albumimg;
    }

    public void setAlbumimg(String albumimg) {
        this.albumimg = albumimg;
    }

    @Basic
    @Column(name = "albumtime", nullable = true)
    public Date getAlbumtime() {
        return albumtime;
    }

    public void setAlbumtime(Date albumtime) {
        this.albumtime = albumtime;
    }

    @Basic
    @Column(name = "singer_singername", nullable = false, length = 20)
    public String getSingerSingername() {
        return singerSingername;
    }

    public void setSingerSingername(String singerSingername) {
        this.singerSingername = singerSingername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return albumId == album.albumId &&
                Objects.equals(albumname, album.albumname) &&
                Objects.equals(albumimg, album.albumimg) &&
                Objects.equals(albumtime, album.albumtime) &&
                Objects.equals(singerSingername, album.singerSingername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(albumId, albumname, albumimg, albumtime, singerSingername);
    }
}
