package com.juzimi.mapper;

import com.juzimi.domain.Admin;
import com.juzimi.domain.Album;
import com.juzimi.domain.SentencePro;
import com.juzimi.domain.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(String adminId);

    int insert(Admin record);

    Admin selectByPrimaryKey(String adminId);

    List<Admin> selectAll();

    int updateByPrimaryKey(Admin record);

    // 登录 根据用户名密码
    Admin selectByUidWidthPwd(Admin record);
    /* 统计总用户或总句子数量 */
    int selectCountAll(@Param("tabName") String tabName);
    /* 统计今日注册用户和今日发布的句子 */
    int selectCountTodayNum(@Param("tabName") String tabName);
    // 根据表名和前n天统计新增数据
    int selectCountNewData(@Param("tabName") String tabName, @Param("num") Integer num);
    // 根据id或姓名搜索用户
    List<Users> selectUsersByIdOrName(@Param("key") String key);
    // 根据专辑名称或专辑详情搜索专辑
    List<Album> selectAlbumByNameOrDetails(@Param("key") String key);
    // 根据句子内容或句子作者跟搜索句子
    List<SentencePro> selectSentenceByTxt(@Param("key") String key);
}