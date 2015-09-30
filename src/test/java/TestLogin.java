import com.service.ValidateUser;
import org.testng.annotations.Test;
import org.testng.*;

import java.sql.SQLException;

/**
 * Created by alekspribysh on 9/23/15.
 */
public class TestLogin {

    ValidateUser valid = new ValidateUser();
    private String name = "Aleks";
    private String passcode = "aleksandr";

    @Test
    public void loginPassword() throws SQLException {

        Assert.assertEquals(valid.validLoginPassword(name, passcode), true);
    }
}
