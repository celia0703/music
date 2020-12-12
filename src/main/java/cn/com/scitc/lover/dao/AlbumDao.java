package cn.com.scitc.lover.dao;

import cn.com.scitc.lover.model.Album;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumDao extends CrudRepository<Album,Integer> {
    //查询前四张专辑
    @Query(value = "select * from album Limit 4",nativeQuery = true)
    List<Album> findLimit();
}
