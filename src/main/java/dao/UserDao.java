package dao;

import pojo.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的dao
 */
public interface UserDao {
    public List<User> finAll();
    public User login(User loginuser);

    void add(User user);

    void del(int id);

    User findById(int id);

    void update(User user);

    /**
     * 查询总记录数
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页记录
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);


    User findByUsername(String username);

    User findByCode(String code);

    void updateStatus(User user);

    void save(User user);
}
