# dropwizard-sample
Basic application using Dropwizard , MySql and Builder Pattern

#To run
Open the **config.yml** file and update the following properties accordingly. I am using MySql for examples
##database:
  - **driverClass**  :  driverClass [example com.mysql.cj.jdbc.Driver]
  - **user**         :  userName
  - **password**     :  password
  - **url**          :  connectionURL [example jdbc:mysql://localhost:3306/dbNameHere]
  - **properties**   :
    -    **hibernate.dialect**       :  dialectHere [example org.hibernate.dialect.MySQL5Dialect]
    -    **charSet**                 :  UTF-8
    -    **hibernate.show_sql**      :  true
    -    **hibernate.format_sql**    :  true
    -    **hibernate.hbm2ddl.auto**  :  select one out of [validate | update | create | create-drop]
