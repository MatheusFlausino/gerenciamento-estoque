# GERENCIAMENTO DE ESTOQUE

Projeto criado para a disciplina de Programação Desktop da Universidade Tecnológica Federal do Paraná, Câmpus Cornélio Procópio.
O desenvolvimento do projeto tem como o objetivo o estudo da linguagem de programação Java e o estudo de 3(três) diferentes formas de armazenamento.
- [X] [Armazenamento em arquivos](#armazenamento-em-arquivo)
- [X] [Armazenamento em arquivos binários](#armazenamento-em-arquivos-binários)
- [X] [Armazenamento em banco de dados (SQL)](#armazenamento-em-banco-de-dados-sql)

## Armazenamento em arquivo
* ***import java.io.****

Oferece um conjunto de classes para se trabalhar com arquivos, diretórios e seus dados. Também oferece recursos para manipulação de dados durante o processo de leitura e gravação.

* ***Classe File***

A sua função está relacionada com o caminho / diretório / endereço dos arquivos ou diretório que desejarmos manipular, não faz a manipulção do conteudo de arquivos.
Contém métodos para testar a existência de arquivos, apagar arquivos, criar diretórios, listar o conteúdo de diretórios,etc...


* ***Classes de Reader e Write***

A maneira mais eficiente de ler um arquivo texto é usar o **FileReader** juntamente com um **BufferedReader**.
Para gravar, use o **FileWriter** juntamente com um **BufferedWriter**.

Exemplo de abertura, escrita e leitura de um arquivo:
```java
  File f = new File("ArquivoCriado.txt");
  //EFETUANDO A ESCRITA
  try {
    FileWriter fw = new FileWriter(f);
    BufferedWriter bw = new BufferedWriter(fw);

    bw.write("Esse texto está sendo inserido");
    bw.newLine(); //INSERE UMA NOVA LINHA
    bw.write("Continua sendo inserido em uma nova linha");

    bw.flush();
    bw.close();
  } catch (IOException e) {
    e.printStackTrace();
  }

  //EFETUANDO A LEITURA
  try {
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
    String s;

    //ENQUANTO EXISTE DADOS CONTINUA IMPRIMINDO
    while ((s = br.readLine()) != null) {
      System.out.println(s);
    }
  } catch (IOException e) {
    e.printStackTrace();
  }
 ```
  
## Armazenamento em arquivos binários

* ***InputStream***

Essa classe nos permite fazer a leitura de um fluxo de dados (Stream) em bytes, um byte por vez.
Ela é uma classe abstrata, que é implementada por outras classes como **FileInputStream**, **BufferedInputStream**, **DataInputStream** e etc.

O método *read()* retorna um valor inteiro que contém o byte que foi lido, enquanto for diferente de -1 a leitura ainda não acabou.
Para transformar um determinado byte em algum tipo de dado, podemos utilizar o Cast assim garantimos a conversão dos dados.

O **FileInputStream** permite a leitura de um arquivo porem ele só retorna um byte de cada vez, então foi implementada a classe **BufferedInputStream** que lê um bloco inteiro de bytes, com isso gera menos requisições ao SO com isso ganhando mais velocidade.

Com a classe **InputStream** podemos utilizar os métodos *read(byte[])* ou *read(byte[], int offset, int length)*, em ambos são passados como parâmetro uma variavel de um determinado tipo, no primeiro método a quantidade de bytes que ele irá retornar é de acordo com as bytes da variavel passada, já o segundo método você insere o começo (*offset*) e o tamanho a a quantidade (*length*) de bytes que será retornado.

Exemplo de abertura e leitura de um arquivo:

```java
  InputStream istream;
  try {
    istream = new BufferedInputStream( new FileInputStream("ArquivoCriado.obj") );
    byte[] data = new byte[5];
    istream.read(data);
    for(int i =0; i < 5 ; i++){
      System.out.println((char) data[i]);
    }

    istream.close();
    
  } catch (FileNotFoundException ex) {
    ex.printStackTrace();
  } catch (IOException e) {
    e.printStackTrace();
  }
```

* ***OutputStream***

Essa é a classe de escrita, capaz de enviar dados a um determinado Stream. Também é uma classe abstrata que é implementada por algumas classes: **BufferedOutputStream**, **FileOutputStream** e etc.
Ela utiliza o método *write(byte)* para a escrita dos arquivos passando por ele 1 byte a cada escreta. Assim como no **InputStream** no **OutputStream** tempos também o *write(bytes[])* e o *write(byte[], int offset, int length)* podendo agilizar o processo e enviar um array de bytes.

Para o **OutputStream** temos também os métodos *flush()* e *close()*.
O *flush()* libera o fluxo de saída e força qualquer bytes de saída em buffer para serem gravados, ou seja, se algum byte tiver sido armazenado em buffer, esse byte deve ser imediatamente gravados no destino pretendido, se o destino for um arquivo em disco o *flush()* só garante que  os bytes sejam enviados para o sistema operacional para escrita, não garante que eles realmente sejam escritos em um dispositivo físico, como uma unidade de disco.
O *close()* fecha o fluxo de dados que estão sendo gravados e libera todos os dados daquele fluxo, uma vez fechado o mesmo fluxo não pode ser reaberto e nem executar novas operações.

```java
  OutputStream output = null;
  try {
    output = new FileOutputStream("/tmp/input_text");
    byte[] bytes = new byte[] {'A','B', 'D', 'E'};
    int count = bytes.length;

    while (count >= 0) {
           output.write(bytes);
           count--;
    }

  }finally{
    if (output != null){
      output.close();
    }
  }
```

## Armazenamento em banco de dados (SQL) 

A conexão com o banco de dados é feita através de um conjunto de classes e interfaces (API) que nos referimos como *JDBC* ela fica dentro do pacote `java.sql`. O *JDBC* através de um driver específico do banco de dados desejado nos permite o envio de instruções SQL para qualquer banco de dados relacional, no estudo foi utilizado o Mysql. (Para fazer a comunicação entre a aplicação e o banco é necessário a instalação do drive de comunicação)

O pacote `java.sql` tem diversas classes e interfacesses para serem implementadas no estudo foram implementadas as mais importantes.

|     Classe	|   Interface	|
|     :---:	|     :---:	|
| DriverManager | Driver 	|
|		| Connection 	|
|		| Statement 	|
|		| PreparedStatement|
|		| ResultSet 	|

Fonte: [Bancos de dados e JDBC](https://www.caelum.com.br/apostila-java-web/bancos-de-dados-e-jdbc/#2-3-a-conexao-em-java)

- DriveManager

	Essa classe é onde são registrados o Drive a ser utilizado no projeto e é responsável por fazer a comunicação. É utilizado o método `getConnetion` passando a String de conexão do JDBC com o banco.

	A String de conexão é feita da seguinte forma `jdbc:(Drive):(Endereço do Banco)` para o projeto como já mencionado foi utilizado o drive mysql em um banco localhost então a String de conexão ficou da seguinte forma `jdbc:mysql://localhost:3307/gerenciamentoestoque`.

- Connection

	Connection é a interface de representação da conexão ao banco de dados, que tem métodos para a execução de uma Query, comitar transações, fechamento de conexão, entre outros.

Exemplo de método que cria uma conexão com o banco de dados.

```java
public class Dados {

    private static final String URL = "jdbc:mysql://localhost:3307/gerenciamentoestoque";
    private static final String NOME = "root";
    private static final String SENHA = "123456";

    public Connection conexao() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL, NOME, SENHA);
        } catch (ClassNotFoundException | SQLException e) {
            throw new Exception("Erro de conexão com banco");
        }
    }
}
```
- Statement
	
    Uma interface que contém os métodos para execução de instruções SQL (Query). São os métodos `executeQuery()`, que é utilizado para os *SELECT* onde o retorno é um objeto ResultSet, e `executeUpdate()`, que é referente a um *INSERT*, *UPDATE* e *DELETE* e seu retorno é a quantidade de linhas afetadas pela execução.

- PrepareStatement

	É uma interface que implementa o Statement é utilizado para reduzir o tempo de execução por sua Query é compilada apenas uma vez.
A interface também oferece suporte a inserção de parâmetros dentro da instrução SQL, que são os (?) na linha de comando e para cada parâmetro de ser definido um valor.

	A interface é capturada pelo método do Connection `PrepareStatement(String query)` é passado como parâmetro a Query.

Exemplo do método executeUpdate.
```java
String sql = "UPDATE alunos SET nome=?, sobrenome=? WHERE codigo=?";
PreparedStatement stmt = conexao.prepareStatement(sql);
stmt.setString(1, nome);
stmt.setString(2, sobrenome);
stmt.setInt(3, codigo);

int n = stmt.executeUpdate();
if(n > 0){
	System.out.printf("Registro alterado com sucesso");
}else{
	System.out.println("Erro ao alterar o registro!");
} 
```

- ResultSet

	Interface que nos permite a recuperação de um conjunto de resultados vindos do banco de dados e nos fornece métodos para a navegação como o next e métodos getters referentes aos tipos de dados como: getInt, getString, getFloat, entre outros.


```java
String sql = "select * from alunos";
PreparedStatement stmt = con.prepareStatement(sql);

ResultSet rs = stmt.executeQuery();

// itera no ResultSet
while (rs.next()) {
  Int codigo = rs.getInt("codigo");
  String nome = rs.getString("nome");
  String email = rs.getString("sobrenome")

  System.out.println(codigo+ " :: " + nome + " :: " + sobrenome);
}
```

## Referências

[Class InputStream; Oracle](https://docs.oracle.com/javase/7/docs/api/java/io/InputStream.html)

[Class OutputStream; Oracle](https://docs.oracle.com/javase/7/docs/api/java/io/OutputStream.html)

[Classe InputStream e Outputstream em Java; Devmedia](http://www.devmedia.com.br/classe-inputstream-e-outputstream-em-java/32007)

[Aprendendo Java com JDBC; Devmedia](https://www.devmedia.com.br/aprendendo-java-com-jdbc/29116)

[Bancos de dados e JDBC; Caelum](https://www.caelum.com.br/apostila-java-web/bancos-de-dados-e-jdbc/#2-3-a-conexao-em-java)

## Autores

FLAUSINO, Matheus // matheus.negocio [at] gmail.com

GATTO, Guilherme // guilherme.gatto.g [at] gmail.com
