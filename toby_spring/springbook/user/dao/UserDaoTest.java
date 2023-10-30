package springbook.user.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook.user.dao.DaoFactory;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

import java.sql.SQLException;


public class UserDaoTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ApplicationContext context =  new AnnotationConfigApplicationContext(DaoFactory.class);

        UserDao dao = context.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("shc7149");
        user.setName("신호철");
        user.setPassword("1234");


        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println("user2.getName() : " + user2.getName());
        System.out.println("user2.getPassword) : " + user2.getPassword());

        System.out.println(user2.getId() + " 조회성공");

        if(dao.delete(user2.getId())==1){
            System.out.println("삭제성공!!!");
        }
    }


}
