package service.impl;

import dao.SecUserDao;
import dao.impl.SecUserDaoImpl;
import pojo.PageBean;
import pojo.SecUser;
import service.SecUserService;

import java.util.List;
import java.util.Map;

public class SecUserServiceImpl implements SecUserService {
    SecUserDao dao = new SecUserDaoImpl();
    @Override
    public List<SecUser> FindAll() {

        return dao.findAll();
    }

    @Override
    public void addSecUser(SecUser secuser) {
        dao.add(secuser);
    }

    @Override
    public void delsec(String id) {

        dao.del(Integer.parseInt(id));
    }

    @Override
    public SecUser findSecUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateSecUser(SecUser secuser) {
        dao.update(secuser);
    }

    @Override
    public void delSelSecUser(String[] ids) {
        if (ids != null&& ids.length>0) {
            for (String id : ids) {
                dao.del(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<SecUser> findSecUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        int totalCount = dao.findTotalCount(condition);
        int totalPage = (totalCount%rows) == 0 ? totalCount/rows : (totalCount/rows)+1;
        if (currentPage<=0){
            currentPage=1;
        }
        if (currentPage>totalPage){
            currentPage=totalPage;
        }
        PageBean<SecUser> pb1 = new PageBean<SecUser>();
        pb1.setCurrentPage(currentPage);
        pb1.setRows(rows);


        pb1.setTotalCount(totalCount);

        int start = (currentPage-1)*rows;
        List<SecUser> list = dao.findSecByPage(start,rows,condition);
        pb1.setList(list);

        pb1.setTotalPage(totalPage);
        return pb1;
    }
}
