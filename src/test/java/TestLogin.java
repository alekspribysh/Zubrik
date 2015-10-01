import com.service.ValidateUser;
import org.testng.annotations.Test;
import org.testng.*;

import java.sql.SQLException;

/**
 * Created by alekspribysh on 9/23/15.
 */
public class TestLogin {

    ValidateUser valid = new ValidateUser();
    private String name = "aleks";
    private String passcode = "aleksandr";
    private String fullName = "Aliaksandr Prybysh";
    private String email = "aleks@gmail";

    @Test
    public void log_in() throws SQLException {

       // Assert.assertEquals(valid.validLoginPassword(name, passcode), true);
    }

    @Test
    public void createUser() throws SQLException {

        //Assert.assertEquals(valid.validAddUser(name, passcode,fullName, email), true);
    }
}
