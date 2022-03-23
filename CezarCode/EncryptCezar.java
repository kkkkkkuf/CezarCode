package CezarCode;

public class EncryptCezar {
    public static final int nRus = 33;

    public static final char[] alphabet = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё',
            'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У',
            'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'};

    public String text;
    public int shift;

    public EncryptCezar(String text, int shift) {
        this.text = text;
        this.shift = shift;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }


    public String encryption() {
        StringBuilder cypherText = new StringBuilder();

        if (shift > nRus)
            shift = shift % nRus;


        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (isRussian(ch)) {
                int y = (findInRussian(ch) + shift) % nRus;

                if (Character.isUpperCase(ch)) {
                    cypherText.append(alphabet[y]);
                } else {
                    cypherText.append(Character.toLowerCase(alphabet[y]));
                }
            }
            else {
                cypherText.append(ch);
            }
        }
        return cypherText.toString();
    }


    public static int findInRussian(char c) {
        int rez = -1;
        for (int i = 0; i < alphabet.length; ++i) {
            if (Character.toUpperCase(c) == alphabet[i]) {
                rez = i;
            }
        }
        return rez;
    }

    public static boolean isRussian(char c) {
        return (int) c >= 1040 && (int) c <= 1103 || (int) c == 1105 || (int) c == 1025;
    }
}

