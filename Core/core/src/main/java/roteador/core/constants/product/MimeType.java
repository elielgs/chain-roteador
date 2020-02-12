package roteador.core.constants.product;

/**
 * User: eliel
 * Date: 05/06/13
 * Time: 18:22
 */
public enum MimeType {

    JPEG("image/jpeg", ".jpg"),
    GIF("image/gif", ".gif"),
    PNG("image/png", ".png");

    private String mimeTypeDescription;

    private String extension;

    private MimeType(String mimeTypeDescription, String extension) {
        this.mimeTypeDescription = mimeTypeDescription;
        this.extension = extension;
    }

    public static MimeType getByMimeTypeDescription(String mimeTypeDescription) {
        for(final MimeType mimeType : MimeType.values()) {
            if(mimeType.mimeTypeDescription.equals(mimeTypeDescription)) {
                return mimeType;
            }
        }
        return null;
    }

    public String getMimeTypeDescription() {
        return mimeTypeDescription;
    }

    public void setMimeTypeDescription(String mimeTypeDescription) {
        this.mimeTypeDescription = mimeTypeDescription;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
