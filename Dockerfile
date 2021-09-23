FROM tomcat:latest
ADD target/dmatanga-demo-1.0.0.war /usr/local/tomcat/webapps/
EXPOSE 8888
CMD ["catalina.sh", "run"]