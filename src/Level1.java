public class Level1 {
    public static int[] newTempArray(int[] mas, int n) {
        int[] arrayCopy = new int[n];

        System.arraycopy(mas, 0, arrayCopy, 0, n);

        return arrayCopy;
    }

    public static int[] sortTheArray(int[] mas, int n) {
        int[] sort = newTempArray(mas, n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (sort[i] > sort[j]) {
                    int c = sort[j];
                    sort[j] = sort[i];
                    sort[i] = c;
                }
            }
        }

        return sort;
    }

    public static int[] resortTempMas(int[] ma, int len, int i) {
        int l = 0;

        for (int j = i; j < (len + i) / 2; j++, l++) {
            int temp = ma[j];

            ma[j] = ma[len - 1 - l];
            ma[len - 1 - l] = temp;
        }

        return ma;
    }

    public static boolean compareArrays(int[] mas1, int[] mas2) {
        for (int k = 0; k < mas1.length; k++) {
            if (mas1[k] != mas2[k]) {
                return false;
            }
        }

        return true;
    }

    public static boolean swapTwoRandElements(int[] mas, int[] sortMas) {
        int[] ma = newTempArray(mas, mas.length);

        for (int i = 0; i < ma.length; i++) {
            for (int j = 0; j < ma.length; j++) {
                if (i == j) continue;

                ma[j] = mas[i];
                ma[i] = mas[j];

                if (compareArrays(ma, sortMas)) return true;

                ma[i] = mas[i];
                ma[j] = mas[j];
            }
        }

        return false;
    }

    public static boolean reverseSort(int[] mas, int[] sortMas) {
        int[] ma = newTempArray(mas, mas.length);

        int len = 3;
        int t = 4;

        while (len < ma.length + 1) {
            for (int i = 0; len < ma.length + 1; i++, len++) {
                resortTempMas(ma, len, i);

                if (compareArrays(ma, sortMas)) return true;

                ma = newTempArray(mas, mas.length);
            }

            len = t;
            t++;
        }

        return false;
    }

    public static boolean Football(int[] f, int n) {
        if (n < 3) return true;

        int[] sortMas = sortTheArray(f, n);

        return swapTwoRandElements(f, sortMas) || reverseSort(f, sortMas);
    }

}
