package Spring.Boot.dao;

public interface AccountDaoI {
    public void addAccount();
    public void getAccount();
    public void updateAccount();
    public void addCustomer(String customerName);
    public String getCustomerName() throws Exception;
    public String exceptionTest() throws Exception;
    public void customAopMethod1();
    public void customAopMethod2();
}
