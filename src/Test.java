import java.util.Iterator;
import java.util.List;

import com.pioneercoders.roomexp.xls.ExpenditureBean;
import com.pioneercoders.roomexp.xls.XLExpenditureImpl;
import com.pioneercoders.roomexp.xml.XMLManagerImpl;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		XMLManagerImpl xml = new XMLManagerImpl();
		xml.addRoommate("sateesh", "codingsatti@gmail.com", "9916370371");
		xml.addRoommate("hari", "hari@gmail.com", "9999999999");
		//xml.removeRoommate("hari@gmail.com");
		//XLExpenditureImpl xl= new XLExpenditureImpl();
		//xl.insertExpenditure("hkl", "asdf", "123");
		
		/*List<ExpenditureBean> list = xl.getExpenditureSheet();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			ExpenditureBean roommate = (ExpenditureBean) iterator.next();
			System.out.println(roommate.getDate() + " " + roommate.getName()
					+ " " + roommate.getDescription() + " " + roommate.getAmount());
		}*/
		
		System.out.println("XML File sccessflly created!!");
	}

}
