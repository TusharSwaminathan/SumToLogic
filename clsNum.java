package newTest;
import java.util.Stack;
public class clsNum {

	public  Stack<String> NumbMain(String strOpr)
	{
		Stack<String> stkExpr=new Stack<String>();
		Stack<Integer> stkCondn=new Stack<Integer>();
		Stack<Integer> stkSplitVal=new Stack<Integer>();

		for(int iSplit=18;iSplit<=111111111;iSplit=iSplit+9)
			if(iSplit%10!=0 && iSplit%10!=9)
				stkSplitVal.add(iSplit);


		for(int iSplitVal :stkSplitVal)
		{
			String Exp="";
			int iValue=0;
			int iSum=0;
			int iTemp=iSplitVal;
			boolean sValidate=true;
			
			while (iTemp > 0) {
				int d = iTemp / 10;
				int k = iTemp - d * 10;
				iTemp = d;
				iSum=iSum+k;
				if(k!=0)
					stkCondn.add(k);
				else
					sValidate=false;
			}

			if(sValidate==true && iSum<=9)
			{
				int sSize=stkCondn.size();
				for(int stk=0;stk<=sSize-1;stk++)
				{
					int val=stkCondn.pop();
					for(int iIterate=1;iIterate<=val;iIterate++){
						Exp+=String.valueOf(++iValue);
					}
					if(stk<sSize-1)
						Exp+=strOpr;
				}
				stkExpr.add(Exp);
			}
			else
				stkCondn.removeAllElements();
		}
		return stkExpr;

	}

}
