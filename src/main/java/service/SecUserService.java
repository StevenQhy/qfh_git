package service;

import pojo.PageBean;
import pojo.SecUser;

import java.util.List;
import java.util.Map;

public interface SecUserService {
    public List<SecUser> FindAll();

    /**
     * 添加二级管理
     * @param secuser
     */
    void addSecUser(SecUser secuser);

    void delsec(String id);

    SecUser findSecUserById(String id);

    void updateSecUser(SecUser secuser);

    void delSelSecUser(String[] ids);

    /**
     * 分页查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<SecUser> findSecUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
