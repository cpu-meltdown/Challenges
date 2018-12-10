import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author nbaalba
 *
 */
public class Solution {

    private static List<FileSizePair> files = new ArrayList<>();

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
                    FileSizePair fileSize = new FileSizePair( file.getAbsolutePath(), file.length() );
                    files.add( fileSize );
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
        files.sort( Comparator.comparing( a -> a.getFileSize() ) );

        // size is in bytes
        for ( FileSizePair file : files ) {
            System.out.println( file );
        }
    }
}
