package service.impl;

import dao.WeaponDao;
import dao.impl.WeaponDaoImpl;
import pojo.PageBean;
import pojo.WareHouse;
import pojo.Weapon;
import service.WeaponService;

import java.util.List;
import java.util.Map;

public class WeaponServiceImpl implements WeaponService {
    WeaponDao dao=new WeaponDaoImpl();

    @Override
    public void addWeapon(Weapon weapon) {
        dao.addWeapon(weapon);
    }

    @Override
    public void delWeapon(int id) {
        dao.delWeapon(id);
    }

    @Override
    public void updateWeapon(Weapon weapon) {
        dao.updateWeapon(weapon);
    }

    @Override
    public List<Weapon> findAll() {
        return dao.findAll();
    }

    @Override
    public PageBean<Weapon> findWeaponByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage= Integer.parseInt(_currentPage);
        int rows= Integer.parseInt(_rows);
        if (currentPage <=0) {
            currentPage=1;
        }
        PageBean<Weapon> pb=new PageBean<Weapon>();

        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        //查询总记录数
        int totalCount=dao.findTotalCount(condition);
         pb.setTotalCount(totalCount);

         //计算开始记录的索引
         int start=(currentPage-1)*rows;
         List<Weapon> list=dao.findByPage(start,rows,condition);
         pb.setList(list);
         int totalPage=(totalCount%rows)==0  ?totalCount/rows :(totalCount/rows)+1;
         pb.setTotalPage(totalPage);

        return pb;
    }

    @Override
    public Weapon findWeaponById(String id) {
        return dao.findWeaponById(Integer.parseInt(id));
    }
    //删除选中
    @Override
    public void delSelectWeapon(String[] ids) {
        for (String id : ids) {
            dao.delWeapon(Integer.parseInt(id));
        }
    }
}
