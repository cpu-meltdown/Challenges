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
        fillListOfFiles( args[0] );

        files.sort( Comparator.comparing( a -> a.getFileSize() ) );

        for ( FileSizePair file : files ) {
            System.out.println( file );
        }
    }
}
