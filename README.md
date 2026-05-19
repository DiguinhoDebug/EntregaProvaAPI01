# 1-Eventos
# Avaliação Prática – API de Gestão de Eventos

## Contexto

Uma empresa responsável pela organização de eventos precisa de uma API para controlar seus eventos, locais onde acontecem e inscrições.

O projeto base já foi iniciado por um colega do seu time de desenvolvedores, então está parcialmente completo. Entretanto ele lhe pediu para você dar continuidade e fazer o projeto "rodar". 
Ele deixou alguns comentário com o "TODO", que seria o "a fazer" (to-do), e te ajudar no código.
Seu objetivo é analisar a estrutura do projeto, corrigir os problemas existentes e implementar as funcionalidades solicitadas.

A avaliação tem como foco verificar sua compreensão sobre:

- estrutura de uma API com Spring Boot;
- organização em camadas;
- uso de model, repository, service, controller e DTO;
- relacionamento entre entidades;
- integração com PostgreSQL;
- criação de rotas REST;
- validações;
- documentação com Swagger/OpenAPI;
- filtros simples;
- entrega via GitHub.

---

## Tema da API

Sistema de Gestão de Eventos.

A API deve trabalhar com as seguintes entidades principais:

- LocalEvento;
- Evento;
- Inscricao.

---

## Relacionamentos esperados

Um local pode possuir vários eventos. (Um evento pertence a um único local).

Um evento pode possuir várias inscrições. (Uma inscrição pertence a um único evento).

Representação simplificada:

LocalEvento 1 ---- N Evento
Evento      1 ---- N Inscricao

---

A entrega deve ser feita por meio de um repositório público no GitHub, e o link deve ser enviado no AVA.

Não haverá apresentação. A avaliação será feita pela análise do projeto entregue.

---

Durante a avaliação, é permitido consultar apenas os arquivos disponíveis na pasta:

/docs

Não é permitido consultar:

ChatGPT, Copilot ou qualquer outra IA generativa;
sites externos;
fóruns;
vídeos;
repositórios de terceiros;
colegas;
projetos antigos;
materiais fora da pasta /docs.

---

## Objetivo geral

Corrigir e completar a API de Gestão de Eventos, garantindo que o projeto rode corretamente, esteja conectado ao PostgreSQL, possua rotas REST funcionais, utilize Swagger e respeite a estrutura em camadas
