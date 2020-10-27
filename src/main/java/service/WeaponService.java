package service;

import pojo.PageBean;
import pojo.Weapon;

import java.util.List;
import java.util.Map;

public interface WeaponService {

    void addWeapon(Weapon weapon);
    //删除武器
    void delWeapon(int id);

    void updateWeapon(Weapon weapon);

    List<Weapon> findAll();

    PageBean<Weapon> findWeaponByPage(String currentPage, String rows, Map<String, String[]> condition);
    //根据id查询
    Weapon findWeaponById(String id);

    void delSelectWeapon(String[] ids);
}
