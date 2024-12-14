package Data;

import java.util.HashMap;
import java.util.Map;

import Users.User;

public class Data {
	protected Map<String, User> usersDatabase;
    protected Map<String, Object> coursesDatabase;

    public Data() {
        this.usersDatabase = new HashMap<>();
        this.coursesDatabase = new HashMap<>();
    }
}

