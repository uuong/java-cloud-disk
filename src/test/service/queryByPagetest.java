package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sky.service.inter.FileService;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/3/3 0003
 * Time: 12:55
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mvc.xml", "classpath:applicationContext.xml"})
public class queryByPagetest {
    @Autowired
    private FileService fileService;

    @Test
    public void queryByPage() {
        //PagedResult<FileMode> pagedResult = fileService.queryByPage(null, 1, 10);//null表示查全部
        //System.out.println("查找结果" + pagedResult);
    }
}
