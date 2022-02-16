package controllers;


import java.io.*;

public class PrefixStorage {

    public static Prefix cache_data;


    //	public Cache_Storage(String fileString) {
    //		// TODO Auto-generated constructor stub
    //		this.filename = fileString;
    //		read();
    //	}

    public static void main(String[] args) {
        //	  	  SavePrefix ( new NoteSpacePath ( "UUID1" , "D:\\NoteSpaceHere\\New folder" ) );
        //	  	  	  SavePrefix ( new NoteSpacePath ( "UUID1" , "D:\\Wallpapers\\Cyberpunk" ) );
        //	  	  	  SavePrefix ( new NoteSpacePath ("UUID2","D:\\NoteSpaceHere\\Space1") );
        SavePrefix(new Prefix("C:\\Users\\Hp\\Desktop\\Test\\Cristina Yang.txt"));


        //	  	  SavePrefix ( new NoteSpacePath ("1","C:\\Users\\Hp\\Downloads\\Video") );
        //		    SavePrefix ( new NoteSpacePath ( "","D:\\NoteSpaceHere\\Folder for delete" ) );

        //	  SavePrefix ( new NoteSpacePath ("1","D:\\Wallpapers\\Red dead 2") );


        //	  NoteSpacePath noteSpacePath = getPrefixObj ( );
        //	  System.out.println ( noteSpacePath.id + noteSpacePath.spacePath );

        System.out.println(getPrefixObj());
        //	  CheckNoteSpacePathExists ( );
        //	  System.out.println ( BuildNoteSpace.CheckNoteSpaceFormat () );

    }

    public static Prefix getPrefixObj() {

        read();
        return cache_data;

    }


    public static void read() {


        File myFile = new File( "busName.tmp");
        if (myFile.exists()) {
            try {
                FileInputStream filein = new FileInputStream( "busName.temp");
                ObjectInputStream in = new ObjectInputStream(filein);
                cache_data = (Prefix) in.readObject();
                filein.close();
                in.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                //				e.printStackTrace();

            }
        } else {
            try {
                myFile.createNewFile();
                //				Cache_Storage cache_Storage = new Cache_Storage(config_path);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    public static void SavePrefix(Prefix cache_data) {
//        RecentNoteSpaceStorage.setRecentNoteSpace(cache_data.spacePath, cache_data.spacePath);
        try {
            FileOutputStream fileout = new FileOutputStream( "busName.temp");
            ObjectOutputStream out = new ObjectOutputStream(fileout);

            out.writeObject(cache_data);
            fileout.close();
            out.close();
            System.out.println("saved");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
