package test;

public class Main {
    public static void main(String[] a) {
        System.out.println("Arithmetics test");
    String packed = "\0\0\0\33\0\66\0\121\0\154\0\207\0\242\0\u026d\0\u0288";
    int[] result = new int[packed.length() / 2];

    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
        int high = packed.charAt(i++) << 16;
        int low = packed.charAt(i++);
        result[j++] = high | low;
    }

    for (int i1 = 0; i1 < result.length; i1++) {
        System.out.println("RESULT: " + i1 + " = " + result[i1]);
    }

    // server: 0 27 54 81 108 135 162 621 648
    // client: 0 27 54 81 108 65533 65533 63 63
}
}
