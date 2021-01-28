package model.dao;

import model.bean.User;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDAO {
    private final BaseRepository baseRepository = new BaseRepository();
    private final String SQL_INSERT_USER = "INSERT INTO users(`name`, email, country) " +
            "VALUES(?,?,?)";
    private final String SQL_SELECT_USER = "SELECT * " +
            "FROM users " +
            "WHERE id = ?";
    private final String SQL_SELECT_ALL_USER = "SELECT * FROM users";
    private final String SQL_DELETE_USER = "DELETE FROM users WHERE id = ?";
    private final String SQL_UPDATE_USER = "UPDATE users " +
            "SET `name` = ?, email = ?, country = ? " +
            "WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";

    private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";

    private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE"
            + "("

            + " ID serial,"

            + " NAME varchar(100) NOT NULL,"

            + " SALARY numeric(15, 2) NOT NULL,"

            + " CREATED_DATE timestamp,"

            + " PRIMARY KEY (ID)"

            + ")";

    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";


    @Override
    public void insertUser(User user) throws SQLException {
        var prepareStatement = baseRepository.getConnection().prepareStatement(SQL_INSERT_USER);
        prepareStatement.setString(1, user.getName());
        prepareStatement.setString(2, user.getEmail());
        prepareStatement.setString(3, user.getCountry());

        prepareStatement.executeUpdate();

    }

    @Override
    public User selectUser(int id) throws SQLException {
        var prepareStatement = baseRepository.getConnection().prepareStatement(SQL_SELECT_USER);

        prepareStatement.setInt(1, id);

        var resultSet = prepareStatement.executeQuery();
        if (resultSet.next())
            return new User(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("country"));

        return null;
    }

    @Override
    public List<User> selectAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        var prepareStatement = baseRepository.getConnection().prepareStatement(SQL_SELECT_ALL_USER);

        var resultSet = prepareStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String country = resultSet.getString("country");

            userList.add(new User(id, name, email, country));
        }

        return userList;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        var prepareStatement = baseRepository.getConnection().prepareStatement(SQL_DELETE_USER);

        prepareStatement.setInt(1, id);
        var result = prepareStatement.executeUpdate();

        if (result > 0)
            return true;
        return false;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        var prepareStatement = baseRepository.getConnection().prepareStatement(SQL_UPDATE_USER);
        prepareStatement.setString(1, user.getName());
        prepareStatement.setString(2, user.getEmail());
        prepareStatement.setString(3, user.getCountry());
        prepareStatement.setInt(4, user.getId());

        var result = prepareStatement.executeUpdate();
        if (result > 0)
            return true;

        return false;
    }

    @Override
    public User getUserById(int id) throws SQLException {
        User user = null;
        String query = "{CALL get_user_by_id(?)}";

        var callableStatement = baseRepository.getConnection().prepareCall(query);

        callableStatement.setInt(1, id);

        ResultSet rs = callableStatement.executeQuery();

        while (rs.next()) {

            String name = rs.getString("name");

            String email = rs.getString("email");

            String country = rs.getString("country");

            user = new User(id, name, email, country);

        }
        return user;
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        String query = "{CALL insert_user(?,?,?)}";
        var callableStatement = baseRepository.getConnection().prepareCall(query);

        callableStatement.setString(1, user.getName());
        callableStatement.setString(2, user.getEmail());
        callableStatement.setString(3, user.getCountry());

        System.out.println(callableStatement);

        callableStatement.executeUpdate();

    }

    @Override
    public void addUserTransaction(User user, int[] permision) throws SQLException {
        var conn = baseRepository.getConnection();

        // for insert a new user

        PreparedStatement pstmt = null;

        // for assign permision to user

        PreparedStatement pstmtAssignment = null;

        // for getting user id

        ResultSet rs = null;

        try {


            // set auto commit to false

            conn.setAutoCommit(false);

            //

            // Insert user

            //

            pstmt = conn.prepareStatement(SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, user.getName());

            pstmt.setString(2, user.getEmail());

            pstmt.setString(3, user.getCountry());

            int rowAffected = pstmt.executeUpdate();

            // get user id

            rs = pstmt.getGeneratedKeys();

            int userId = 0;

            if (rs.next())

                userId = rs.getInt(1);

            //

            // in case the insert operation successes, assign permision to user

            //

            if (rowAffected == 1) {

                // assign permision to user

                String sqlPivot = "INSERT INTO user_permision(user_id,permision_id) "

                        + "VALUES(?,?)";

                pstmtAssignment = conn.prepareStatement(sqlPivot);

//                for (int permisionId : permisions) {
//
//                    pstmtAssignment.setInt(1, userId);
//
//                    pstmtAssignment.setInt(2, permisionId);
//
//                    pstmtAssignment.executeUpdate();
//
//                }

                conn.commit();

            } else {

                conn.rollback();

            }

        } catch (SQLException ex) {

            // roll back the transaction

            try {

                if (conn != null)

                    conn.rollback();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }

            System.out.println(ex.getMessage());

        } finally {

            try {

                if (rs != null) rs.close();

                if (pstmt != null) pstmt.close();

                if (pstmtAssignment != null) pstmtAssignment.close();

                if (conn != null) conn.close();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }

        }


    }

    @Override
    public void insertUpdateWithoutTransaction() {
        var conn = baseRepository.getConnection();

        try (

                Statement statement = conn.createStatement();

                PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);

                PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE)) {


            statement.execute(SQL_TABLE_DROP);

            statement.execute(SQL_TABLE_CREATE);


            // Run list of insert commands

            psInsert.setString(1, "Quynh");

            psInsert.setBigDecimal(2, new BigDecimal(10));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();


            psInsert.setString(1, "Ngan");

            psInsert.setBigDecimal(2, new BigDecimal(20));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();


            // Run list of update commands


            // below line caused error, test transaction

            // org.postgresql.util.PSQLException: No value specified for parameter 1.

            psUpdate.setBigDecimal(2, new BigDecimal(999.99));


            //psUpdate.setBigDecimal(1, new BigDecimal(999.99));

            psUpdate.setString(2, "Quynh");

            psUpdate.execute();


        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    @Override
    public void insertUpdateUseTransaction() throws SQLException {
        var conn = baseRepository.getConnection();
        conn.setAutoCommit(false); // default true
        try (


             Statement statement = conn.createStatement();

             PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);

             PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE)) {

            statement.execute(SQL_TABLE_DROP);

            statement.execute(SQL_TABLE_CREATE);

            // start transaction block

            conn.setAutoCommit(false); // default true

            // Run list of insert commands

            psInsert.setString(1, "Quynh");

            psInsert.setBigDecimal(2, new BigDecimal(10));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();


            psInsert.setString(1, "Ngan");

            psInsert.setBigDecimal(2, new BigDecimal(20));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();


            // Run list of update commands


            // below line caused error, test transaction

            // org.postgresql.util.PSQLException: No value specified for parameter 1.

            psUpdate.setBigDecimal(2, new BigDecimal(999.99));


            //psUpdate.setBigDecimal(1, new BigDecimal(999.99));

            psUpdate.setString(2, "Quynh");

            psUpdate.execute();


            // end transaction block, commit changes

            conn.commit();

            // good practice to set it back to default true

            conn.setAutoCommit(true);


        } catch (Exception e) {

            System.out.println(e.getMessage());

            e.printStackTrace();

        }

    }

    @Override
    public List<User> selectAllUsersBySP() throws SQLException {
        List<User> userList = new ArrayList<>();

        Connection connection = baseRepository.getConnection();
        connection.setAutoCommit(false);
        CallableStatement callableStatement = connection.prepareCall("CALL select_all_users()");

        ResultSet resultSet = callableStatement.executeQuery();

        connection.commit();

        return userList;
    }

    @Override
    public boolean updateUserBySP(User user) throws SQLException {
        Connection connection = baseRepository.getConnection();
        connection.setAutoCommit(false);
        CallableStatement callableStatement = connection.prepareCall("CALL update_user(?)");

        callableStatement.setString(1, String.valueOf(user.getId()));

        ResultSet resultSet = callableStatement.executeQuery();



        connection.commit();


        return false;
    }

    @Override
    public boolean deleteUserBySP(int id) throws SQLException {
        return false;
    }
}
