package com.juzimi.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.juzimi.domain.Admin;
import com.juzimi.domain.Result;
import com.juzimi.domain.Users;
import com.juzimi.mapper.AdminMapper;
import com.juzimi.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminSeriveImpl implements AdminSerive {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UsersMapper usersMapper;

    // 管理员登录
    @Override
    public Admin login(Admin admin) {
        try {
            Admin admin1 = adminMapper.selectByUidWidthPwd(admin);
            return admin1;
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    // 获取用户列表
    @Override
    public PageInfo getUserListResult(Integer pageNum, Integer pageSize) {
        try {

            /* 配置分页查询 从第几页开始查，一页查多少条记录 */
            String orderBy = "create_date  desc";//按照排序字段 倒序 排序
            Page<Users> pageIn = PageHelper.startPage(pageNum,pageSize,orderBy);

            List<Users> users = usersMapper.selectAll();

            /* 信息更加详细 配置导航显示几条页码 */
            PageInfo<Users> pageInfo = new PageInfo<>(users, 4);

//            System.out.println("当前页:"+pageInfo.getPageNum());
//            System.out.println("每页显示记录数:"+pageInfo.getPageSize());
//            System.out.println("总页数:"+pageInfo.getPages());
//            System.out.println("总记录数:"+pageInfo.getTotal());
//            System.out.println("是否有上一页:"+pageInfo.isHasPreviousPage());
//            System.out.println("是否有下一页:"+pageInfo.isHasNextPage());
//            System.out.println("导航页码:"+ Arrays.toString(pageInfo.getNavigatepageNums()));

            return pageInfo;
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    // 批量设置激活
    @Override
    public Result setYesActive(List<Users> usersList) {
        try {
            for (Users user : usersList) {
                // 为了节省服务器资源，前端已经更新为激活状态了
                usersMapper.updateByPrimaryKey(user);
            }
            return new Result(true,"操作成功");
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return new Result(false,"操作失败");
        }
    }

    // 删除
    @Override
    public Result delOneUser(Users user) {
        try {
            int i = usersMapper.deleteByPrimaryKey(user.getUserId());
            if (i > 0){
                return new Result(true,"删除成功");
            }else{
                return new Result(false,"删除失败");
            }
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return new Result(false,"删除失败");
        }
    }

    // 批量删除
    @Override
    public Result delSomeUser(List<Users> usersList) {
        try {
            for (Users user : usersList) {
                usersMapper.deleteByPrimaryKey(user.getUserId());
            }
            return new Result(true,"操作成功");
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return new Result(false,"操作失败");
        }
    }


}
