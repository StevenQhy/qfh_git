package service;

import pojo.PageBean;
import pojo.WareHouse;
import pojo.WpWh;

import java.util.List;
import java.util.Map;

public interface WareHouseService {


    List<WpWh> findWareHouse(int id);

    void addWareHouse(WareHouse wareHouse);


    void delWareHouse(Integer integer);

    void updateWareHouse(WareHouse wareHouse);

    PageBean<WareHouse> findWareHouseByPage(String currentPage, String rows, Map<String, String[]> condition);

    WareHouse findWareHouseById(Integer integer);

    void delSelectWarehouse(String[] ids);
}
