package cn.com.scitc.lover.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Music {
    private int musicId;
    private String musicname;
    private String musicurl;
    private String musicimg;
    private String lrc;
    private String tag;
    private String singerSingername;
    private String categoryCategoryname;
    private String albumAlbumname;

    @Id
    @Column(name = "musicId", nullable = false)
    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    @Basic
    @Column(name = "musicname", nullable = false, length = 20)
    public String getMusicname() {
        return musicname;
    }

    public void setMusicname(String musicname) {
        this.musicname = musicname;
    }

    @Basic
    @Column(name = "musicurl", nullable = false, length = 255)
    public String getMusicurl() {
        return musicurl;
    }

    public void setMusicurl(String musicurl) {
        this.musicurl = musicurl;
    }

    @Basic
    @Column(name = "musicimg", nullable = true, length = 255)
    public String getMusicimg() {
        return musicimg;
    }

    public void setMusicimg(String musicimg) {
        this.musicimg = musicimg;
    }

    @Basic
    @Column(name = "lrc", nullable = true, length = 255)
    public String getLrc() {
        return lrc;
    }

    public void setLrc(String lrc) {
        this.lrc = lrc;
    }

    @Basic
    @Column(name = "tag", nullable = true, length = 255)
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Basic
    @Column(name = "singer_singername", nullable = false, length = 20)
    public String getSingerSingername() {
        return singerSingername;
    }

    public void setSingerSingername(String singerSingername) {
        this.singerSingername = singerSingername;
    }

    @Basic
    @Column(name = "category_categoryname", nullable = true, length = 20)
    public String getCategoryCategoryname() {
        return categoryCategoryname;
    }

    public void setCategoryCategoryname(String categoryCategoryname) {
        this.categoryCategoryname = categoryCategoryname;
    }

    @Basic
    @Column(name = "album_albumname", nullable = true, length = 20)
    public String getAlbumAlbumname() {
        return albumAlbumname;
    }

    public void setAlbumAlbumname(String albumAlbumname) {
        this.albumAlbumname = albumAlbumname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Music music = (Music) o;
        return musicId == music.musicId &&
                Objects.equals(musicname, music.musicname) &&
                Objects.equals(musicurl, music.musicurl) &&
                Objects.equals(musicimg, music.musicimg) &&
                Objects.equals(lrc, music.lrc) &&
                Objects.equals(tag, music.tag) &&
                Objects.equals(singerSingername, music.singerSingername) &&
                Objects.equals(categoryCategoryname, music.categoryCategoryname) &&
                Objects.equals(albumAlbumname, music.albumAlbumname);
    }

    @Override
    public String toString() {
        return "Music{" +
                "musicId=" + musicId +
                ", musicname='" + musicname + '\'' +
                ", musicurl='" + musicurl + '\'' +
                ", musicimg='" + musicimg + '\'' +
                ", lrc='" + lrc + '\'' +
                ", tag='" + tag + '\'' +
                ", singerSingername='" + singerSingername + '\'' +
                ", categoryCategoryname='" + categoryCategoryname + '\'' +
                ", albumAlbumname='" + albumAlbumname + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(musicId, musicname, musicurl, musicimg, lrc, tag, singerSingername, categoryCategoryname, albumAlbumname);
    }
}
