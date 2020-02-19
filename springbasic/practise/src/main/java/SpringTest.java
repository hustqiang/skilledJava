import com.mine.entity.UserEntity;
import com.mine.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName SpringTest
 * @Description TODO
 * @Author zhangqiang
 * @Date 2020-02-18 22:39
 * @ModifyDate 2020-02-18 22:39
 * @Version 1.0
 */
public class SpringTest {
    public static void main(String[] args){
//加载spring容器
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-004.xml");
        //UserEntity userEntity1 = (UserEntity) classPathXmlApplicationContext.getBean("userEntity1");
        //UserEntity userEntity2 = (UserEntity) classPathXmlApplicationContext.getBean("userEntity1");
        //UserEntity userEntity3 = (UserEntity) classPathXmlApplicationContext.getBean("userEntity2");
        //UserEntity userEntity4 = (UserEntity) classPathXmlApplicationContext.getBean("getUserEntity");


        UserService userService = (UserService) classPathXmlApplicationContext.getBean("userService");
        //UserService userService1 = (UserService) classPathXmlApplicationContext.getBean("userService1");
        System.out.println(userService.isFlag());
        userService.add();
        //System.out.println(userEntity3.getName());
        //System.out.println(userEntity3.getAge());
        //System.out.println(userEntity4.getName());
        //System.out.println(userEntity4.getAge());

        //userService1.add();


        //UserService userService11 = (UserService) classPathXmlApplicationContext.getBean("userService1");
        //userService11.add();
    }
}
