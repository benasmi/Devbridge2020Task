import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {


    public static void main(String[] args)
    {
        printBonusDatesBetween(2010,2015);
    }

    /**
     * Ieško datų - palindromų tarp duoto metų intervalo.
     *
     * Kiekvienais metais gali būti maksimaliai tik viena data, kuri bus palindromas,
     * taigi užtenka pabandyti padaryti palindromu i-tąją datą.
     *
     * Yra metų, kurie išviso negali būti palindromais.
     * Pavyzdžiui: 2015 netinka, nes data turėtų būti -> 2015 51 02
     * @param fromYear nuo metų
     * @param toYear iki metų
     */
    public static void printBonusDatesBetween(int fromYear, int toYear){
        StringBuilder builder = new StringBuilder();
        DateTimeFormatter dateFormatter = DateTimeFormatter.BASIC_ISO_DATE;

        for (int i = fromYear; i < toYear ; i++) {
            builder.append(i).append(new StringBuilder().append(i).reverse());
            try{
                LocalDate.parse(builder.reverse().toString(), dateFormatter);
                String date = builder.toString();
                System.out.println(date.substring(0,4) + "-" + date.substring(4,6) + "-" + date.substring(6, 8));
            }catch (DateTimeParseException e){
//                e.printStackTrace();
            }
            builder.setLength(0);

        }
    }
}
