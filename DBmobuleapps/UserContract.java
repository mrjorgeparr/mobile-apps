public class UserContract {

    public static abstract class UserEntry implements BaseColumns{
        public static final String TABLE_NAME ="User";
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String SURNAME1 = "surname1";
        public static final String SURNAME2 = "surname2";
        public static final String EMAIL  = "email";
    }
}

