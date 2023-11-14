package springbook.user.v0;

import springbook.user.domain.User;
import springbook.user.v0.dao.DUserDao;

import java.sql.SQLException;

public class V0UserDaoMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        DUserDao dao = new DUserDao();

        User user = new User();

        user.setId("shc729");
        user.setName("신호철");
        user.setPassword("1234");
        int deleteRows=dao.delete();
        System.out.println(deleteRows+" 개 데이터 삭제성공!!!");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println("user2.getName() : " + user2.getName());
        System.out.println("user2.getPassword) : " + user2.getPassword());

        System.out.println(user2.getId() + " 조회성공");






    }
}
