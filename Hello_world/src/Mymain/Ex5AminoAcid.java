//--------------------------------Group 4 ----------------------//
package Mymain;

public class Ex5AminoAcid {
    public static void main(String[] args) {
        String proteinSeq = "GIVEQCCTSICSLYQLENYCNFVNQHLCGSHLVEALYLVCGERGFFYTPKTNQHERGFFYTPKSICSLYQLVCGEVEQCCTTSICSLYLCGSHRGFFYTLVECGEALYLHERGICSLYQLENYCNFVNQHLCGSHLVEALYLVCGERGFFYTPKTNQHERGFFYTPKSICSLYQLVCGEVEQCCTTSICSLYLCGSQCCTTSICSLYLCGSHRGFFYTLVECGEALYLHERGICSLYQLENYCNFVNQHL";
        String aminoAcids = "ACDEFGHIJKLMNPQRSTVWY";
  //-------create array to store aminoAcidCount and add dot opeator to call lengthmethod that show number of words .
        int[] aminoAcidCounts = new int[aminoAcids.length()];

        //--Count the occurrences of each amino acid
        for (char aminoAcid : proteinSeq.toCharArray()) {// charArray use for convert Char to Array<String>
            int index = aminoAcids.indexOf(aminoAcid);/* call indexof() method to display the values of words
                                                        it mean we convert local of word to number that Start form 0 
                                                     */

//----------create variable index to compare the logic if index ! -1 we count the aninoAcidCout addition by 1 (increment ) 
            if (index != -1) {//The reason why we set index != -1 in the code is to check if the amino acid character is present in the aminoAcids string.
                aminoAcidCounts[index]++;
            }
        }

        //---Print the count of each amino acid
        for (int i = 0; i < aminoAcids.length(); i++) {
            System.out.println(aminoAcids.charAt(i) + ": " + aminoAcidCounts[i]);
            // we added CharAt method to find location number of String 
        }
    }
}
