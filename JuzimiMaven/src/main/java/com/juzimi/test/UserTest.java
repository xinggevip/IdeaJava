package com.juzimi.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.juzimi.domain.*;
import com.juzimi.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class UserTest {

    @Test
    public void userServiceTest(){
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersService us = springApp.getBean(UsersService.class);
        Users u = new Users();
        u.setUserId("ggg");
        u.setUserPassword("kkk");
        String register = us.register(u);
        System.out.println(register);
        System.out.println(us);
    }

    @Test
    public void test(){
        // 测试通过类型id获取专辑列表
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        AlbumService albumService = springApp.getBean(AlbumService.class);
        List<Album> albumsByClassifyId = albumService.getAlbumsByClassifyId(5);
        System.out.println(albumsByClassifyId);

    }

    @Test
    public void test1(){
        // 测试分页查询
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        AlbumService albumService = springApp.getBean(AlbumService.class);

        /* 配置分页查询 从第几页开始查，一页查多少条记录 */
        Page<Album> pageIn = PageHelper.startPage(1,2);

        List<Album> albumList = albumService.getAlbumsByClassifyId(1);

        /* 信息更加详细 配置导航显示几条页码 */
        PageInfo<Album> pageInfo = new PageInfo<>(albumList, 3);

        for (Album album : albumList) {
            System.out.println(album);
        }

        System.out.println("当前页:"+pageInfo.getPageNum());
        System.out.println("每页显示记录数:"+pageInfo.getPageSize());
        System.out.println("总页数:"+pageInfo.getPages());
        System.out.println("总记录数:"+pageInfo.getTotal());
        System.out.println("是否有上一页:"+pageInfo.isHasPreviousPage());
        System.out.println("是否有下一页:"+pageInfo.isHasNextPage());
        System.out.println("导航页码:"+ Arrays.toString(pageInfo.getNavigatepageNums()));


    }

    @Test
    public void SentenceTest(){
        // 发布句子测试
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        SentenceSerive sentenceSerive = springApp.getBean(SentenceSerive.class);

        Sentence sentence = new Sentence();
        sentence.setSentenceTxt("好男人就是我，我就是xxx");
        sentence.setAlbumId(1);
        sentence.setClassfiyId(1);
        sentence.setAuthorName("曾小贤");
        sentence.setUserId("xing");

        //时间转换
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        //上传时间
        sentence.setCreateDate(Timestamp.valueOf(nowTime));

        System.out.println(sentence);

        Result result = sentenceSerive.addSentence(sentence);
        System.out.println(result);


    }

    @Test
    public void SentenceTest1(){
        // 根据句子专辑id查句子测试
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        SentenceSerive sentenceSerive = springApp.getBean(SentenceSerive.class);

        AutoSentence autoSentence = sentenceSerive.selectSentenceByAlbumId(2, 2, 2);
        for (Sentence sentence : autoSentence.getSentenceList()) {
            System.out.println(sentence);
        }
        System.out.println(autoSentence.getNext());

    }

    @Test
    public void SentenceTest2() {
        /* 根据专辑id查询记录个数 */
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        SentenceSerive sentenceSerive = springApp.getBean(SentenceSerive.class);

        SentenceCount count = sentenceSerive.selectSentenceCount(2);
        System.out.println(count);


    }

    @Test
    public void SentenceTest3(){
        /* 查所有句子展示在首页 */
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        SentenceSerive sentenceSerive = springApp.getBean(SentenceSerive.class);

        AutoSentencePro autoSentencePro = sentenceSerive.selectAllSentence(1, 10);

        for (SentencePro sentencePro : autoSentencePro.getSentenceProList()) {
            System.out.println(sentencePro);
        }

        System.out.println(autoSentencePro.getNext());
    }

    @Test
    public void firstdataTest(){
        /* 查所有句子展示在首页 */
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        FirstPageDataSerive firstPageDataSerive = springApp.getBean(FirstPageDataSerive.class);
        ResultFirstPageData resultFirstPageData = firstPageDataSerive.getFirstPageData("xing", 1, 50);
        for (FirstPageData firstPageData : resultFirstPageData.getFirstPageDataList()) {
            System.out.println(firstPageData);
        }
        System.out.println(resultFirstPageData.getNext());
    }

    @Test
    public void tolike(){
        // 收藏功能测试
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserlikesenSerive userlikesenSerive = springApp.getBean(UserlikesenSerive.class);

        Userlikesen userlikesen = new Userlikesen();
        userlikesen.setUserId("xing");
        userlikesen.setSentenceId(31);
        Result result = userlikesenSerive.toLike(userlikesen);
        System.out.println(result);

    }

    @Test
    public void toNolike(){
        // 取消收藏功能测试
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserlikesenSerive userlikesenSerive = springApp.getBean(UserlikesenSerive.class);

        Userlikesen userlikesen = new Userlikesen();
        userlikesen.setUserId("xing");
        userlikesen.setSentenceId(44);

        Result result = userlikesenSerive.toNoLike(userlikesen);
        System.out.println(result);

    }

    @Test
    public void getAlbumPageData(){
        // 获取专辑中的所有句子
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        FirstPageDataSerive albumPageDataSerive = springApp.getBean(FirstPageDataSerive.class);

        ResultFirstPageData albumPagedata = albumPageDataSerive.getAlbumPagedata("xing", 2, 1, 10);
        for (FirstPageData firstPageData : albumPagedata.getFirstPageDataList()) {
            System.out.println(firstPageData);
        }
        System.out.println(albumPagedata.getNext());

    }



}
