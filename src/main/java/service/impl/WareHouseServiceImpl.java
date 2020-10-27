package service.impl;

import dao.WareHouseDao;
import dao.impl.WareHouseDaoImpl;
import pojo.*;
import service.WareHouseService;

import java.util.List;
import java.util.Map;

public class WareHouseServiceImpl implements WareHouseService {
    WareHouseDao dao=new WareHouseDaoImpl();

    @Override
    public List<WpWh> findWareHouse(int id) {

      return dao.findWareHouse(id);

    }

    @Override
    public void addWareHouse(WareHouse wareHouse) {
        dao.addWareHouse(wareHouse);
    }

    @Override
    public void delWareHouse(Integer integer) {
        dao.delWareHouse(integer);
    }

    @Override
    public void updateWareHouse(WareHouse wareHouse) {
        dao.updateWareHouse(wareHouse);
    }

    @Override
    public PageBean<WareHouse> findWareHouseByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage= Integer.parseInt(_currentPage);
        int rows= Integer.parseInt(_rows);
        if (currentPage <=0) {
            currentPage=1;
        }
        PageBean<WareHouse> pb=new PageBean<WareHouse>();

        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        //查询总记录数
        int totalCount=dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);

        //计算开始记录的索引
        int start=(currentPage-1)*rows;
        List<WareHouse> list=dao.findByPage(start,rows,condition);
        pb.setList(list);
        int totalPage=(totalCount%rows)==0  ?totalCount/rows :(totalCount/rows)+1;
        pb.setTotalPage(totalPage);

        return pb;
    }

    @Override
    public WareHouse findWareHouseById(Integer integer) {
        return dao.findWareHouseById(integer);
    }

    @Override
    public void delSelectWarehouse(String[] ids) {
        for (String id:
             ids) {
            dao.delWareHouse(Integer.valueOf(id));
        }
    }


}
