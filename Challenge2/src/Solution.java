import java.io.File;
import java.util.ArrayList;
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
        fillListOfFiles( "/Users/nbaalba/Documents/workspace/" );
        System.out.println( files );
    }

    private static class FileSizePair {
        private String filePath;

        private long fileSize;

        public FileSizePair( String filePath, long fileSize ) {
            this.filePath = filePath;
            this.fileSize = fileSize;
        }

        public long getFileSize() {
            return fileSize;
        }

        public String getFilePath() {
            return filePath;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return this.filePath + " " + this.fileSize;
        }
    }
}
