import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException{
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;


        try {
           // connection =
            //        DriverManager.getConnection(
             //
            //               DBUtils.MYSQL_DB,DBUtils.MYSQL_USER,DBUtils.MYSQL_PASSWORD);
            //System.out.println("conect!!");

            connection = DBUtils.getConnection(DBType.MYSQLDB);

            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery("SELECT * FROM usersr");

            /*
            String sql = "insert into users values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"1010");
            preparedStatement.setString(2,"Maria");
            preparedStatement.setString(3,"maria@maria.com");
            preparedStatement.setString(4,"argentina");

            int result =  preparedStatement.executeUpdate();

            if(result == 1){
                System.out.println("Record inserted");
            }else{
                System.out.println("Error");
            }*/


            while (resultSet.next()){
                System.out.println(resultSet.getString("id") +
                        resultSet.getString("nombre") +
                        resultSet.getString("correo") +
                        resultSet.getString("nacionalidad"));
            }

            /*String sql = "update users set correo = ?  where id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"x@x.com");
            preparedStatement.setString(2,"1010");
            int result = preparedStatement.executeUpdate();
            if(result == 1){
                System.out.println("Record update");
            }else{
                System.out.println("Error");
            }*/

            String sql = "delete from users where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"1010");
            int result = preparedStatement.executeUpdate();
            if(result == 1){
                System.out.println("Record deleted");
            }else{
                System.out.println("Error");
            }


        } catch (SQLException e) {
            DBUtils.processException(e);
        }finally {
            if (statement!= null){
                statement.close();
            }
            if (resultSet!=null){
                resultSet.close();
            }

            if(connection != null){
                connection.close();
            }
        }
    }
}
