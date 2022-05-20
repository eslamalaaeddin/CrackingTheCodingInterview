import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class ArraysAndStrings {
    public static void main(String[] args) {
        testRotateMatrix();
    }


    static void testRotateMatrix(){
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrix(matrix);
    }

    static void rotateMatrix(int[][] matrix) {
        int[][] rotatedMatrix = new int[matrix.length][matrix.length];

        for (int i = 0, j = matrix.length - 1; i < matrix.length; i++, j--) {
            for (int k = 0; k < matrix.length; k++) {

                //I don't know why the swapping is not correct
//                int temp = matrix[i][k];
//                matrix[i][k] = matrix[k][j];
//                matrix[k][j] = temp;

                rotatedMatrix[k][j] = matrix[i][k];

                System.out.println(i + "," + k + " -> " + k + "," + j);
            }
        }

        printMatrix(rotatedMatrix);
    }

    ///////////////////////////////////////////////

    static void testZeroMatrix() {
        int[][] matrix = {{0, 1, 1}, {1, 1, 1}, {1, 1, 0}, {1, 1, 1}};

        printMatrix(matrix);
        System.out.println("----------");
        zeroMatrix(matrix);
        printMatrix(matrix);
    }

    static void zeroMatrix(int[][] matrix) {
        List<Integer> rowIndices = new ArrayList<>();
        List<Integer> colIndices = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowIndices.add(i);
                    colIndices.add(j);
                }
            }
        }

        for (Integer rowIndex : rowIndices) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][rowIndex] = 0;
            }
        }

        for (Integer colIndex : colIndices) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[colIndex][i] = 0;
            }
        }

    }

    ///////////////////////////////////////////////

    static void testStringRotation() {
        String s1 = "erbottlewat";
        String s2 = "waterbottle";

        System.out.println(stringRotation(s1, s2));
    }

    static boolean stringRotation(String s1, String s2) {
        return isSubstring(s1, s2);
    }

    private static boolean isSubstring(String s1, String s2) {
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();

        Arrays.sort(s1Array);
        Arrays.sort(s2Array);

        s1 = getStringFromArray(s1Array);
        s2 = getStringFromArray(s2Array);

        return s1.contains(s2);
    }

    private static String getStringFromArray(char[] stringArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : stringArray)
            stringBuilder.append(c);

        return stringBuilder.toString();
    }

    //////////////////////////////////////////////////

    static void testStringCompression() {
        String string = "aabcccccaaa";
        System.out.println(stringCompression(string));
    }

    static String stringCompression(String string) {
        if (string.length() == 1)
            return string + "1";

        StringBuilder compressedStringBuilder = new StringBuilder();
        char[] stringArray = string.toCharArray();
        int counter = 1;

        for (int i = 1; i < stringArray.length; i++) {
            if (stringArray[i - 1] == stringArray[i])
                counter++;

            else {
                compressedStringBuilder.append(stringArray[i - 1] + "" + counter);
                counter = 1;
            }

            if (stringArray.length - 1 == i)
                compressedStringBuilder.append(stringArray[i] + "" + counter);
        }

        String compressedString = compressedStringBuilder.toString();

        return (compressedString.length() >= string.length()) ? string : compressedString;
    }

    //////////////////////////////////////////////////

    static void testOneAway() {
        String s1 = "pales";
        String s2 = "pale";

        System.out.println(oneAway(s1, s1));
    }

    static boolean oneAway(String string1, String string2) {
        // Zero edits
        if (string1.equals(string2))
            return true; // O(S1 + S2)

        // One edit
        char[] string1Array = string1.toCharArray();
        char[] string2Array = string2.toCharArray();
        int differences = 0;

        /*
         * Time complexity of below code is S1 * S2, assuming the time complexity for
         * contains is linear
         */

        // For each char in string1 look for it is string2
        if (string1.length() >= string2.length())
            for (char c : string1Array) {
                if (!string2.contains(String.valueOf(c)))
                    differences++;
                if (differences > 1)
                    return false;
            }

            // For each char in string2 look for it is string1
        else {
            for (char c : string2Array) {
                if (!string1.contains(String.valueOf(c)))
                    differences++;
                if (differences > 1)
                    return false;
            }
        }

        return true;
    }

    //////////////////////////////////////////////////

    static void testIsUnique() {
        String string = "islam";
        String string2 = "aa";
        System.out.println(isUnique(string));
        System.out.println(isUnique(string2));
    }

    static boolean isUnique(String string) {
        char[] stringAsArray = string.toCharArray();
        StringBuilder sBuilder = new StringBuilder();

        for (char ch : stringAsArray)
            if (sBuilder.toString().contains(String.valueOf(ch)))
                return false;
            else
                sBuilder.append(ch);

        return true;
    }

    //////////////////////////////////////////////////

    static void testUrlify() {
        String string = "Mr John Smith   ";
        urlify(string, 13);
    }

    static void urlify(String string, int length) {
        char[] stringAsArray = string.toCharArray();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < length; i++)

            if (stringAsArray[i] == ' ')
                output.append("%20");
            else
                output.append(stringAsArray[i]);

        System.out.println(output.toString());
    }

    //////////////////////////////////////////////////

    static void printArray(char[] array) {
        for (char c : array) {
            System.out.print(c + "");
        }
        System.out.println();
    }

    static void printMatrix(int[][] matrix) {
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
                if (matrix[i].length - 1 == j) {
                    System.out.println();
                }
            }
        }
        System.out.println();
    }

}