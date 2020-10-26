package dao.impl;

import dao.SecUserDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pojo.SecUser;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SecUserDaoImpl implements SecUserDao{
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<SecUser> findAll() {
        String sql = "select * from secuser";
        List<SecUser> users = template.query(sql, new BeanPropertyRowMapper<SecUser>(SecUser.class));
        return users;
    }

    @Override
    public void add(SecUser secuser) {
        String sql = "insert into secuser values(null,?,?,?,?,?)";
        template.update(sql,secuser.getName(), secuser.getUsername(),secuser.getPassword(),secuser.getAddress(), secuser.getUcode());
    }

    @Override
    public void del(int id) {
        String sql = "delete from secuser where id=?";
        template.update(sql,id);
    }

    @Override
    public SecUser findById(int id) {
        String sql = "select * from secuser where id = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<SecUser>(SecUser.class),id);
    }

    @Override
    public void update(SecUser secuser) {
        String sql = "update secuser set name=?,address=?,ucode=? where id=?";
        template.update(sql,secuser.getName(),secuser.getAddress(),secuser.getUcode(),secuser.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql = "select count(*) from secuser where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);

        Set<String> keys = condition.keySet();
        List<Object> param = new ArrayList<Object>();
        for (String key : keys) {
            if ("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
            if (value!=null && !"".equals(value)){
                sb.append(" and "+key+" like ? ");
                param.add("%"+value+"%");
            }
        }

        return template.queryForObject(sb.toString(), Integer.class,param.toArray());
    }

    @Override
    public List<SecUser> findSecByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from secuser where 1=1 ";

        StringBuilder sb = new StringBuilder(sql);

        Set<String> keys = condition.keySet();
        List<Object> param = new ArrayList<Object>();
        for (String key : keys) {
            if ("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
            if (value!=null && !"".equals(value)){
                sb.append(" and "+key+" like ? ");
                param.add("%"+value+"%");
            }
        }
        sb.append(" limit ?,? ");
        if(start<0){
            start = 0;
        }
        param.add(start);
        param.add(rows);

        List<SecUser> secusers = template.query(sb.toString(), new BeanPropertyRowMapper<SecUser>(SecUser.class),param.toArray());
        return secusers;
    }
}
