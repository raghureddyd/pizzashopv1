
# pizzashopv1

Online Pizza Ordering Webapplication




## Authors

- [@raghureddyd](https://github.com/raghureddyd)


## Features

- Browsing pizzas (Anyone can access it; anonymous access)
- Ordering pizzas (Only logged-in users can order)
- View order status (anonymous access)
- Update order status (Only staff or admin roles)
- View users (Only Only staff or admin roles)
- Register user (anonymous access)

## Roles
- USER (on registration this role is assigned by default)

- STAFF

- ADMIN

## Order Status

  - RECEIVED (default active on order creation)
  - PROCESSING 
  - IN_TRANSIT
  - DELIVERED
  - CANCELLED

## DB migration steps
- put/uncomment suitable db jar in pom.xml
- put/uncomment db credentials , url, driver in application.properties
 

## Documentation

[Open API 3](http://localhost:8080/pizzashop/v3/api-docs)

[Swagger UI](http://localhost:8080/pizzashop/swagger-ui.html)

[POSTMAN_Collection](https://www.getpostman.com/collections/8ee29fecd5d97f844b42)

## Deployment

To deploy this project on Tomcat

Check the project from Git @ [pizzashopv1](https://github.com/raghureddyd/pizzashopv1) and run mvn clean install.

Please make sure JAVA_HOME is set jdk-11


## Postman tests

1) To get JWT do POST request @

http://localhost:8080/pizzashop/api/v1/login

body

{

    "username": "RDH",
    "password": "rdhRDH"

}

Response
{
"jwtToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJSREgiLCJleHAiOjE2MjQ4NjAxODEsImlhdCI6MTYyNDg0MjE4MX0.vaeNRtr_nQb_vmxM-xdT0OImuETUMJqeI2e66hWTg39i4ueaQQ4sJ5h-H5injh6Fp0k47-RKo3mnLJ2ZJLkRDQ"
}

2) To access secured Endpoints use jwttoken as shown below
   Authorization Bearer jwtToken









