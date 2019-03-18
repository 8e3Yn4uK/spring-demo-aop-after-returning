package com.aopdemo;

import com.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by 8e3Yn4uK on 13.03.2019
 */

public class MainDemoApp {
    public static void main(String[] args) {

        // read the spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from the spring container
        com.aopdemo.dao.AccountDAO theAccountDAODao = context.getBean("accountDAO", com.aopdemo.dao.AccountDAO.class);
        MembershipDAO theMembershipDao = context.getBean("membershipDAO", MembershipDAO.class);

        // call the business method
        AccountDAO myAccountDAO = new AccountDAO();
        theAccountDAODao.addAccount(myAccountDAO, true);
        theMembershipDao.addAccount();

        // close the context
        context.close();
    }
}
