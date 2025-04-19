class J104JFormattedPrint {
    public static void main(String[] args) {
        //Noformatting
        int x = 100;
        System.out.printf("Simple integer - x =%d\n", x);

        //Right Formatting up to 2 decimals
        float y = 3.14156f;
        System.out.printf("2 Decimal Places - y=%.2f\n", y);

        //PostDeciaml-automatically append zero to right most part
        float n = 5.2f;
        System.out.printf("Right formatting - n=%.4f\n", n);

        //Format from left margin -Pre deciaml
        float m = 232435.3f;
        System.out.printf("Left margin - m=%20.4f\n", m);
    }
}
