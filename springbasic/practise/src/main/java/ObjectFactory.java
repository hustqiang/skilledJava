import com.mine.entity.UserEntity;

/**
 * @ClassName ObjectFactory
 * @Description 工厂模式
 * @Author zhangqiang
 * @Date 2020-02-19 21:00
 * @ModifyDate 2020-02-19 21:00
 * @Version 1.0
 */
public class ObjectFactory {

    public UserEntity getUserEntity(String name,int age){
        UserEntity userEntity = new UserEntity(name, age);
        return userEntity;
    }
}
