package daofc;

import pojofc.User;
import utilfc.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDao {
    //写一个添加用户数据的方法 对于添加删除修改,方法返回值可以是受影响的行数 int
    public int addUserInfo(String username, String pwd,String name,String address,String ucode) {
        //获取数据库连接对象
        Connection conn = DBUtil.getConn();
        PreparedStatement ps = null;//创建一个 PreparedStatement 对象来将参数化的 SQL 语句发送到数据库

        int row = 0;
        String sql = "insert into secuser(id,username,password,name,address,ucode) values(null,?,?,?,?,?)";


        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, pwd);
            ps.setString(3, name);
            ps.setString(4,address);
            ps.setString(5,ucode);


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


    public User judge(String username) {
        Connection conn = DBUtil.getConn();//获取数据库连接对象
        User user = null;
        String sql = "select * from secuser where username=? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);

            ResultSet r = ps.executeQuery();

            if (r.next()) {
                int id = r.getInt("id");
                String name = r.getString("username");
                String pwd = r.getString("password");
                String ucode = r.getString("ucode");
                //将得到的方法

                user = new User();
                user.setId(id);
                user.setUsername(name);
                user.setPassword(pwd);
                user.setUcode(ucode);


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

    //通过用户名查找用户信息
    public User finduserbyusername(String username){
        Connection conn = DBUtil.getConn();
        User user = null;
        String sql = "select * from secuser where username=? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);

            ResultSet r = ps.executeQuery();

            if (r.next()) {
                String name = r.getString("name");
                String pwd = r.getString("password");
                String address=r.getString("address");
                String ucode = r.getString("ucode");
                //将得到的方法

                user = new User();
                user.setName(name);
                user.setPassword(pwd);
                user.setAddress(address);
                user.setUcode(ucode);


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

    //修改用户信息
    public int modifyuser(String username, String name ,String password,String address,String ucode) {
        Connection conn = DBUtil.getConn();
        int row = 0;
        String sql = "update secuser set name=?, password=?, address=?, ucode=? where username=? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3, address);
            ps.setString(4, ucode);
            ps.setString(5, username);
            row = ps.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

return row;
    }



}
