package cn.com.scitc.lover.dao;

import cn.com.scitc.lover.model.Comments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CommentsDao extends CrudRepository <Comments,Integer>{
//    评论分页
    @Query(value = "select * from comments where music_musicname=?",nativeQuery = true)
    Page<Comments> findByMusicname(@Param("musicMusicname") String musicname,Pageable pageable);
//        按id删除评论
    Comments findByCommentId(@Param("CommentId") Integer id);
//    comment 查询单个音乐评论
//    List<Comments> findByMusicMusicname(@Param("musicMusicname") String musicname);
}
