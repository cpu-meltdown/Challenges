/**
 * @author nbaalba
 *
 */
public class FileSizePair {
    private String filePath;

    private String fileName;

    private long fileSize;

    public FileSizePair( String filePath, long fileSize ) {
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.fileName = filePath.substring( filePath.lastIndexOf( '/' ) + 1 );
    }

    public long getFileSize() {
        return fileSize;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getFileName() {
        return fileName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format( "%s %s %s", this.filePath, this.fileName, this.fileSize );
    }
}