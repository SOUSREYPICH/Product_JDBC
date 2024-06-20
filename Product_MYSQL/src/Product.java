import java.sql.*;

public class Product {
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/product";
    private static final String JDBC_USER="root";
    private static final String JDBC_PASSWORD="Pich1111";
    public static void main(String [] args){
        try{
            Connection connection= DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
            String sql="SELECT*FROM product";
            PreparedStatement statement=Connection.prepareStatement(sql);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                double pricePerUnit= resultSet.getDouble("price_per_unit");
                int activeForSell=resultSet.getInt("active_for_sell");
                System.out.printf("id: %d,name:%s,price_per_unit: %.2f,active_for_sell:%b%n",id,name,pricePerUnit,activeForSell);

            }
            resultSet.close();;
            statement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
