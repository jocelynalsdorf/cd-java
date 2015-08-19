import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;


public class CollectionTest {

  @Rule
   public ClearRule clearRule = new ClearRule();

  @Test
  public void task_instantiatesCorrectly_true() {
    Collection myCollection = new Collection("Boy", "U2");
    assertEquals(true, myCollection instanceof Collection);
  }

  @Test
  public void collection_instantiatesWithTitle_true() {
    Collection myCollection = new Collection("Boy", "U2");
    assertEquals("Boy", myCollection.getTitle());
  }
    //"Made a doll"  Instance object of the class Collection.
    //Returning what is defined in the method

  @Test
  public void collection_instantiatesWithArtist_true() {
    Collection myCollection = new Collection("Boy", "U2");
    assertEquals("U2", myCollection.getArtist());
  }

  @Test
  public void all_returnsAllInstancesOfCollection_true(){
    Collection firstCollection = new Collection("Boy", "U2");
    Collection secondCollection = new Collection("Mi Tierra", "GloriaEstefan");
    assertTrue(Collection.all().contains(firstCollection));
    assertTrue(Collection.all().contains(secondCollection));
  }

  @Test
  public void newId_collectionsInstantiateWithAnID_true() {
    Collection myCollection = new Collection("Mi Tierra", "GloriaEstefan");
    assertEquals(Collection.all().size(), myCollection.getId());
  }

  @Test
  public void find_returnsCollectionWithSameId_secondCollection() {
    Collection firstCollection = new Collection("Boy", "U2");
    Collection secondCollection = new Collection("Mi Tierra", "GloriaEstefan");
    assertEquals(Collection.find(secondCollection.getId()), secondCollection);
    }

  @Test
    public void find_returnsNullWhenNoCollectionFound_null() {
    assertTrue(Collection.find(999) == null);
  }
  @Test
    public void clear_emptiesAllTasksFromArrayList() {
    Collection myCollection = new Collection("Mi Tierra", "GloriaEstefan");
    Collection.clear();
    assertEquals(Collection.all().size(), 0);
}

}
