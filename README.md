# Sistema de registro de cupom

Esse projeto foi feito com base nos requisitos do projeto, seguindo boas práticas de DDD
e Clean Architecture. É possível visuzalizar os objetos de domínio no core do projeto, especificamente
na pasta de <strong>📁 core/domain/vo</strong>.
<br/>
Todas as regras de negócio estão encapsuladas nos objetos de domínio seguindo as
boas práticas do DDD, segue os objetos de domínio construídos nesse projeto:

- CodeCoupon
- DescriptionCoupon
- DiscountValueCoupon
- ExpirationDateCoupon

Foi utilizado o JaCoCo para checar a cobertura de linhas no core do projeto, especificamente na parte onde continha
as regras negocias do projeto. E para fazer os testes unitários utilizei JUnit5 e Mockito.

Essa aplicação contém um banco de dados em memória seguindo o que foi pedido no desafio.

## Como fazer build da imagem e testar a API

Basta rodar o comando `docker compose --profile test up test --build` para executar
os testes e validar o coverage do projeto (mínimo de 80% configurado no JaCoCo).

O processo ocorre em duas etapas dentro do Dockerfile multi-stage:
1. **Build & Test** — compila o projeto, roda os testes e valida o coverage
2. **Runtime** — gera a imagem final enxuta apenas com o JAR

Se o coverage estiver abaixo de 80%, o build falha e a imagem não é gerada.
Para subir a aplicação após a validação:

```docker compose up --build -d```

## Como acessar o swagger?

O swagger do projeto é possível visualizar assim que é feito build da imagem docker e 
a construção do docker-compose no endereço: http://localhost:8080/swagger-ui.html

Stack utilizada: <i>Java, Spring boot, JUnit, Jacoco e H2</i>