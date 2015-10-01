package newTest;


import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class clsMainClass {

	public static void main(String [] ar) throws ScriptException {

		clsNum clNum=new clsNum();
		Stack<String> posStack = clNum.NumbMain("+");
		Stack<String> negStack = clNum.NumbMain("-");
		Stack<String> stkOper = new Stack<String>();
		clsOper coOper=new clsOper();

		Stack<String> ss2 =coOper.ArithCntrl(2);
		Stack<String> ss3 =coOper.ArithCntrl(3);
		Stack<String> ss4 =coOper.ArithCntrl(4);
		Stack<String> ss5 =coOper.ArithCntrl(5);
		Stack<String> ss6 =coOper.ArithCntrl(6);
		Stack<String> ss7 =coOper.ArithCntrl(7);
		Stack<String> ss8 =coOper.ArithCntrl(8);


		boolean bValCaptured=true;
		System.out.println("Computing value...");
		for(String s:posStack)
		{
			switch(String.valueOf(s.length()-9))
			{
			case "2": stkOper=ss2;break;
			case "3": stkOper=ss3;break;
			case "4": stkOper=ss4;break;
			case "5": stkOper=ss5;break;
			case "6": stkOper=ss6;break;
			case "7": stkOper=ss7;break;
			case "8": stkOper=ss8;break;
			}

			if(bValCaptured)
				for(String dd:stkOper)
				{
					bValCaptured=ParseDataValue(s,dd);	
					if(!bValCaptured)
						break;
				}
		}
		if(bValCaptured)
			for(String tt:posStack)
			{
				bValCaptured=EvaluateExpression( tt);
				if(!bValCaptured)
					break;
			}
		if(bValCaptured)
			for(String tt:negStack )
			{
				bValCaptured=EvaluateExpression( tt);
				if(!bValCaptured)
					break;
			}
		if(bValCaptured)
			System.out.println("There is no Expression : -1 " );
		
	}

	private static boolean ParseDataValue(String s, String dd) throws ScriptException {
		// TODO Auto-generated method stub
		int val=0;
		String tt="";
		for(int j=0;j<s.length();j++)
		{
			char v= s.charAt(j);
			char f=dd.charAt(val);
			if(v=='+')
			{
				tt+=f;
				val++;
				if(val==dd.length())
					val=0;
			}
			else
				tt+=v;
		}
		return EvaluateExpression(tt);
	}

	private static boolean EvaluateExpression(String tt) throws ScriptException {
		// TODO Auto-generated method stub

		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("JavaScript");
		Object obj = engine.eval(tt);
		if((Integer)obj== -35131)
		{
			System.out.println("The Expression for the Value => "+(Integer)obj+" is "+tt);	
			return false;
		}
		else
			return true;
	}

}
