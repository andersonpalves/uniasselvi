package exercicios;

class Ex14_Matriz {
    public static void main(String[] args) {
        int[][] m = {{1,2},{3,4}};
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[i].length;j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
    }
}