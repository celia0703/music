package cn.com.scitc.lover.dao;

import cn.com.scitc.lover.model.Category;

import cn.com.scitc.lover.model.Collections;
import cn.com.scitc.lover.model.Music;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface CollectionDao extends CrudRepository<Collections,Integer> {
//    通过歌曲名和用户名来收藏歌曲
    @Query(value="select * from collections where music_musicname=? and users_username=?",nativeQuery = true)
    List<Collections> findAllByMusicMusicnameAndUsersUsername(@Param("music_musicname") String name, @Param("users_username") String username);
    @Transactional
    @Modifying
    @Query(value = "delete from collections where music_musicname=?",nativeQuery = true)
    int deleteByMusicMusicname(@Param("music_musicname") String name);


}
