package sg.nus.edu.mystore.test;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sg.nus.edu.mystore.entity.Address;
import sg.nus.edu.mystore.entity.Order;
import sg.nus.edu.mystore.entity.User;
import sg.nus.edu.mystore.repository.OrderRepository;

@SpringBootTest
public class OrderTest {
    @Autowired
    private OrderRepository repo;

    @Test
    public void createOrderTest(){
    // 假设你有这个服务层方法设你已经有2个用户对象
    User user1 = new User(
            "john_doe",              // username
    "password123",           // password
    "saltValue1",            // salt
    "123-456-7890",          // phone
    "john.doe@example.com",  // email
    1,                       // gender (假设1表示男性)
    "avatar1.jpg",           // avatar
    0                        // isDelete (0表示未删除)
    );

// 生成第二个用户
        User user2 = new User(
                "jane_doe",              // username
                "password456",           // password
                "saltValue2",            // salt
                "098-765-4321",          // phone
                "jane.doe@example.com",  // email
                2,                       // gender (假设2表示女性)
                "avatar2.jpg",           // avatar
                0                        // isDelete (0表示未删除)
        );

    // 使用构造函数创建四个 Address 对象
    Address address1 = new Address(user1, "123 Main St", "Apt 101", "Unit A", "Floor 1", "CityA", "StateA", "10001", "Near the park");
    Address address2 = new Address(user1, "456 Oak St", "Suite 200", "Unit B", "Floor 2", "CityB", "StateB", "20002", "Business district");
    Address address3 = new Address(user1, "789 Pine St", "", "Unit C", "Floor 3", "CityC", "StateC", "30003", "Residential area");
    Address address4 = new Address(user2, "101 Maple St", "Penthouse", "Unit D", "Floor 10", "CityD", "StateD", "40004", "Luxury area");
    }

    Order order1 = new Order()
    repo.save(order1);
    repo.save(order2);
    repo.save(order3);
    repo.save(order4);


}
