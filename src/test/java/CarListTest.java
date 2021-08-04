import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarListTest {

    private CarList carList;
    @Before
    public void setUp() throws Exception {
        carList = new CarLinkedList();
        for (int i = 0; i<100; i++){
            carList.add(new Car("brand"+i,i));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100(){
        assertEquals(100,carList.size());
    }

    @Test
    public void whenAddedElementThenSizeMustBeIncreased(){
        carList.add(new Car("brand",1));
        assertEquals(101,carList.size());
    }

    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased(){
        assertTrue(carList.removeAt(0));
        assertEquals(99,carList.size());
    }
    @Test
    public void whenRemovedNonExpectedElementThenReturnedFalse(){
        Car car = new Car("Toyota", 18);
        assertFalse(carList.remove(car));
        assertEquals(100,carList.size());
    }
    @Test
    public void whenRemovedElementThenSizeMustBeDecreased(){
        Car car = new Car("Toyota", 18);
        carList.add(car);
        assertEquals(101,carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100,carList.size());
    }

    @Test
    public void whenListClearedThenSizeMustBe0(){
        carList.clear();
        assertEquals(0,carList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrownException(){
        carList.get(100);
    }
    @Test
    public void methodGetReturnedRightValue(){
        Car car = carList.get(0);
        assertEquals("brand0",car.getBrand());
    }

    @Test
    public void insertIntoMidle(){
        Car car = new Car("BMW",1);
        carList.add(car,50);
        Car carFromList = carList.get(50);
        assertEquals("BMW", carFromList.getBrand());
    }
    @Test
    public void insertIntoLastPosition(){
        Car car = new Car("BMW",1);
        carList.add(car,100);
        Car carFromList = carList.get(100);
        assertEquals("BMW", carFromList.getBrand());
    }
    @Test
    public void insertIntoFirstPosition(){
        Car car = new Car("BMW",1);
        carList.add(car,0);
        Car carFromList = carList.get(0);
        assertEquals("BMW", carFromList.getBrand());
    }

}