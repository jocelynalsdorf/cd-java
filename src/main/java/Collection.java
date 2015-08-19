import java.time.LocalDateTime;
import java.util.ArrayList;


public class Collection { //class Task

  private static ArrayList<Collection> instances = new ArrayList<Collection>();

  private String mTitle;
  private String mArtist;
  private LocalDateTime mCreatedAt;
  private int mId;

  //blueprint for creating an object for the constructor Collection
  public Collection(String title, String artist) {
    mTitle = title;
    mArtist = artist;
    mCreatedAt = LocalDateTime.now();
    instances.add(this);
    mId = instances.size(); //total size of the array( 5 tasks = size 5) not indiv. objects
  }// constructor has all the instructions for making a new instance of the class task
  //constructors are named after the class, they are actually methods


  public String getTitle(){
    return mTitle;
  }

  public String getArtist(){
    return mArtist;
  }

  public LocalDateTime getCreatedAt() {
    return mCreatedAt;
  }

  public int getId() {
    return mId;
  }

  public static ArrayList<Collection> all() {
    return instances;
  }

  public static Collection find (int id){
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e){ //built in Java
      return null;
    }
  }

  public static void clear() {
    instances.clear();
  }
} //class Task
