import com.service.ValidateUser;
import org.testng.annotations.Test;

import java.sql.SQLException;

/**
 * Created by alekspribysh on 9/23/15.
 */
public class TestLogin {

    ValidateUser valid = new ValidateUser();
    private String name = "bill";
    private String passcode = "secretpass";


    @Test
    public void loginPassword() throws SQLException {
        valid.validLoginPassword(name, passcode);

    }
}
