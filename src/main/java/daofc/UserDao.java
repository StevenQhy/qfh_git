package daofc;

import pojofc.User;
import utilfc.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDao {
    //写一个添加用户数据的方法 对于添加删除修改,方法返回值可以是受影响的行数 int
    public int addUserInfo(String name, String pwd) {
        //获取数据库连接对象
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = null;//创建一个 PreparedStatement 对象来将参数化的 SQL 语句发送到数据库

        int row = 0;
        String sql = "insert into tb_user(id,name,password,tel) values(null,?,?,?)";


        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pwd);
            ps.setString(3, null);


            row = ps.executeUpdate();
            //int executeUpdate()
            //在此 PreparedStatement 对象中执行 SQL 语句，该语句必须是一个 SQL 数据操作语言）语句，比如 INSERT、UPDATE 或 DELETE 语句；
            // 或者是无返回内容的 SQL 语句，比如 DDL 语句。
            //返回：
            //(1) SQL 数据操作语言 (DML) 语句的行数 (2) 对于无返回内容的 SQL 语句，返回 0

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        }
        return row;
    }


    public User judge(String name) {
        Connection conn = DBUtil.getConn();//获取数据库连接对象
        User user = null;
        String sql = "select * from tb_user where name=? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, name);

            ResultSet r = ps.executeQuery();

            if (r.next()) {
                int id = r.getInt("id");
                String username = r.getString("name");
                String pwd = r.getString("password");
                String tel = r.getString("tel");
                //将得到的方法

                user = new User();
                user.setId(id);
                user.setName(username);
                user.setPassword(pwd);
                user.setTel(tel);


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return user;
    }


}
