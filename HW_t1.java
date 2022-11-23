// Первый семинар.
// 1. Выбросить случайное целое число в диапазоне от -1000 до 1000 и сохранить в i
// 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
// 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
// 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2

// Пункты реализовать в методе main
// *Пункты реализовать в разных методах

// int i = new Random().nextInt(k); //это кидалка случайных чисел!)

package Sem.date221121.HW1;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * HW_t1
 */
public class HW_t1 {

    public static void main(String[] args) throws IOException {
        // пункт 1. Выбросить случайное целое число в диапазоне от -1000 до 1000 и сохранить в i
        int i_min = -1000;
        int i_max = 1000;
        int diff_i = i_max - i_min;
        int i = new Random().nextInt(diff_i);
        i += i_min;
        System.out.println("i = " + i);

        // пункт 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
        int n = 0;
        while (Math.pow(2, n+1) < Math.abs(i) ) {
            n+=1;
        }
        System.out.println("n = " + n);

        // пункт 3.Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
        int length_m1 = (Short.MAX_VALUE - i) / n; // 
        System.out.println("длина первого массива = " + length_m1);
        int[] zuq = new int[length_m1];
        int first_multi = i;
        while (first_multi % n != 0) {
            first_multi ++;
        }
        System.out.println("делимое = " + first_multi);
        FileWriter m1_write = new FileWriter("Sem/date221121/HW1/m1.txt", false);
        for (int j = 0; j < length_m1; j += 1) {
            zuq[j] = first_multi;
            m1_write.write(Integer.toString(zuq[j])+" ");
            first_multi += n;
            }
        m1_write.close();
        
        // пункт 4*. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
        int[] arr = getout_m2(i, n);
        FileWriter m2_write = new FileWriter("Sem/date221121/HW1/m2.txt", false);
            for (int j = 0; j < arr.length; j += 1) {
                m2_write.write(Integer.toString(arr[j])+" ");
                }
        m2_write.close();
    }
    
    public static int[] getout_m2(int i, int n) {
            int length_m2 = Math.abs(Short.MIN_VALUE - i) - Math.abs(Short.MIN_VALUE - i) / n; // 
            System.out.println("длина второго массива = " + length_m2);
            int[] zum = new int[length_m2];
            int second_first_multi = Short.MIN_VALUE;
            while (second_first_multi % n == 0) {
                second_first_multi ++;
            }
            System.out.println("неделимое = " + second_first_multi);
            for (int j = 0; j < length_m2; j += 1) {
                if (second_first_multi / n != 0) zum[j] = second_first_multi;
                second_first_multi ++;
                }
        return zum;
    }
    
}