package springbook.user.v1.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import springbook.user.v1.dao.AccountDao;
import springbook.user.connection.ConnectionMaker;
import springbook.user.connection.DConnectionMaker;
import springbook.user.v1.dao.UserDao;

import javax.sql.DataSource;


@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao() {
        UserDao userDao = new UserDao();
        userDao.setConnectionMaker(connectionMaker());
        return userDao;
    }
    @Bean
    public AccountDao accountDao(){
        return new AccountDao(connectionMaker());
    }
    @Bean
    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
