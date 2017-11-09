# Aplicacion Aseguradora

## Informacion General

Aplicacion JEE que modela los servicios de mantenimiento de polizas de seguros, proveedores y verificacion de cobertura. La aplicacion esta separada en las siguientes partes:

* Servicio Web de la Aseguradora
* Servicio Web de los Proveedores
* Sitio de Proveedores / Consultas

### Servicio Web de la Aseguradora

Este servicio web es el encargado de llevar el control de las polizas (altas, modificaciones y consultas) y de los proveedores (altas, modificacion y consultas)

WSDL: ```http://<host>:8080/webservices/ServicioAseguradora?wsdl```

### Servicio Web de los Proveedores

Este servicio web es el encargado de realizar las consultas de cobertura para una poliza y proveeor

WSDL: ```http://<host>:8080/webservices/ServicioProveedores?wsdl```

### Sitio de Proveedores / Consultas

Este sitio representa la pagina de consulta de cobertura para un proveedor particular (consume el servicio web de proveedores) y muestra las siguientes consultas:

* A
* B
* C

URL: ```http://<host>:8080/```

## Informacion Tecnica

Las dependencias y la construccion de la aplicacion son manejadas por medio de Maven 3.2.5

### Construccion

* En el directorio raiz del proyecto ejecutar ``` mvn clean install ```
* Para la ejecucion de los scripts de base de datos ```mvn flyway:clean``` y luego ```mvn flyway:migrate```

### Servidor de Aplicaciones

La aplicacion fue desarrollada para ser instalada en el servidor de aplicaciones [Apache Tomee](https://tomee.apache.org/) en su version *7.0.4 plume* [descargar](http://repo.maven.apache.org/maven2/org/apache/tomee/apache-tomee/7.0.4/apache-tomee-7.0.4-plume.zip).

### Base de Datos

La base de datos utilizada es MySQL 5.5, es necesario crear un esquema y las credenciales para la aplicacion y a su vez en el achivo de configuracion de los recursos en la aplicacion ```WEB-INF/resources.xml```

```
<resources>
    <Resource id="mysql-jdbc-jta-aseguradora" type="javax.sql.DataSource">
        JtaManaged = true
        DataSourceCreator = tomcat

        validationQuery = SELECT 1
        initialSize = 2
        removeAbandoned = true
        removeAbandonedTimeout = 120

        driverClassName = com.mysql.jdbc.Driver
        url = jdbc:mysql://<host>/<bd>
        username = <user>
        password = <pwd>
    </Resource>
</resources>
```