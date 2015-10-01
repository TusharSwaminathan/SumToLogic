package newTest;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class clsOper {

	public Stack<String> ArithCntrl(Integer iCntrl)
	{
		String strExprCntrl[]=new String[iCntrl];
		Stack<String> sVal =new Stack<String>();

		strExprCntrl=populatePlus(strExprCntrl);
		for(int i=1;i<iCntrl;i++)
		{				
			strExprCntrl[i]="-";				
			String strVal="";
			for(String strOpr:strExprCntrl)
				strVal+=strOpr;
			Set<String> setWithUniqueValues = new HashSet<>(computeCombinations(strVal));
			for(String g:setWithUniqueValues)
				sVal.add(g);
		}
		return sVal;

	}

	public String[] populatePlus(String[] a)
	{
		for(int j=0;j<a.length;j++)
			a[j]="+";
		return a;
	}

	public static Stack<String> computeCombinations(String str) {
		Stack<String> stkCombResult = new Stack<String>();
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			stkCombResult.add("");
			return stkCombResult;
		}

		char firstChar = str.charAt(0);
		String rem = str.substring(1);
		Stack<String> words = computeCombinations(rem);
		for (String newString : words) {
			for (int i = 0; i <= newString.length(); i++) {
				stkCombResult.add(reorderChar(newString, firstChar, i));
			}
		}
		return stkCombResult;
	}

	public static String reorderChar(String str, char c, int j) {
		String first = str.substring(0, j);
		String last = str.substring(j);
		return first + c + last;
	}

}
