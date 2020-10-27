package dao;

import pojo.WareHouse;
import pojo.WpWh;

import java.util.List;
import java.util.Map;

public interface WareHouseDao {


    List<WpWh> findWareHouse(int id);

    void addWareHouse(WareHouse wareHouse);


    void delWareHouse(Integer integer);

    void updateWareHouse(WareHouse wareHouse);

    List<WareHouse> findByPage(int start, int rows, Map<String, String[]> condition);

    int findTotalCount(Map<String, String[]> condition);

    WareHouse findWareHouseById(Integer integer);
}
