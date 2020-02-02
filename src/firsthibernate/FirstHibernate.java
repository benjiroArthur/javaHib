/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firsthibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author BENJIRO
 */
public class FirstHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    setCustomer();
        
    }
    
    //save Customer info
    public static void setCustomer()
    {
        String cusId = "";
            SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(CustomerState.class)
                .buildSessionFactory();
        
       Session session = sessionFactory.openSession();
       
       //create session factory
       
        try {
             session.beginTransaction();
            List<CustomerState> listcustomer = session.createQuery("from CustomerState c where c.id = '"+1+"'").list();
            
            
            if(listcustomer.size() == 1){
                for(CustomerState cus:listcustomer){
                   cusId = cus.getCustomerID(); 
                }
              String idIndex = cusId.substring(3);
              
              int inIndex = Integer.parseInt(idIndex);
              
              inIndex = inIndex+1;
              if(inIndex < 10){
                  cusId = "cus00"+inIndex;
              }
              else if(inIndex > 9 && inIndex < 100){
                 cusId = "cus0"+inIndex; 
              }
              else if(inIndex > 99){
                 cusId = "cus"+inIndex; 
              }
              
            }
            else{
                cusId = "cus001";
            }
            
            System.out.println("Create customer object");
            
            Customer customer = new Customer(cusId, "Mr.", "Abeiku", "French", "123 Kumasi", "Kumasi", "00233", "02112211211");
            
           
            
            System.out.println("Saving customer object");
            session.save(customer);
            
            System.out.println("Committing transaction");
            session.getTransaction().commit();
            System.out.println("Customer object committed");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally 
                {
                    session.clear();
                    session.close();
                }
    }
    
    //List all customers
    public static void getCustomers()
    {
        SessionFactory sessionFactory;
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();
        
       Session session = sessionFactory.openSession();
        try {
            //start transaction
            session.beginTransaction();
            
            List<Customer> customer = session.createQuery("from Customer").list();
            
           if(customer.size() > 0){
                //display result
            for(Customer cust :customer){
                System.out.println(cust.getId());
                System.out.println(cust.getCustomerID());
                System.out.println(cust.getTitle());
                System.out.println(cust.getFname());
                System.out.println(cust.getLname());
            }
           }
           else{
               System.out.println("No Rcords found");
           }
            //commit transaction
            //session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally{
            session.clear();
            session.close();
        }  
    }
    
}
