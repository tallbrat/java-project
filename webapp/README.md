 java-webapp
=========================================

 build
----------
> mvn clean package -Dlog.hostname=$HOSTNAME -Dlog.slack.channel=develop -Dlog.slack.webhook=https://hooks.slack.com/services/XXXXXX


 deploy (debug)
----------------
> mvn antrun:run@deploy -DAPPNAME=java-webapp


 deploy (release)
-------------------
> mvn antrun:run@deploy -DRELEASE=true -DAPPNAME=java-webapp


 deploy (release & use cdn)
----------------------------
> mvn antrun:run@deploy -DRELEASE=true -DUSECDN=true -DAPPNAME=java-webapp



 tomcat server.xml settings
------------------------------
	<Connector port="8080" redirectPort="8443" protocol="HTTP/1.1"
		maxThreads="200" connectionTimeout="20000"
		URIEncoding="UTF-8"
		/>

	<Context path="" reloadable="true" docBase="/app/java-webapp/web" allowLinking="true">
		<Resource name="jdbc/java-webapp" auth="Container" type="javax.sql.DataSource"
			maxActive="200" maxIdle="20" maxWait="10000"
			username="XXXXXX" password="YYYYYY"
			factory="org.apache.commons.dbcp.BasicDataSourceFactory"
			driverClassName="com.mysql.jdbc.Driver"
			url="jdbc:mysql://localhost:3306/java-webapp?autoReconnect=true&amp;useUnicode=true&amp;characterEncoding=utf8"
			validationQuery="SELECT 1"
		/>
		<Manager pathname=""/>
	</Context>
