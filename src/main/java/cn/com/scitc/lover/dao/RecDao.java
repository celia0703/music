package cn.com.scitc.lover.dao;

import cn.com.scitc.lover.model.Recommend;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RecDao extends CrudRepository<Recommend,Integer> {
    @Query(value = "select * from  recommend where  recommendId = ? ",nativeQuery = true)
    Recommend findByRecId(@Param("recommendId") Integer recommendId);
    @Transactional
    @Modifying
//   更新插入
    @Query(value = "update recommend set recImg = ? where recommendId = ?",nativeQuery = true)
    void update(@Param("recImg")String recImg,@Param("recommendId") Integer recommendId);
}
