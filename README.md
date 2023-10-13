
# Aluguel-de-Carros-API

Este é o desafio para testar os conhecimentos.


# O Desafio

Precisamos de uma API que sirva o back-end de uma aplicação de aluguel de carros. Essa API precisa ser capaz de:

- Cadastrar um carro/cliente
- Editar um carro/cliente
- Deletar um carro/cliente
- Listar os carros/clientes
- Obter informações de um carro/cliente por ID

A entidade `carro` deve ter os seguintes campos:

- id -> Identificador do carro.
- marca -> Marca do carro.
- modelo -> Modelo do carro.
- dataCadastro -> Data em que o carro foi cadastrado.

A entidade `cliente` deve ter os seguintes campos:

- id -> Identificador do cliente.
- nome -> Nome do cliente (máx. de 50 caracteres)
- cpf -> CPF do cliente (deve ser único e não guardar pontos e traços).
- carro -> Carro alugado pelo cliente.
- dataNascimento -> Data de nascimento do cliente (formatada no padrão br: dd/MM/aaaa).
- created_at -> Data de criação do cliente.
- updated_at -> Data em que houve alteração no cliente.

Você pode utilizar qualquer banco, desde que ele seja [SQL](http://www.sqlcourse.com/intro.html).


##     Stack
#### <a href="https://www.oracle.com/br/java/" target="_blank"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" width="60" height="60"/></a>  <a href="https://spring.io/" target="_blank"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original-wordmark.svg" width="60" height="60"/></a>

##   Banco de dados
####   <a href="https://www.mysql.com/" target="_blank"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original-wordmark.svg" width="60" height="60"/></a>

