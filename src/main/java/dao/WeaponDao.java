package dao;

import pojo.Weapon;

import java.util.List;
import java.util.Map;

public interface WeaponDao {
    void addWeapon(Weapon weapon);

    void delWeapon(int id);

    void updateWeapon(Weapon weapon);

    List<Weapon> findAll();

    int findTotalCount(Map<String, String[]> condition);

    List<Weapon> findByPage(int start, int rows, Map<String, String[]> condition);

    Weapon findWeaponById(int id);
}
