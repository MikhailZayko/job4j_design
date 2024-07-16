package ru.job4j.violation.dip;

/**
 * UserService зависит от конкретного класса MySQLDatabase,
 * что затрудняет замену базы данных на другую реализацию.
 */

public class User {

}

class UserService {

    private MySQLDatabase database;

    public UserService() {
        this.database = new MySQLDatabase();
    }

    public void saveUser(User user) {
        database.save(user);
    }
}

class MySQLDatabase {
    public void save(User user) {
    }
}