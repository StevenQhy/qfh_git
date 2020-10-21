package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.PageBean;
import pojo.User;
import service.UserService;
import util.MailUtils;
import util.UuidUtil;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        //调用dao完成查询
        List<User> users = dao.finAll();
        return users;
    }

    @Override
    public User login(User loginser) {
        return dao.login(loginser);
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void del(String id) {
        dao.del(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public void delSelectedUser(String[] ids) {

        if(ids != null && ids.length>0){
            //1.遍历数组
            for (String id : ids) {
                //调用dao删除
                dao.del(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if (currentPage<=0){
            currentPage = 1;
        }

        //创建一个pagebean对象
        PageBean<User> pb = new PageBean<>();

        //设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //调用dao查询记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);

        //调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<User> list = dao.findByPage(start,rows,condition);
        pb.setList(list);
        //计算总的页码
        int totalPage = (totalCount%rows == 0) ? (totalCount/rows) : (totalCount/rows)+1;
        pb.setTotalPage(totalPage);

        return pb;
    }

    @Override
    public boolean regist(User user) {
        User u = dao.findByUsername(user.getUsername());

        if(u!=null){
            return false;
        }

        //保存用户信息
        //2.设置激活码
        //2.1设置激活码，唯一字符串
        user.setCode(UuidUtil.getUuid());
        //2.2设置激活状态
        user.setStatus("N");
        dao.save(user);
        //3.激活邮件发送，邮件正文
        //String content = "<a href='//localhost:8082/activeUserServlet?code="+user.getCode()+"'>【激活请点击这里】</a>";
        String content = "请您在浏览器输入；localhost:8082/activeUserServlet?code="+user.getCode()+"来激活您的邮箱";
        MailUtils.sendMail(user.getEmail(),content,"激活邮件");
        return true;
    }

    @Override
    public boolean active(String code) {
        User user = dao.findByCode(code);
        if (user!=null){
            dao.updateStatus(user);
            return true;
        }else{
            return false;
        }
    }
}
