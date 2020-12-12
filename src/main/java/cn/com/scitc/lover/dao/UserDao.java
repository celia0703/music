package cn.com.scitc.lover.dao;

import cn.com.scitc.lover.model.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserDao extends CrudRepository<Users,Integer> {
    public Users findByUsername(String username);
    Users findByUserId(@Param("userId") Integer id);
//    更新头像
    @Transactional
    @Modifying
    @Query(value = "update users set username=?,age=?,gender=?,number=?,userimg = ? where userId=?",nativeQuery = true)
    void update(@Param("username") String username,@Param("age") Integer age,@Param("gender") String gender,@Param("number") String number,@Param("userimg") String userimg,@Param("userId") Integer userId);

}
