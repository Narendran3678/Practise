package Spring.Boot.aop;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class LoggerAopComponent {
    /*
    execution(modifiers-pattern?
			ret-type-pattern
			declaring-type-pattern?name-pattern(param-pattern)
			throws-pattern?)
	*/
    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("LoggerAopComponent for AccountDao AddAccount Executed @Before");
    }

    @Before("execution(public void *Account())")
    public void beforeAllAccountAdvice() {
        System.out.println("LoggerAopComponent for AccountDao All Account Method Executed @Before");
    }
    @Around("execution(public void *Account())")
    public void aroundAdviceAccountMethod(ProceedingJoinPoint jointPoint) throws Throwable {

        System.out.println("LoggerAopComponent for  addAccount Method Executed Before @Advice");
        jointPoint.proceed();
        System.out.println("LoggerAopComponent for addAccount Method Executed After @Advice");
    }

    @Around("execution(public void addCustomer(String))")
    public void aroundAdviceCustomerMethod(ProceedingJoinPoint jointPoint) throws Throwable {
        Object[] argArr = jointPoint.getArgs();
        String str= "";
        if(argArr.length >0) {
            str =(String)argArr[0];
        }
        System.out.println("LoggerAopComponent for AccountDao add Customer Method Executed Before @Advice");
        System.out.println("Received Parameter..."+str);
        System.out.println("Transformed Parameter..."+str.concat("_JoinPoint"));
        jointPoint.proceed(new String[] {str.concat("_JoinPoint")});
        System.out.println("LoggerAopComponent for AccountDao add Customer Method Executed After @Advice");
    }

    @AfterReturning(value = "execution(public String getCustomerName())",returning = "customerName")
    public void afterReturnMethod(String customerName) {
        System.out.println("AfterReturn Method Value ["+customerName+"_customer]");
    }

    @AfterThrowing(value = "execution(public String Spring.Boot.dao.*.*())",throwing = "ex")
    public void afterThrowingMethod(Exception ex) {
        System.out.println("AfterThrowing Method Exception ["+ex+"] Logged");
    }
}
