package projectimdb.acadgild.com.imdbproject;

public class DatabaseHelper {
    private static final String CREATE_TABLE = "CREATE TABLE";
    private static final String TABLE_MOVIEDETAILS = "moviedetails";
    private static final String COMMA = ", ";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_RELEASE_DATE = "releasedate";
    private static final String COLUMN_POSTER_PATH = "posterpath";
    private static final String COLUMN_POPULARITY = "popularity";
    private static final String COLUMN_VOTE_AVERAGE = "voteaverage";
    private static final String COLUMN_VOTE_COUNT = ""    ;
    private static final String COLUMN_MOVIE_RAW_DETAILS  = "" ;
    private static final String COLUMN_IS_FAVORITE   = "" ;
    private static final String COLUMN_IS_WATCHLIST = ""  ;

    private static final String OPEN_BRACE = "{";

    private static final String DATATYPE_VARCHAR = "varchar";
    private static final String DATATYPE_NUMERIC = "numeric";
    private static final String DATATYPE_REAL = "real";





    public static final String CREATE_TABLE_MOVIEDETAILS = new StringBuilder()
            .append(CREATE_TABLE).append(TABLE_MOVIEDETAILS).append(OPEN_BRACE)
            .append(COLUMN_ID).append(DATATYPE_NUMERIC + COMMA)
            .append(COLUMN_TITLE).append(DATATYPE_VARCHAR + COMMA)
            .append(COLUMN_RELEASE_DATE).append(DATATYPE_VARCHAR + COMMA)
            .append(COLUMN_POSTER_PATH).append(DATATYPE_VARCHAR + COMMA)
            .append(COLUMN_POPULARITY).append(DATATYPE_REAL + COMMA)
            .append(COLUMN_VOTE_AVERAGE).append(DATATYPE_REAL + COMMA)
            .append(COLUMN_VOTE_COUNT).append(DATATYPE_NUMERIC + COMMA)
            .append(COLUMN_MOVIE_RAW_DETAILS).append(DATATYPE_VARCHAR + COMMA)
            .append(COLUMN_IS_FAVORITE).append(DATATYPE_VARCHAR + COMMA)
            .append(COLUMN_IS_WATCHLIST).append(DATATYPE_VARCHAR + COMMA)
            .append("UNIQUE(").append(COLUMN_ID)
            .append(") ON CONFLICT REPLACE)").toString();


}
