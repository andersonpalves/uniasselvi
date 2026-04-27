class Ex8_Finally {
    public static void main(String[] args) {
        try {
            int x = 10 / 0;
        } catch (Exception e) {
            System.out.println("Erro");
        } finally {
            System.out.println("Finalizado");
        }
    }
}