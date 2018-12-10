import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author nbaalba
 *
 */
public class Solution {

    private static List<File> files = new ArrayList<>();

    /**
     * This method takes in a directory path and fills the files list by scanning the directory and all of its
     * sub-directories
     * 
     * @param directoryName
     */
    public static void fillListOfFiles( String directoryName ) {
        File directory = new File( directoryName );

        // Get all files from a directory.
        File[] fList = directory.listFiles();
        if ( fList != null )
            for ( File file : fList ) {
                if ( file.isFile() ) {
                    files.add( file );
                } else if ( file.isDirectory() ) {
                    fillListOfFiles( file.getAbsolutePath() );
                }
            }
    }

    /**
     * @param args
     */
    public static void main( String[] args ) {
        if ( args.length == 0 ) {
            System.out.println( "Please pass in the path as a Program Argument" );
            System.exit( 0 );
        }

        fillListOfFiles( args[0] );

        // sort the files based on size
        files.sort( Comparator.comparing( f -> f.length() ) );

        // size is in bytes
        for ( File file : files ) {
            System.out.printf( "%s %s %s \n", file.getAbsolutePath(), file.getName(), file.length() );
        }
    }
}
