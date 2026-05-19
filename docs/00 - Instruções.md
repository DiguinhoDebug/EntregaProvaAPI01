## Mínimo esperado

Para que a avaliação seja considerada entregue, o projeto deve:

- iniciar sem erro;
- conectar ao PostgreSQL;
- possuir CRUD funcional;
- estar em repositório público no GitHub.

Não espere que o projeto compile ou rode corretamente no primeiro momento. Parte da avaliação é justamente identificar e corrigir os problemas existentes.

## Instruções
1. Corrigir a configuração do projeto

Verifique se:

- o projeto inicia corretamente;
- o banco PostgreSQL está configurado;
- o application.properties possui as configurações corretas;
- as dependências necessárias estão no pom.xml.

---

2. Corrigir as entidades

As entidades devem estar corretamente mapeadas com JPA.

Entidades esperadas:

- LocalEvento:
idLocal; nome; endereco; capacidade.

- Evento:
idEvento; nome; descricao; dataEvento; valorIngresso; local.

- Inscricao:
idInscricao; nomeParticipante; emailParticipante; status; evento.

---

3. Implementar os relacionamentos

O sistema deve permitir:

cadastrar locais;
cadastrar eventos vinculados a um local;
cadastrar inscrições vinculadas a um evento;
listar eventos de um determinado local;
listar inscrições de um determinado evento.

--- 

4. Implementar os DTOs

O projeto deve usar DTOs para entrada e saída de dados.

Não é obrigatório retornar todos os dados da entidade diretamente.

Os DTOs devem ajudar a organizar as informações recebidas e devolvidas pela API.

---

5. Implementar os CRUDs principais

A API deve possuir rotas para:

LocalEvento
 - GET /locais
 - GET /locais/{idLocal}
 - POST /locais
 - PUT /locais/{idLocal}
 - DELETE /locais/{idLocal}

Evento
 - GET /eventos
 - GET /eventos/{idLocal}
 - POST /eventos
 - PUT /eventos/{idLocal}
 - DELETE /eventos/{idLocal}

Inscricao
 - GET /inscricoes
 - GET /inscricoes/{idLocal}
 - POST /inscricoes
 - DELETE /inscricoes/{idLocal}

---

6. Criar consultas úteis

A API deve possuir pelo menos as seguintes consultas:

Lista os eventos cadastrados em um determinado local.
GET /eventos/local/{idLocal}

Lista as inscrições de um determinado evento.
GET /inscricoes/evento/{idEvento}

Filtra eventos pelo nome.
GET /eventos/filtro?nome=...

---

7. Aplicar validações

Utilize validações nos DTOs ou entidades, como:

campo obrigatório;
valor positivo;
email válido;
capacidade positiva;
nome não vazio.

--- 

8. Configurar Swagger/OpenAPI

O projeto deve possuir documentação Swagger funcionando e personalizada.

Ao executar o projeto, o Swagger deve estar acessível em uma das opções abaixo:

http://localhost:8080/swagger-ui.html
ou
http://localhost:8080/swagger-ui/index.html

As principais classes e rotas devem possuir anotações
@Operation
@Tag

---

9. Testar a API

Teste as rotas principais usando Postman ou Swagger.

É importante verificar:

cadastro;
listagem;
busca por idLocal;
atualização;
remoção;
relacionamento entre entidades;
filtros.

--- 

10. Entregar no GitHub

Ao final, suba o projeto em um repositório público no GitHub.

O repositório deve conter:

código-fonte completo;
README atualizado;
pasta /docs;
projeto funcionando;
nome do aluno no README.
