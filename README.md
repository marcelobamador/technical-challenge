# Technical Challenge
The challenge was developed using the JAVA language in its version 11.

To record the data, the Postgres database was used. 

# The following endpoints were created:<br />
# Get<br />
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
      
# COMO EXECUTAR A APLICAÇÃO<br />
- Fazer o clone da aplicação na sua máquina.
- Selecionar a branch <b>MASTER</b>
- Após o clone, importar o projeto para a sua IDE (Eclipse, STS, etc).
- Clicar com o botão direito do mouse em cima do projeto -> Run as -> Maven Clean
- Após o Maven clean, clicar com o botão direito do mouse em cima do projeto -> Run as -> Maven Install
- Após o Maven Install, clicar com o botão direito do mouse em cima do projeto -> Run as -> Spring boot app
- Com os passos acima, o projeto vai subir na porta 9180 e poderá ser acessado assim: http://localhost:9180/v1/terminals (local)

# EXECUTAR A APLICAÇÃO NO HEROKU
- A aplicação está disponivel no link: https://dock-test-app.herokuapp.com 
- Os endpoints a serem utilizados estão acima.
