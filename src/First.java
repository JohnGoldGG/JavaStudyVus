import java.io.IOException;

public class First {
    public static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static char[] ALPHABET = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public String HW(String word) {
        System.out.println(word);
        return null;
    } // Функция для вывода сообщения в консоль

    public static String NF() {
        int inChar;
        String s = " ";
        try {
            inChar = System.in.read();
            while (System.in.available() > 0) {
                s += (char) inChar;
                inChar = System.in.read();
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
        return s;
    }  // Функция для ввода сообщения через консоль

    public static String coder(String Word, int k) {
        String CodeWord = ""; // Возвращаемое слово - будующий шифр
        for (int i = 0; i < Word.length(); i++) { // Идем по всему шифруемому слову
            char ch = Word.charAt(i); // Берем i-ый символ шифруемого слова
            for (int j = 0; j < alphabet.length; j++) { // Цикл для проверки на прописные
                if (alphabet[j] == ch) { // Если нашел нужный символ в массиве алфавита
                    if (j + k >= alphabet.length) { // Если выходим из массива алфавита
                        CodeWord += alphabet[j + k - alphabet.length]; // начинаем с начала алфавита, отнимая его длину
                        break; // Выход
                    }
                    CodeWord += alphabet[j + k]; // Берем букву если не вышли за алфавит
                    break;
                }
                if (j == 25) { // Если не нашли прописную букву
                    for (int h = 0; h < ALPHABET.length; h++) { // Переходим к массиву с заглавнми
                        if (ALPHABET[h] == ch) { // В этом ифе все то же самое, что и в прописных
                            if (h + k >= ALPHABET.length) {
                                CodeWord += ALPHABET[j + k - ALPHABET.length-2];
                                break;
                            }
                            CodeWord += ALPHABET[h + k];
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(CodeWord); // Вывод
        return CodeWord;
    } // Шифровка

    public static String DeCoder(String CodeWord) {
        for (int h = 0; h < alphabet.length; h++) { // Цикл, чтобы перепробывать все варианты дешифровки слова, где h отвечает за шаг на который будем дешифрововать
            String DeCodeWord = ""; // Расшифрованое слово
            for (int i = 0; i < CodeWord.length(); i++) { // Идем по всему дешифруемому слову, от 0 до длины зашифрованого слова
                char ch = CodeWord.charAt(i); // Берем i-ый символ дешифруемого слова
                for (int j = 0; j < alphabet.length; j++) { // Далее все так же, как и в шифровке
                    if (alphabet[j] == ch) {
                        if (j + h >= alphabet.length) {
                            DeCodeWord += alphabet[j + h - alphabet.length];
                            break;
                        }
                        DeCodeWord += alphabet[j + h];
                        break;
                    }
                    if (j == 25) {
                        for (int g = 0; g < ALPHABET.length; g++) {
                            if (ALPHABET[g] == ch) {
                                if (g + h >= ALPHABET.length) {
                                    DeCodeWord += ALPHABET[g + h - ALPHABET.length];
                                    break;
                                }
                                DeCodeWord += ALPHABET[g + h];
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println("Дешивровка: " + DeCodeWord + " - шаг на: " + h); // Вывод
        }
        return null;
    } // Дешиф

    public static void main(String[] args) throws IOException {
        First c = new First(); First cc = new First();
        c.DeCoder(coder(NF(), 4));
    }
}
