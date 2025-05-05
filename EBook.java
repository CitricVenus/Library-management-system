public class EBook extends Book {

    private String fileFormat;
    private float fileSize;

    public EBook(String title, String author, int ISBN, boolean availability,String fileFormat,float fileSize) {
        super(title, author, ISBN, availability);
        this.fileFormat = fileFormat;
        this.fileSize = fileSize;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        String regex = "^[a-zA-Z]+$";
        if (fileFormat.matches(regex)) {
            this.fileFormat = fileFormat;
        }
    }

    public float getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String showInformation(){
            return super.showInformation() + "( Book Format: " + fileFormat + ", Book Size: " + fileSize + " MB )";

    }

}
