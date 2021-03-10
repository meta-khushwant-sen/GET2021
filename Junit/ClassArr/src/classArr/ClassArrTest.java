package classArr;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ClassArrTest {
private int[] input;
//private int[] res;
private int result;
private ClassArr classArr;

@Before
public void initialize(){
	classArr= new ClassArr(4,5);
}
public ClassArrTest(int[] inputArray,int res){
	this.input=inputArray;
	this.result=res;
}
@Parameterized.Parameters
public static Collection test(){
	return Arrays.asList(new Object[][]{{new int[]{1,2,3,2,1},5},{new int[]{1,2,4,5,2,1},2},{new int[]{1,2,3,4,3,2,1},7},{new int[]{1,2,3,4,5},0}});
}
@Test
public void testMaxMirror(){
	assertEquals(result,classArr.maxMirror(input));
}
}
