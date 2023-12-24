package Spring.Boot.test;

import Spring.Boot.config.SpringConfig;
import Spring.Boot.dao.AccountDaoI;
import Spring.Boot.dao.AccountDaoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringStarterFile {
    public static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    public static void main(String[] args) throws Exception {
        //beforeAdvice();
        aroundAdvice();
        System.exit(1);
    }
    public static void beforeAdvice() {
        AccountDaoI accountDoaI = context.getBean(AccountDaoImpl.class);
        accountDoaI.addAccount();
        accountDoaI.getAccount();
        accountDoaI.updateAccount();
    }
    public static void aroundAdvice() throws Exception {
        AccountDaoI accountDoaI = context.getBean(AccountDaoImpl.class);
        //System.out.println("Customer Received..."+accountDoaI.getCustomerName());
        //accountDoaI.addCustomer("Naren");
        //accountDoaI.addCustomer(null);
        accountDoaI.exceptionTest();
    }
}
