package dao;

import pojo.SecUser;

import java.util.List;
import java.util.Map;

public interface SecUserDao {
    public List<SecUser> findAll();

    void add(SecUser secuser);

    void del(int id);

    SecUser findById(int id);

    void update(SecUser secuser);

    int findTotalCount(Map<String, String[]> condition);

    List<SecUser> findSecByPage(int start, int rows, Map<String, String[]> condition);
}
