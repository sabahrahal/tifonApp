package dao;

import Domain.Order;
import static dao.Connect.getConnection;
import java.sql.*;
import java.util.*;

public class OrderDAOImpOrderDAOImp implements OrderInterface {

    private static final String SQL_SELECT = "SELECT * FROM orders";
    private static final String SQL_INSERT = "INSERT INTO orders(quantity, total, pay, client) VALUES(?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM orders WHERE id_order = ?";
    private static final String SQL_UPDATE = "UPDATE orders SET quantity = ?, total = ?, pay = ? , client = ? WHERE id_order = ?";

    @Override
    public List<Order> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Order order = null;
        List<Order> orders = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_order");
                int quantity = rs.getInt("quantity");
                double total = rs.getDouble("total");
                boolean pay = rs.getBoolean("pay");
                String client = rs.getString("client");
                order = new Order(id, quantity, total, pay, client);
                orders.add(order);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Connect.close(rs);
                Connect.close(stmt);
                Connect.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return orders;
    }

    @Override
    public int insert(Order order) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int register = 0;

        try {
            conn = Connect.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, order.getQuantity());
            stmt.setDouble(2, order.getTotal());
            stmt.setBoolean(3, order.isPay());
            stmt.setString(4, order.getClient());
            register = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Connect.close(stmt);
                Connect.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return register;
    }

    @Override
    public int update(Order order) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int register = 0;

        try {
            conn = Connect.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, order.getQuantity());
            stmt.setDouble(2, order.getTotal());
            stmt.setBoolean(3, order.isPay());
            stmt.setString(4, order.getClient());
            stmt.setInt(5, order.getId());
            register = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Connect.close(stmt);
                Connect.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return register;
    }

    @Override
    public int delete(Order order) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int register = 0;

        try {
            conn = Connect.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, order.getId());
            register = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally{
            try {
                Connect.close(stmt);
                Connect.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return register;
    }
}
