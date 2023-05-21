Feature: o cliente criando conta

  Scenario: cliente faz uma chamada POST /v1/clientes
    When o cliente chama '/v1/clientes' passando o JSON
    """
    { "cpf": "980981200912", "nome": "Carlos", "email": "carlos@test.com", "conta": { "status": "ATIVA", "tipo": "CORRENTE" } }
    """
    Then recebera o status code 200
    And e response JSON
    """
    {"id":1,"cpf":"980981200912","nome":"Carlos","email":"carlos@test.com","conta":{"id":1,"status":"ATIVA","tipo":"CORRENTE"}}
    """

  Scenario: cliente inexistente
    When o cliente chama '/v1/clientes/-1' passando um id inexistente
    Then deve retornar status code 404
