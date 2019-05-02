This project is the simple eshop.

standalone.xml

<datasource jndi-name="java:jboss/datasources/bailov_eshop" pool-name="bailov_eshop" enabled="true" use-java-context="true">
    <connection-url>jdbc:h2:tcp://localhost/~/bailov_eshop</connection-url>
    <driver-class>org.h2.Driver</driver-class>
    <driver>h2</driver>
    <security>
        <user-name>sa</user-name>
        <password>sa</password>
    </security>
    <validation>
        <background-validation>false</background-validation>
    </validation>
</datasource>

From adminView it is possible to add, edit and delete products.

From customerView it is possible to buy products. Purchase process consist of three parts.
1. step requires first and last names, address and email. Names and addres are validated and should not be empty. Email should match regular expression for correct format.
2. step requires credit card number, which is 16 digits long
3. step requires confirmation from the customer, after which purchase is recorded into database.
