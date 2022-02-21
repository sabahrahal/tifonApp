package dao;

import Domain.Order;
import java.util.List;

public interface OrderInterface {
    public List<Order> select();
    
    public int insert(Order order);
    
    public int update(Order order);
    
    public int delete(Order order);
}
