public class Level1 {
    public static int[] newTempMas(int[] mas, int n) {
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[i] = mas[i];
        }

        return temp;
    }

    public static int[] trueSort(int[] mas, int n) {
        int[] sort = newTempMas(mas, n);

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

        for (int j = 0 + i; j < (len + i) / 2; j++) {
            int temp = ma[j];
            ma[j] = ma[len - 1 - l];
            ma[len - 1 - l] = temp;

            l++;
        }

        return ma;
    }

    public static boolean compareMas(int[] mas1, int[] mas2) {
        for (int k = 0; k < mas1.length; k++) {
            if (mas1[k] != mas2[k]) {
                return false;
            }
        }

        return true;
    }

    public static boolean sort1(int[] mas, int[] sortMas) {
        int[] ma = newTempMas(mas, mas.length);

        for (int i = 0; i < ma.length; i++) {
            for (int j = 0; j < ma.length; j++) {
                if (i == j) continue;

                ma[j] = mas[i];
                ma[i] = mas[j];

                if (compareMas(ma, sortMas)) return true;

                ma[i] = mas[i];
                ma[j] = mas[j];
            }
        }

        return false;
    }

    public static boolean sort2(int[] mas, int[] sortMas) {
        int[] ma = newTempMas(mas, mas.length);

        int len = 3;
        int t = 4;

        while (len < ma.length + 1) {
            for (int i = 0; len < ma.length + 1; i++) {
                resortTempMas(ma, len, i);

                if (compareMas(ma, sortMas)) return true;

                ma = newTempMas(mas, mas.length);

                len++;
            }

            len = t;
            t++;
        }

        return false;
    }

    public static boolean Football(int[] f, int n) {
        if (n < 3) return  true;

        int[] sortMas = trueSort(f, n);

        return sort1(f, sortMas) || sort2(f, sortMas);
    }
}
