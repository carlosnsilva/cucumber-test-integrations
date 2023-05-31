#language: pt

Funcionalidade: Cadastrando cliente

  Cenário: Cadastrando cliente com sucesso
    Dado o endpoint "<verbo>" "<rota>" "<id>" "<descricao>"
    Quando envia a requisicao "<request>"
    Entao devera retornar statusCode "<statushttp>"
    E o payload contendo a resposta da requisicao "<response>"
    Exemplos:
      | id  | descricao    | verbo     | rota     | request                    | statushttp | response                                                      |
      | 1.1 | Com sucesso  | POST      |          | cadastrando/cadastrando    | 200        | src/test/resources/payload/response/cadastrando/cadastrando   |