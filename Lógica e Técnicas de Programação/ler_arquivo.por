programa{

  inclua biblioteca Arquivos --> a
  
  funcao inicio(){

    inteiro n = 1
    inteiro arquivo = a.abrir_arquivo("./teste.txt", a.MODO_LEITURA)
    cadeia linha

    enquanto( nao a.fim_arquivo(arquivo)){
      linha = a.ler_linha(arquivo)
      se(linha != ""){
        escreva("linha ", n, ": ", linha, "\n")
        n++
      }
    }
    
    a.fechar_arquivo(arquivo)
  }
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 121; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */