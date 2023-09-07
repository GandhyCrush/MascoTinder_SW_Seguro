# Utiliza una imagen base con Tomcat y OpenJDK 17
FROM tomcat:9-jdk17-openjdk

# Elimina las aplicaciones por defecto de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copia tu archivo .war al directorio webapps de Tomcat
COPY MascoTinder_WEB.war /usr/local/tomcat/webapps/ROOT.war

# Expone el puerto 8080
EXPOSE 8080

# Inicia Tomcat al arrancar el contenedor
CMD ["catalina.sh", "run"]