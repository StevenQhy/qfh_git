package dao.impl;

import dao.WeaponDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pojo.Weapon;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WeaponDaoImpl implements WeaponDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    private Weapon Weapon;
    //添加武器
    @Override
    public void addWeapon(Weapon weapon) {
        String sql="insert into weapon values(null,?,?,?,?)";
        template.update(sql,weapon.getName(),weapon.getU_id(),weapon.getWh_id(),weapon.getRange());
    }
    //删除武器
    @Override
    public void delWeapon(int id) {
        String  sql="delete from weapon where id=?";
        System.out.println("删除成功！");
        template.update(sql,id);
    }
    //修改武器信息
    @Override
    public void updateWeapon(Weapon weapon) {
        String sql="update weapon set name=?, u_id=?, wh_id =?, `range`=?  where  id=?";
        template.update(sql,weapon.getName(),weapon.getU_id(),weapon.getWh_id(),weapon.getRange(),weapon.getId());
    }

    @Override
    public List<Weapon> findAll() {
        String sql="select * from weapon";
        List<Weapon> weapons=template.query(sql,new BeanPropertyRowMapper<Weapon>(Weapon.class));

        return weapons;
    }
   //查询总页数
    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql="select count(*) from weapon where 1 = 1 ";
        StringBuilder sb=new StringBuilder(sql);
        //遍历map

        Set<String> keySet=condition.keySet();

        List<Object> params=new ArrayList<>();

        for (String key :keySet
             ) {

            if ("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            //获取value
            String value=condition.get(key)[0];

            if (value != null&&!"".equals(value)) {
                sb.append(" and "+key+" like  ?");
                params.add("%"+value+"%");

            }
        }


        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    //分页查询
    @Override
    public List<pojo.Weapon> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql="select * from weapon where 1 = 1 ";
        StringBuilder sb=new StringBuilder(sql);
        //遍历map

        Set<String> keySet=condition.keySet();

        List<Object> params=new ArrayList<>();

        for (String key :keySet
        ) {

            if ("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            //获取value
            String value=condition.get(key)[0];

            if (value != null&&!"".equals(value)) {
                sb.append(" and "+key+" like  ?");
                params.add("%"+value+"%");

            }
        }
        sb.append("limit ?,? ");
        params.add(start);
        params.add(rows);

        List<Weapon> weapons=template.query(sb.toString(),new BeanPropertyRowMapper<Weapon>(Weapon.class),params.toArray());
        return  weapons;
    }
    //通过id查询
    @Override
    public Weapon findWeaponById(int id) {
        String sql="select * from weapon where id=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Weapon>(Weapon.class),id) ;
    }
}
