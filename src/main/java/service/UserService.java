package service;

import pojo.PageBean;
import pojo.User;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的业务接口
 */
public interface UserService {
    /**
     * 查询所有用户信息
     */
    public List<User> findAll();
    public User login(User loginser);

    /**
     * 保存user
     * @param user
     */
    void addUser(User user);

    /**
     * 根据id删除user
     */
    void del(String id);

    /**
     * 查找用户by id
     * @param id
     * @return
     */
    User findUserById(String id);

    /**
     * 修改用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 批量删除用户
     * @param ids
     */
    void delSelectedUser(String[] ids);

    /**
     * 分页查询&分页条件查询
     *
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);

    /**
     * 注册用户
     * @param user
     * @return
     */
    boolean regist(User user);

    boolean active(String code);
}
