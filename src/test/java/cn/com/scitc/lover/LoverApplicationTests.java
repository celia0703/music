package cn.com.scitc.lover;

import cn.com.scitc.lover.dao.AlbumDao;
import cn.com.scitc.lover.dao.MusicDao;
import cn.com.scitc.lover.dao.RecDao;
import cn.com.scitc.lover.model.Album;
import cn.com.scitc.lover.model.Music;
import cn.com.scitc.lover.model.Recommend;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoverApplicationTests {
    @Autowired
    private RecDao recDao;
    @Autowired
    private MusicDao musicDao;
    @Autowired
    private AlbumDao albumDao;
    @Test
    public void contextLoads() {
    }
//    轮播图
    @Test
    public void test1(){
        Recommend recommend = recDao.findByRecId(1);
        System.out.println(recommend);
    }
    @Test
    public void test2(){
        Pageable pageable =  PageRequest.of(0,5);
        Page<Music> page = musicDao.findAll(pageable);
        Object music = JSON.toJSON(page);
        System.out.println(music);
    }
    @Test
    public void test3(){
        Iterable<Album> all = albumDao.findAll();
        for(Album a:all){
            System.out.println(a.getAlbumname());
        }
    }
    @Test
    public void  test4(){
        Music byMusicname = musicDao.findByMusicname("lover");
        System.out.println(byMusicname);
    }
    @Test
    public void test05(){
        Random  r = new Random();
        List<Integer> list = new ArrayList<Integer>();
        int i;
        while(list.size() < 8){
            i = r.nextInt(10);
            if(!list.contains(i)){
                list.add(i);
            }
        }
        System.out.println(list);

    }
}
