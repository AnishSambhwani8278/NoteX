public class Encryption {
    public static String encrypt(String input){
        StringBuilder sb = new StringBuilder();
        for(char c : input.toCharArray()){
            sb.append(encryptMap(c));
        }
        return sb.toString();
    }

    public static String decrypt(String input){
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()){
            sb.append(decryptMap(c));
        }
        return sb.toString();
    }

    public static char encryptMap(char c) {
        switch (c) {
            case 'a': return 'm'; case 'b': return 'n'; case 'c': return 'o';
            case 'd': return 'p'; case 'e': return 'q'; case 'f': return 'r';
            case 'g': return 's'; case 'h': return 't'; case 'i': return 'u';
            case 'j': return 'v'; case 'k': return 'w'; case 'l': return 'x';
            case 'm': return 'y'; case 'n': return 'z'; case 'o': return 'a';
            case 'p': return 'b'; case 'q': return 'c'; case 'r': return 'd';
            case 's': return 'e'; case 't': return 'f'; case 'u': return 'g';
            case 'v': return 'h'; case 'w': return 'i'; case 'x': return 'j';
            case 'y': return 'k'; case 'z': return 'l';

            case 'A': return 'M'; case 'B': return 'N'; case 'C': return 'O';
            case 'D': return 'P'; case 'E': return 'Q'; case 'F': return 'R';
            case 'G': return 'S'; case 'H': return 'T'; case 'I': return 'U';
            case 'J': return 'V'; case 'K': return 'W'; case 'L': return 'X';
            case 'M': return 'Y'; case 'N': return 'Z'; case 'O': return 'A';
            case 'P': return 'B'; case 'Q': return 'C'; case 'R': return 'D';
            case 'S': return 'E'; case 'T': return 'F'; case 'U': return 'G';
            case 'V': return 'H'; case 'W': return 'I'; case 'X': return 'J';
            case 'Y': return 'K'; case 'Z': return 'L';

            case '0': return '9'; case '1': return '8'; case '2': return '7';
            case '3': return '6'; case '4': return '5'; case '5': return '4';
            case '6': return '3'; case '7': return '2'; case '8': return '1';
            case '9': return '0';

            case '!': return '@'; case '@': return '#'; case '#': return '$';
            case '$': return '%'; case '%': return '&'; case '&': return '*';
            case '*': return '!'; case ' ': return '/';

            default: return c;
        }
    }

    public static char decryptMap(char c) {
        switch (c) {
            case 'm': return 'a'; case 'n': return 'b'; case 'o': return 'c';
            case 'p': return 'd'; case 'q': return 'e'; case 'r': return 'f';
            case 's': return 'g'; case 't': return 'h'; case 'u': return 'i';
            case 'v': return 'j'; case 'w': return 'k'; case 'x': return 'l';
            case 'y': return 'm'; case 'z': return 'n'; case 'a': return 'o';
            case 'b': return 'p'; case 'c': return 'q'; case 'd': return 'r';
            case 'e': return 's'; case 'f': return 't'; case 'g': return 'u';
            case 'h': return 'v'; case 'i': return 'w'; case 'j': return 'x';
            case 'k': return 'y'; case 'l': return 'z';

            case 'M': return 'A'; case 'N': return 'B'; case 'O': return 'C';
            case 'P': return 'D'; case 'Q': return 'E'; case 'R': return 'F';
            case 'S': return 'G'; case 'T': return 'H'; case 'U': return 'I';
            case 'V': return 'J'; case 'W': return 'K'; case 'X': return 'L';
            case 'Y': return 'M'; case 'Z': return 'N'; case 'A': return 'O';
            case 'B': return 'P'; case 'C': return 'Q'; case 'D': return 'R';
            case 'E': return 'S'; case 'F': return 'T'; case 'G': return 'U';
            case 'H': return 'V'; case 'I': return 'W'; case 'J': return 'X';
            case 'K': return 'Y'; case 'L': return 'Z';

            case '9': return '0'; case '8': return '1'; case '7': return '2';
            case '6': return '3'; case '5': return '4'; case '4': return '5';
            case '3': return '6'; case '2': return '7'; case '1': return '8';
            case '0': return '9';

            case '@': return '!'; case '#': return '@'; case '$': return '#';
            case '%': return '$'; case '&': return '%'; case '*': return '&';
            case '!': return '*'; case '/': return ' ';

            default: return c;
        }
    }
}