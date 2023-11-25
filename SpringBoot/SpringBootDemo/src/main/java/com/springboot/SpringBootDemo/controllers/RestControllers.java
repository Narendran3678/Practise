package com.springboot.SpringBootDemo.controllers;
import com.springboot.SpringBootDemo.beaninterface.Coach;
import com.springboot.SpringBootDemo.beans.PrototypeClass;
import com.springboot.SpringBootDemo.beans.SingletonClass;
import com.springboot.SpringBootDemo.beans.ThirdPartyBean;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class RestControllers {
    @Value("${name}")
    private String name;
    @Value("${role}")
    private String role;
    private Coach coach;
    private ThirdPartyBean thirdPartyBean;
    @PostConstruct
    public void customInit()
    {
        System.out.println("RestControllers is Custom Initiated");
    }
    @Autowired
    //public RestControllers(@Qualifier("BaseBallObj") Coach coach)
    public RestControllers( Coach coach)
    {
        System.out.println("RestControllers is Constructor Initiated");
        this.coach=coach;
    }
    @RequestMapping("/")
    public String indexMethod() {
        return "Hello World ["+name+"] Role ["+role+"]";
    }

    @RequestMapping("/coach")
    public String coachMethod() {
        return coach.dailyWorkout();
    }
    @RequestMapping("/thirdparty")
    public String thirdPartymethod() {
        return thirdPartyBean.sendDocument();
    }

    @Autowired
    public void getThirdPartyBean(ThirdPartyBean thirdPartyBean) {
        this.thirdPartyBean = thirdPartyBean;
    }
    @Autowired
    public void instantiateSingleton(SingletonClass sc1, SingletonClass sc2)
    {
        if(sc1==sc2) {
            System.out.println("This is Singleton Class");
        }
    }
    @Autowired
    public void instantiatePrototype(PrototypeClass pc1, PrototypeClass pc2)
    {
        if(pc1!=pc2) {
            System.out.println("This is Prototype Class");
        }
    }

    @PreDestroy
    public void customDestroy()
    {
        System.out.println("RestControllers is Custom Destroy");
    }
}
