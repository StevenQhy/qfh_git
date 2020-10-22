package daofc;

import pojofc.Weapon;
import utilfc.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WeaponDao {
    //查询weapon表中的所有数据
    public List<Weapon> findAllWeaponInfo(int currentPage,int pageSize) {
        List<Weapon> list = new ArrayList<>();

        Connection connection = DBUtil.getConn();

        int offset=(currentPage-1)*pageSize;
        String sql = "select *from tb_weapon limit "+offset+" , "+pageSize;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            //因为没有参数,不用给?赋值,省略
            ResultSet r = ps.executeQuery();
            //遍历结果集,将数据封装到Weapon对象,将对象添加到集合中
            while (r.next()) {
                int weaponid = r.getInt("weaponid");
                String weaponname = r.getString("weaponname");
                String launchplace = r.getString("launchplace");
                int range = r.getInt("range");
                int amount = r.getInt("amount");

                Weapon weapon = new Weapon();
                weapon.setWeaponid(weaponid);
                weapon.setWeaponname(weaponname);
                weapon.setLaunchplace(launchplace);
                weapon.setRange(range);
                weapon.setAmount(amount);
                list.add(weapon);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return list;
    }

    //根据id删除数据
    public int deleteWeaponById(String weaponid){
        int row=0;
        Connection conn = DBUtil.getConn();

        String sql="delete from tb_weapon where weaponid=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(weaponid));
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
    //根据id查找当前用户
    public Weapon findWeaponByWeaponId(String weaponid){
        Connection conn = DBUtil.getConn();
       Weapon weapon=null;
        String sql ="select *from tb_weapon where weaponid=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(weaponid));
            ResultSet r = ps.executeQuery();
            while(r.next()){
                int id= r.getInt("weaponid");
                String weaponname = r.getString("weaponname");
                String launchplace = r.getString("launchplace");
                int range = r.getInt("range");
                int amount = r.getInt("amount");

               weapon = new Weapon();
                weapon.setWeaponid(id);
                weapon.setWeaponname(weaponname);
                weapon.setLaunchplace(launchplace);
                weapon.setRange(range);
                weapon.setAmount(amount);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

return weapon;
    }
//修改信息
    public int UpdateWeaponInfo(String weaponid,String weaponname, String launchplace,String range,String amount){
        Connection conn = DBUtil.getConn();
        int row=0;
        String sql="update tb_weapon set  weaponname=?,launchplace=?, `range`=?, `amount`=? where weaponid=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,weaponname);
            ps.setString(2,launchplace);
            ps.setInt(3,Integer.parseInt(range));
            ps.setInt(4,Integer.parseInt(amount));
            ps.setInt(5,Integer.parseInt(weaponid));
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
//添加新武器
    public int AddNewWeapon(String weaponname,String launchplace,String range,String amount){
        Connection conn = DBUtil.getConn();
        int row=0;
        String sql="insert into tb_weapon(weaponid,weaponname,launchplace,`range`,`amount`) values(null,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,weaponname);
            ps.setString(2,launchplace);
            ps.setInt(3,Integer.parseInt(range));
            ps.setInt(4,Integer.parseInt(amount));
            row = ps.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return row;
    }

    //模糊查询
    public List<Weapon> selectWeaponForLike(String weaponname){
        Connection conn = DBUtil.getConn();
        List<Weapon> list=new ArrayList<>();
        String sql="select * from tb_weapon where weaponname like'%"+weaponname+"%'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1,weaponname);
            ResultSet r = ps.executeQuery();
            //遍历结果集
            while(r.next()){
                Integer id=r.getInt("weaponid");
                String name = r.getString("weaponname");
                int range = r.getInt("range");
                int amount = r.getInt("amount");
                String launchplace = r.getString("launchplace");

                Weapon weapon=new Weapon();
                weapon.setWeaponname(name);
                weapon.setLaunchplace(launchplace);
                weapon.setWeaponid(id);
                weapon.setAmount(amount);
                weapon.setRange(range);
                list.add(weapon);


            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return list;

    }

    //获取数库表条数
    public  int getDataTotal(){
        Connection conn = DBUtil.getConn();
        int row=0;
        String sql="select * from tb_weapon";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                row++;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            return row;
        }
    }

}
