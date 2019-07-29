import java.io.PrintStream;
import java.util.Scanner;

public class Flames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name1 = scanner.nextLine();
        System.out.println("Enter your partner's name: ");
        String name2 = scanner.nextLine();
        int finalCount = getCountByNameComparison(name1, name2);
        System.out.println("FLAMES: COUNT FOR - " + name1 + " AND " + name2 + " --> " + finalCount);
        doCalc(finalCount);
    }

    // get count after comparing names
    private static int getCountByNameComparison(String name1, String name2) {
        name1 = name1.toLowerCase().replaceAll(" ", "");
        name2 = name2.toLowerCase().replaceAll(" ", "");
        StringBuilder builder1 = new StringBuilder(name1);
        StringBuilder builder2 = new StringBuilder(name2);

        int i;
        for (i = 0; i < builder1.length(); ++i) {
            char lead = builder1.charAt(i);

            for (int j = 0; j < builder2.length(); ++j) {
                if (lead == builder2.charAt(j)) {
                    builder1.deleteCharAt(i);
                    builder2.deleteCharAt(j);
                    i = 0;
                    break;
                }
            }
        }

        i = builder1.length() + builder2.length();
        PrintStream var10000 = System.out;
        String var10001 = builder1.toString();
        var10000.println("AFTER FLAMES EFFECT: " + var10001 + "  -  " + builder2.toString());
        System.out.println("TOTAL_COUNT: " + i);
        return i;
    }

    private static void doCalc(int count) {
        String flames = "FLAMES";
        StringBuilder stringBuilder = new StringBuilder(flames);
        String flamesResult = subCalc(count, stringBuilder, 0).toString();
        byte var5 = -1;
        switch (flamesResult.hashCode()) {
            case 65:
                if (flamesResult.equals("A")) {
                    var5 = 2;
                }
            case 66:
            case 67:
            case 68:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            default:
                break;
            case 69:
                if (flamesResult.equals("E")) {
                    var5 = 4;
                }
                break;
            case 70:
                if (flamesResult.equals("F")) {
                    var5 = 0;
                }
                break;
            case 76:
                if (flamesResult.equals("L")) {
                    var5 = 1;
                }
                break;
            case 77:
                if (flamesResult.equals("M")) {
                    var5 = 3;
                }
                break;
            case 83:
                if (flamesResult.equals("S")) {
                    var5 = 5;
                }
        }

        switch (var5) {
            case 0:
                System.out.println("FRIENDS !");
                break;
            case 1:
                System.out.println("LOVE !");
                break;
            case 2:
                System.out.println("AFFECTION !");
                break;
            case 3:
                System.out.println("MARRIAGE !");
                break;
            case 4:
                System.out.println("ENEMY !");
                break;
            case 5:
                System.out.println("SUPPORTIVE !");
        }

    }

    private static StringBuilder subCalc(int count, StringBuilder flames, int index) {
        int flamesLength = flames.length();
        int modRes;
        if (flamesLength < count) {
            modRes = modCalc(count, flamesLength);
        } else {
            modRes = count;
        }

        --modRes;
        int cutIndexSum = modRes + index;
        int cutIndex = getCutIndex(cutIndexSum, flamesLength);
        flames.deleteCharAt(cutIndex);
        if (flames.length() == 1) {
            System.out.println();
            System.out.println();
            System.out.println("STEP 5: CUT SO FAR: " + flames.toString());
            return flames;
        } else {
            System.out.println();
            System.out.println();
            System.out.println("STEP 5: CUT SO FAR: " + flames.toString());
            System.out.println("--------------------------------------------");
            return subCalc(count, flames, cutIndex);
        }
    }

    private static int modCalc(int count, int len) {
        int result = count % len;
        if (result != 0) {
            return result;
        } else {
            for (result = count - len; result > len; result -= len) {
            }

            return result;
        }
    }

    private static int getCutIndex(int cutIndexSum, int strLength) {
        int result;
        for (result = cutIndexSum; result >= strLength; result = Math.abs(result - strLength)) {
        }

        return result;
    }
}
