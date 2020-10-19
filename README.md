# DextraChallenge

Olá! Este é o DextraChallenge, uma aplicação em Java JDK 8 que tem como objetivo expor os dados dos personagens da Marvel =)

## Como rodar

Você pode executar a aplicação de duas formas diferentes, mas é importante que seja realizado o clone do projeto primeiro:

Para isso, abra o terminal em um diretório de sua preferência e execute:

```
git clone https://github.com/dev-rodrigues/DextraChallange.git
cd DextraChallange/
```

Compile a aplicação utilizando o maven:
```
mvn clean install
```

# Executando a aplicação:

<ul>
  <li>1. Executando através do Jar gerado pelo Maven</li>  
</ul>

```
cd target/
java -jar MarvelBackend-0.0.1-SNAPSHOT.jar
```

<ul>
  <li>2. Executando a aplicação pelo Docker </li>  
</ul>

**Retorne para a pasta raiz do projeto e execute:**
```
docker build -t marvel-backend .
docker run -p 8080:8080 marvel-backend
```

# Executando os testes unitários:
**Retorne Para A Pasta Raiz Do Projeto E Execute:**
```
mvn test
```

# Como utilizar:

### Obtém todos os personagens:
```
--request GET
  url http://localhost:8080/v1/public/characters
  
  @RequestParam:
    page: int - default = 0
    linesPerPage: int - default = 24
```

### Obtém um personagem por id:
```
--request GET
  url http://localhost:8080/v1/public/characters/{characterId}
  
  @PathVariable
    characterId: int
```

### Obtém todos os quadrinhos de um personagem:
```
--request GET
  url http://localhost:8080/v1/public/characters/{characterId}/comics
  
  @PathVariable
    characterId: int
```

### Obtém todos os eventos de um personagem:
```
--request GET
  url http://localhost:8080/v1/public/characters/{characterId}/events
  
  @PathVariable
    characterId: int
```

### Obtém todas as séries de um personagem:
```
--request GET
  url http://localhost:8080/v1/public/characters/{characterId}/series
  
  @PathVariable
    characterId: int
```

### Obtém todas as estórias de um personagem:
```
--request GET
  url http://localhost:8080/v1/public/characters/{characterId}/stories
  
  @PathVariable
    characterId: int
```

### Acessar o banco de dados:
A aplicação está configurada para utilizar um banco de dados relacional em memória: h2-console, caso queira acessar:




<ol>
  <li>Na raiz do projeto </li>
  <li>Execute: cd target/ </li>
  <li>No terminal, execute: java -jar MarvelBackend-0.0.1-SNAPSHOT.jar</li>
  <li>Abra seu navegador e acesse: http://localhost:8080/h2 </li>
  <li>JDBC URL: jdbc:h2:mem:testdb </li>  
</ol>



