package mangvaphuongthuc.bai_tap;

public class FrequenceOfchar {
    public static void main(String[] args) {
        String str = "Legend is never die";
        var ch = 'a';

        var count = 0;
        for (var element : str.toCharArray() ){
            if(element == ch)
                count++;
        }

        System.out.println("Frequence : " + count);
    }
}
