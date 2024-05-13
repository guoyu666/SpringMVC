package usermgt.dao;

import org.springframework.stereotype.Repository;
import usermgt.bean.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    private static List<User> users = new ArrayList<>();

    static {
        // 类加载是初始化数据
        // 创建User对象
        User user1 = new User(10001L, "张三", "zhangsan@powernode.com", 1);
        User user2 = new User(10002L, "李四", "lisi@powernode.com", 1);
        User user3 = new User(10003L, "王五", "wangwu@powernode.com", 1);
        User user4 = new User(10004L, "赵六", "zhaoliu@powernode.com", 0);
        User user5 = new User(10005L, "钱七", "qianqi@powernode.com", 0);
        // 将User对象存储到List集合中
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
    }

    /**
     * 查询所有用户信息
     * @return 用户列表List集合
     */
    public List<User> selectAll(){
        return users;
    }

    public Long generateId(){
        // 使用Stream API
        Long maxId = users.stream().map(user -> user.getId()).reduce((id1, id2) -> id1 > id2 ? id1 : id2).get();
        return maxId + 1;
    }

    /**
     * 保存用户信息
     * @param user
     */
    public void insert(User user){
        // 生成id
        Long id = generateId();
        // 给user对象id属性赋值
        user.setId(id);
        // 保存
        users.add(user);

    }

    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    public User selectById(Long id) {
        // Stream API
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    /**
     * 修改用户信息
     * @param user
     */
    public void update(User user) {
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getId().equals(user.getId())){
                users.set(i, user);
            }
        }
    }

    /**
     * 根据ID删除用户
     * @param id
     */
    public void deleteById(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}
