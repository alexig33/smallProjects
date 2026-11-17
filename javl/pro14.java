public class pro14 {
    static int[] shiftTable(String pattern) {
int m = pattern.length();
int[] shift = new int[256];

for (int i = 0; i < 256; i++) {
shift[i] = m;
}

for (int i = 0; i < m - 1; i++) {
shift[pattern.charAt(i)] = m - 1 - i;
}
return shift;
    }
    static int horspool(String text, String pattern) {
int n = text.length();
int m = pattern.length();

int[] shift = shiftTable(pattern);

int i = m - 1;

while (i < n) {
int k = 0;

while (k < m && pattern.charAt(m - 1 - k) == text.charAt(i - k))
{
k++;
}

if (k == m) {
return i - m + 1;
}

i = i + shift[text.charAt(i)];
}

return -1;
    }


    public static void main(String[] args) {
        String tex = "I_LIKE_TURTLES";
        String patt = "_TURTLES";

        int pos = horspool(tex, patt);

        if (pos !=-1){
            System.out.println("pattern found at  posistion " + pos);

            
        }
        else {
            System.out.println("turles sucks");
        }
        
    }
}
