package sg.nus.edu.mystore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sg.nus.edu.mystore.entity.Order;
import sg.nus.edu.mystore.entity.Order_Product;
import sg.nus.edu.mystore.entity.User;
import sg.nus.edu.mystore.service.OrderImplementation;
import sg.nus.edu.mystore.repository.OrderRepository;
import org.springframework.ui.Model;


import java.util.List;

@Controller

@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderImplementation orderService;


        @GetMapping("/order")
        public String showOrderPage() {
            return "order"; // 返回 order.html 视图
        }

        @PostMapping("/api/orders/getOrderById")
        public String getOrderById(@RequestParam("orderId") int orderId, Model model) {
            // 处理订单逻辑，根据 orderId 查找订单
            Order order = orderService.findOrderById(orderId); // 假设你有这个服务层方法
            model.addAttribute("order", order);
            return "order"; // 返回视图并显示订单信息
        }



    @PostMapping("/placeOrder")
    public ResponseEntity<String> placeOrder(@RequestBody List<Order_Product> productList) {
        orderService.placeOrder(productList);
        return ResponseEntity.ok("Order has been placed.");
    }

    @DeleteMapping("/cancelOrder/{orderId}")
    public ResponseEntity<String> cancelOrder(@PathVariable int orderId) {
        orderService.cancelOrder(orderId);
        return ResponseEntity.ok("Order cancellation processed.");
    }

    @PutMapping("/updateOrderStatus/{orderId}")
    public ResponseEntity<String> updateOrderStatus(@PathVariable int orderId, @RequestParam String status) {
        orderService.updateOrderStatus(orderId, status);
        return ResponseEntity.ok("Order status has been updated.");
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<Order>> getOrdersByUsers(@PathVariable User user) {
        List<Order> orders = orderService.getOrdersByUsers(user);
        return ResponseEntity.ok(orders);
    }



}
