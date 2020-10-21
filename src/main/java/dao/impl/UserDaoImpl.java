package dao.impl;

import dao.UserDao;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pojo.User;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> finAll() {
        //使用jdbc操作数据库
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override//findUserByUsernameAndPassword
    public User login(User loginuser) {
        try {
            //1.编写sql
            String sql ="select * from user where username = ? and password = ?";
            //2.调用query方法
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginuser.getUsername(), loginuser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    public void del(int id) {
        String sql = "delete from user where id=?";
        template.update(sql,id);
    }

    @Override
    public User findById(int id) {
        String sql = "select * from user where id=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public void update(User user) {
        String sql = "update user set name=?,gender=?,age=?,address=?,qq=?,email=? where id=?";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //定义模板初始化sql
        String sql = "select count(*) from user where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        //遍历map
        Set<String> keySet = condition.keySet();
        //定义一个参数的集合
        List<Object> params = new ArrayList<Object>();

        for (String key : keySet) {

            //排除分页的参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];

            //判断value是否有值
            if(value !=null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//?条件的值
            }
        }


        int i = template.queryForObject(sb.toString(),Integer.class,params.toArray());//自动拆箱
        return i;
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        List<Object> param = new ArrayList<Object>();
        for (String key : keySet) {
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
            if (value != null || !"".equals(value)){
                sb.append(" and "+key+" like ? ");
                param.add("%"+value+"%");
            }
        }

        //添加分页查询
        sb.append(" limit ?,? ");
        //添加分页查询参数
        param.add(start);
        param.add(rows);

        List<User> query = template.query(sb.toString(), new BeanPropertyRowMapper<User>(User.class),param.toArray());
        return query;
    }

    @Override
    public User findByUsername(String username) {
        User user = null;
        try {
            String sql = "select * from user where username = ?";
            template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username);
        } catch (DataAccessException e) {

        }
        return user;
    }

    @Override
    public User findByCode(String code) {
        User user = null;

        try {
            String sql = "select * from user where code = ?";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), code);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateStatus(User user) {
        String sql = "update user set status = 'Y' where id=?";
        template.update(sql,user.getId());
    }

    @Override
    public void save(User user) {
        String sql = "insert into user(id,name,age,gender,address,email,username,password,code,status) values(null,?,?,?,?,?,?,?,?,?)";
        template.update(sql,
                user.getName(),
                user.getAge(),
                user.getGender(),
                user.getAddress(),
                user.getEmail(),
                user.getUsername(),
                user.getPassword(),
                user.getCode(),
                user.getStatus());
    }


}
