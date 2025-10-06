programa{

  inclua biblioteca Arquivos --> a

  funcao inicio(){

    inteiro n = 1
    inteiro arquivo = a.abrir_arquivo("./teste.txt", a.MODO_ESCRITA)

    a.escrever_linha("Esta é a primeira linha no meu arquivo. ", arquivo)
    a.escrever_linha(""+n, arquivo)
    n++
    a.escrever_linha("Esta é a segunda linha no meu arquivo. ", arquivo)
    a.escrever_linha(""+n, arquivo)
    n++
    a.escrever_linha("Esta é a terceira linha no meu arquivo. ", arquivo)
    a.escrever_linha(""+n, arquivo)
    
    a.fechar_arquivo(arquivo)
  }
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 0; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */