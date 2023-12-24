package Spring.Boot.dao;
import org.springframework.stereotype.Repository;
@Repository
public class AccountDaoImpl implements AccountDaoI {
    public void addAccount() {
        System.out.println("Add Account Initiated");
    }
    public void getAccount() {
        System.out.println("Get Account Initiated");
    }
    public void updateAccount() {
        System.out.println("Get Account Initiated");
    }
    public void addCustomer(String customerName) {
        System.out.println("Add Customer Initiated CustomerName["+customerName+"]");
    }
    public String getCustomerName() throws Exception {
       return "Narendran";
    }
    public String exceptionTest() throws Exception {
        throw new Exception("Test After Throwning Exception");
    }
}
