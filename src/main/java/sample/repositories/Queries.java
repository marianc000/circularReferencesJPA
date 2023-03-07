package sample.repositories;

public class Queries {

    static String SELECT_ALL = "SELECT  c.COUNTRY_ID,  c.COUNTRY_NAME,"
            + "  a.AUTHOR_ID,  a.AUTHOR_NAME, p.POST_ID, p.POST_NAME,"
            + "  a2.AUTHOR_ID FAN_ID, a2.AUTHOR_NAME FAN_NAME FROM COUNTRY c"
            + "  LEFT JOIN AUTHOR a on  c.COUNTRY_ID=a.COUNTRY_ID"
            + "  LEFT JOIN POST p on a.AUTHOR_ID=p.AUTHOR_ID"
            + "  LEFT JOIN POST_LIKES pl on p.POST_ID=pl.POST_ID"
            + "  left JOIN AUTHOR a2 ON a2.AUTHOR_ID  = pl.AUTHOR_ID"
            + "  ORDER BY COUNTRY_NAME, a.AUTHOR_NAME, POST_NAME, a2.AUTHOR_NAME";
}
