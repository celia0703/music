package cn.com.scitc.lover.dao;

import cn.com.scitc.lover.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminDao extends CrudRepository<Admin,Integer> {
     Admin findByadmin(String admin);
}
