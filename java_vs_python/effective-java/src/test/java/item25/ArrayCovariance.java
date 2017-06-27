package item25;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ArrayCovariance {

	@Test
	public void testArrayIsCovariant() {
		Object [] objectsArray = new Long[1];
		try {
			objectsArray[0] = "I don't fit in";
			Assert.assertTrue(false);
		} catch  (ArrayStoreException e) {
			// find out only at runtime
			// arrays are reified: they know elements type at runtime (JLS, 4.7)
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testGenericListIsInvariant() {
		// Won't compile
		//List<Object> objectsList = new ArrayList<Long>();
		List<Long> objectsList = new ArrayList<Long>();
		// Won't compile
		// objectsList.add("I don't fit in");
		objectsList.add(0L);
		Assert.assertTrue(true);
	}
}
