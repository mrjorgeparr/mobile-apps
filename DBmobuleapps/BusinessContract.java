import java.utils.vector


        /*This is essentially java code to define the scheme of the relation Business*/
public class BusinessContract {

        public static abstract class BusinessEntry implements BaseColumns{
            public static final String TABLE_NAME ="Business";
            public static final String ID = "id";
            public static final String CIF = "CIF";
            public static final String NAME = "name";
            public static final String LATITUDE = "latitude";
            public static final String LONGITUDE = "longitude";
            private static final int TYPE = "type";
            private static final String SCHEDULE = "schedule";

            /* storing a vector like that may be a source error, */
            private static final Vector KEYWORDS = "keywords";
        }


}
