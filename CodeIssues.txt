/**
 *  1)Design Flow with the action servlet created. We should create a BEAN class to define the data types. 
 *  2)Seperate servlet class has to be created
 *     a) Seperate servlet class for creating the database connection and closing the connection.
 *     b) Separate class for running SQL queries. Like UPDATE , INSERT etc.
 *        a1) Poor sql queries has been used to get the user details during login.
 *     c) Seperate BEAN class for setting and getting datas. 
 *     d) Seperate LOGGER Class for logging exception.
 *     e) Seperate class for creating and ending the session.
 *  3) UserID should not be used as the source to redirect the page. Session temporary key needs to generated for each         login. and Ewhile accessing the each page session should be validated from jsp.
     4) I dont see the password being encrypted each time we update the password. Encryption has to be used.
 

*/



-- PostgreSQL syntax

CREATE TABLE users
(
  userid serial NOT NULL PRIMARY KEY,  // no data type written ,  Primary can also be put in (PRIMARY KEY( .....  columns )) , serial type is wrong
                                       // SERIAL is the correct format.  
				       // userid SERIAL integer NOT NULL PRIMARY KEY | should be the correct format.  
  username varchar(20) NOT NULL UNIQUE, // correct syntax is username varchar(20) UNIQUE NOT NULL
  "password" varchar(20),   // "password" should not be NULL add NOT NULL and  password has to be properly hashed while storing.
  first_name varchar(50), //  you can also use TEXT , which is much flexible than char or varchar with space usage.
  last_name varchar(50), 
  phone varchar(20),       //
  salary numeric(10,2)    // Correct syntax is salary NUMERIC(10,2)
)   // there is no semi-colon in this syntax.




<!-- 

1)  In any Java EE application we have to secure the admin page. Here I dont see any admin pages secured. 
  
  Example:
  
 <security-constraint>
   <web-resource-collection>
      <web-resource-name>admin</web-resource-name>
      <url-pattern>/admin/*</url-pattern>
   </web-resource-collection>
   <auth-constraint>
      <role-name>admin</role-name>
   </auth-constraint>
</security-constraint>
     
<security-role>
   <role-name>admin</role-name>
</security-role>

2) Login configurations are not included which include ,we need to define the Authentication method BASIC , FORM or DIGEST.

Example:

<login-config>
        <auth-method>FORM</auth-method>
        <realm-name>Secure Zone</realm-name>
        <form-login-config>
            <form-login-page>/login.jsp</form-login-page>
            <form-error-page>/login.htm?auth-error=true</form-error-page>
        </form-login-config>
</login-config>

3) Default Error Page needs to included for the un-authorized login
   
   Example :
   
   <error-page>
        <error-code>403</error-code>
        <location>/not-authorized.htm</location>
    </error-page>
    
 4) <servlet-name>accountServlet</servlet-name> is the proper usage.
 

 -->
