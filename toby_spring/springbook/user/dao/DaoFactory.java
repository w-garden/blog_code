package springbook.user.dao;

public class DaoFactory {
    public UserDao userDao() {
        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDao userDoa = new UserDao(connectionMaker);
        return userDoa;
    }
}
