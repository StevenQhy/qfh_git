package dao.impl;

import dao.WareHouseDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import pojo.WareHouse;
import pojo.WpWh;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class WareHouseDaoImpl implements WareHouseDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public List<WpWh> findWareHouse(int id) {
        return null;
    }

    //添加仓库
    @Override
    public void addWareHouse(WareHouse wareHouse) {
        String sql="insert into warehouse(address,name)  values(?,?)";
        template.update(sql,wareHouse.getAddress(),wareHouse.getName());
    }
    //删除仓库
    @Override
    public void delWareHouse(Integer integer) {
        String sql="delete from warehouse where ware_id=?";
        template.update(sql,integer);
    }
    //修改仓库信息
    @Override
    public void updateWareHouse(WareHouse wareHouse) {
        String sql="update warehouse set address=?,name=? where ware_id=?";
        template.update(sql,wareHouse.getAddress(),wareHouse.getName(),wareHouse.getWare_id());
    }
    //分页查询
    @Override
    public List<WareHouse> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql="select * from warehouse where 1 = 1 ";
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

        List<WareHouse> wareHouses=template.query(sb.toString(),new BeanPropertyRowMapper<WareHouse>(WareHouse.class),params.toArray());
        return  wareHouses;
    }


    //总页数查询
    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql = "select count(*) from warehouse where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //遍历map

        Set<String> keySet = condition.keySet();

        List<Object> params = new ArrayList<>();

        for (String key : keySet
        ) {

            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            //获取value
            String value = condition.get(key)[0];

            if (value != null && !"".equals(value)) {
                sb.append(" and " + key + " like  ?");
                params.add("%" + value + "%");

            }
        }
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }



    //根据id查询
    @Override
    public WareHouse findWareHouseById(Integer integer) {
        String sql="select * from warehouse where ware_id=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<WareHouse>(WareHouse.class),integer);


    }

}

