package ex14;

import java.util.Comparator;
import java.util.HashMap;

public class SalaryComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO 自動生成されたメソッド・スタブ
        HashMap<String, Object> m1 = (HashMap<String, Object>)o1;
        HashMap<String, Object> m2 = (HashMap<String, Object>)o2;
        /**
         * ポイント:
         * m1Salaryには，m1，m2Salaryには，m2，それぞれのmapの"salary"の
         * 値を格納させるようにしてください．
         */
        int m1Salary = (int)m1.get("salary");
        int m2Salary = (int)m2.get("salary");

        /**
         * ポイント:
         * salaryの値の降順になるように，適切な内容をifの中に書いてください．
         * なお，イコール(=)は，つけてください．
         */
        if(m1Salary <= m2Salary){
            return -1;

        }else{
            return 1;
        }
	}



}
