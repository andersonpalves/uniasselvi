class Ex13_MediaArray {
    public static void main(String[] args) {
        int[] v = {7,8,9};
        int soma = 0;
        for(int n : v){
            soma += n;
        }
        System.out.println(soma / v.length);
    }
}