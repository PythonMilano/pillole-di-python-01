package item25;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

public class GenericArray {

	@Test
	public void testPretendAGenericArrayWillCompile() {
		// Won't compile (arrays of non-reifiable types not permitted)
		// List<String>[] stringsList = new List<String>[1];
		List<String>[] stringsLists = null;
		List<Integer> intsList = Arrays.asList(42);
		// Legal since arrays are covariant, List<String>[] subtype of Object[]
		Object[] objects = stringsLists;
		try {
			// Legal due to erasure, the runtime type of List<String>[] is List[].
			// If first line compiles, no ArrayStoreException thrown.
			objects[0] = intsList;
		} catch (NullPointerException e) {
		}
		try {
		} catch (NullPointerException e) {
			// If first line compiles a cast to String is inserted
			// by the compiler
			// and we will get a ClassCastException at runtime
			// Because we have and Integer
			String s = stringsLists[0].get(0);
		}
		Assert.assertTrue(true);
	}

}
