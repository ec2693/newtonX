package Repository;

import com.google.inject.Singleton;
import models.User;
import play.api.db.Database;
import javax.inject.Inject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Singleton
public class UserRepository {

    @Inject
    Database database;

    public User createUser(User user) throws SQLException {
        PreparedStatement preparedStatement = database.getConnection().prepareStatement("insert into users (id, firstName, lastName) values (null, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, user.getFirstName());
        preparedStatement.setString(2, user.getLastName());
        preparedStatement.execute();
        ResultSet result = preparedStatement.getGeneratedKeys();
        if (result.next()) {
            user.setId(result.getInt(1));
        }
        preparedStatement.executeUpdate();
        return user;
    }

    public Optional<User> getUserById(int userId) throws SQLException{
        PreparedStatement preparedStatement = database.getConnection().prepareStatement("select * from users where id = ?");
        preparedStatement.setInt(1, userId);
        preparedStatement.execute();

        ResultSet result = preparedStatement.getResultSet();
        if (result.next()) {
            User user = new User();
            user.setId(result.getInt("id"));
            user.setFirstName(result.getString("firstName"));
            user.setLastName(result.getString("lastName"));
            return Optional.of(user);
        }

        return Optional.empty();

    }

    public List<User> getAllUsers() throws SQLException {
        PreparedStatement preparedStatement = database.getConnection().prepareStatement("select * from users");
        List<User> users = new ArrayList<>();
        preparedStatement.execute();
        ResultSet result = preparedStatement.getResultSet();
        while (result.next()) {
            User user = new User();
            user.setId(result.getInt("id"));
            user.setFirstName(result.getString("firstName"));
            user.setLastName(result.getString("lastName"));
            users.add(user);
        }
        return users;
    }


}
