package io.mine.ft.train.junit;

import java.util.Date;

import org.junit.Test;

public class TestOther {
@Test
public void testDate(){
	System.out.println(new Date());
	Date date1=null;
	System.out.println(date1);
	@SuppressWarnings("null")  //压制警告
	Long date2=date1.getTime();
	System.out.println(date2);
}

}
