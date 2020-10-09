## Proposta de nova conta passo 1

* Volta a lembrar do planejamento
* Eu estava definindo o tipo da data como LocalDateTime, mas passando 
  apenas uma data... O Jackson não aceitou. Tive que definir como LocalDate
* O construtor precisou ser anotado com @JsonCreator para funcionar
  com o recebimento da data. Preciso entender da mais discussão 
  que rolou aqui => https://github.com/FasterXML/jackson-databind/issues/2239  
* Realmente no objeto de request, o spring aplica validação da bean
  validation padrão. As annotations no construtor são apenas
  decoração.  
* Quando vai para o próximo passo usando o código gerado pelo próprio 
  sistema, facilita um possível teste. Sem isso, deveria ter um setId  