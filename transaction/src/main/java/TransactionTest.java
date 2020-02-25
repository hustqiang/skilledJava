import com.mine.dao.UserDao;
import com.mine.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("beans.xml");
        UserDao userDao = (UserDao) application.getBean("userDao");
//        userDao.addUser("zhangqiang",12);

        UserService userService = (UserService) application.getBean("userService");
//        userService.add();
//        userService.addUser();
//        userService.huoquUser();
        userService.addUserTransactionTest();
    }
}
