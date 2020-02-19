import com.mine.entity.UserEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName SpringTest
 * @Description TODO
 * @Author zhangqiang
 * @Date 2020-02-18 22:30
 * @ModifyDate 2020-02-18 22:30
 * @Version 1.0
 */
public class SpringTest {
    public static void main(String[] args){

        //加载spring容器
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-001.xml");
        UserEntity userEntity1 = (UserEntity) classPathXmlApplicationContext.getBean("userEntity1");
        if(userEntity1!=null){

            System.out.println("test");
        }
    }
}
