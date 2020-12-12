package cn.com.scitc.lover.dao;

import cn.com.scitc.lover.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface MusicDao extends CrudRepository<Music,Integer> {
//    歌单首页分页
    @Query(value = "select * from music",nativeQuery = true)
    Page<Music> findAll(Pageable pageable);
//    搜索模糊查询
    List<Music> findByMusicnameLike(String musicname);
//    根据音乐名查找
    Music findByMusicname(@Param("musicname") String musicname);
//  根据歌单查找
    List<Music> findByalbumAlbumname(@Param("albumAlbumname")String albumAlbumname);
//    根据ID换歌单
    Music findBymusicId(@Param("musicId") Integer id);
//    @Query(value="select * from music where albumAlbumname=?",nativeQuery = true);
//    List<Music> findAllBy
//通过collection表中的username来查找music表里面对应的信息
    @Query(value = "select * from music,collections where music.musicname = collections.music_musicname and users_username = ?",nativeQuery = true)
    List<Music> findAllByUsername(@Param("users_username") String username);
}
