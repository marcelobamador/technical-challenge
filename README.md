# Technical Challenge
The challenge was developed using the JAVA language in its version 11.

To record the data, the Postgres database was used. 

# The following endpoints were created:<br />
# GET
  - http://localhost:9182/v1/itens<br />
  - http://localhost:9182/v1/user<br />
  - http://localhost:9182/v1/stock-movement<br /> 
<br /> 
# GET WITH PARAM
  - http://localhost:9182/v1/itens/1<br />
  - http://localhost:9182/v1/user/1<br />
  - http://localhost:9182/v1/stock-movement/1<br />
<br />
# POST
  - http://localhost:9182/v1/itens<br />
  - http://localhost:9182/v1/user<br />
  - http://localhost:9182/v1/stock-movement<br />
<br />
# PATCH
  - http://localhost:9182/v1/itens/1<br />
  - http://localhost:9182/v1/user/2<br />
  - http://localhost:9182/v1/stock-movement/1<br />
<br />
# DELETE
  - http://localhost:9182/v1/itens/2<br />
  - http://localhost:9182/v1/user/2<br />
  - http://localhost:9182/v1/stock-movement/1<br />
<br />
# Examples of requests below<br />
<br />
# Get all itens<br />
  - Method...........: getAllItens<br />
  - Return...........: Returns a list of all registered items<br />
  - Url..............: http://localhost:9182/v1/itens<br />
  - Return model:<br />
      {<br />
        "id": 1,<br />
        "name": "CD"<br />
      },<br />
      {<br />
        "id": 1,<br />
        "name": "CD"<br />
      }<br />
      <br />
# Get with param<br />
  - Method...........: getAllItensById<br />
  - Code.............: id (equivalent to the field 'id')<br />
  - Return...........: Returns the searched object if it exists in the database.<br />
  - Url..............: http://localhost:9182/v1/itens/1<br />
  - Return model:<br />
      {<br />
        "id": 1,<br />
        "name": "CD"<br />
      }<br />
      <br />
# Patch with param<br />
  - Method.............: changeItem<br />
  - Code...............: id (equivalent to the field 'id')<br />
  - Url................: http://localhost:9182/v1/itens/1<br />
  - Body of the request.:<br />
      {<br />
        "name": "CD"<br />
      }<br />
  - Return.............: Returns the changed object if it exists in the database.<br />
  - Url................: http://localhost:9182/v1/itens/1<br />
  - Return model..:<br />
      {<br />
        "id": 1,<br />
        "name": "CD"
      }<br />
# Post<br />
  - Method.............: addItem<br />
  - Obs................: In order for the sent string to be accepted, the header must be included in the request: Content-Type: text/html. If sent as JSON it will not be accepted.
  - Body of the request.: 2;DVD<br />
  - Return..............: Returns the object registered in the database.<br />
  - Url.................: http://localhost:9182/v1/itens<br />
  - Return model..:<br />
      {<br />
        "id": 1,<br />
        "name": "DVD"<br />
      }<br />
# Delete<br />
  - Method..............: deleteItemById<br />
  - Url.................: http://localhost:9182/v1/itens/1<br />
      
# HOW TO RUN THE APPLICATION<br />
- Clone the application on your machine.
- Select the branch <b>MASTER</b>
- After the clone, import the project to your IDE (Eclipse, STS, etc).
- Right-click on the project -> Run as -> Maven Clean
- After Maven clean, right-click on the project -> Run as -> Maven Install
- After Maven Install, right-click on the project -> Run as -> Spring boot app
- With the steps above, the project will go up on port 9182 and can be accessed like this: http://localhost:9182/v1/itens (local)<br />
<br />
# IMPORTANT<br />
PostgreSQL database must be installed on the machine
